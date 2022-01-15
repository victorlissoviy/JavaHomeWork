package ChatClient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HelloController {
    public Button enterButton;
    public Button exitButton;
    public TextField textLine;
    public TextArea textArea;
    private Socket socket;
    private Boolean connect = false;
    private PrintWriter pw;
    private BufferedReader br;

    private void sendMessage(){
        String str = textLine.getText();
        pw.println(str);
        textLine.clear();
    }

    private void readMessages(){
        String str;
        try {
            while((str = br.readLine()) != null){
                textArea.appendText(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exitEvent(ActionEvent event){
        event.consume();
        if(socket != null && socket.isConnected()){
            try {
                pw.println("exit");
                br.close();
                pw.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void sendMessageEvent(ActionEvent event) {
        if(!connect){
            return;
        }
        event.consume();
        sendMessage();
    }

    @FXML
    public void sendMessageLine(KeyEvent keyEvent) {
        if(!connect){
            return;
        }
        if( keyEvent.getCode() == KeyCode.ENTER ) {
            keyEvent.consume();
            sendMessage();
        }
    }

    @FXML
    public void connectToServer(ActionEvent actionEvent){
        actionEvent.consume();
        if(connect){
            return;
        }
        int port = 1234;
        try{
            socket = new Socket("localhost", port);
            pw = new PrintWriter(socket.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            new Thread(this::readMessages).start();
        }catch (IOException e){
            e.printStackTrace();
        }
        connect = true;
        textArea.appendText("З'єднання відбулось\n");
    }
}