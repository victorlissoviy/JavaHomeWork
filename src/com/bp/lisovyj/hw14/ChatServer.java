package com.bp.lisovyj.hw14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    static class Handler implements Runnable{
        final Socket socket;
        List<PrintWriter> list;

        public Handler(Socket socket, List<PrintWriter> list){
            this.socket = socket;
            this.list = list;
        }

        @Override
        public void run() {
            System.out.println("Connect " + list.size() + " enable");
            try(BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(),true)){

                synchronized (this){
                    list.add(pw);
                }
                String str;
                while((str = br.readLine()) != null){
                    if(str.equals("exit")){
                        System.out.println("Connect off");
                        pw.println("exit");
                        list.remove(pw);
                        break;
                    }else{
//                        System.out.println(str);
                        for(PrintWriter p : list){
                            p.println(LocalDateTime.now() + "\n" + str);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port = 1234;
        List<PrintWriter> list = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущено!");
            while(true){
                new Thread(new Handler(serverSocket.accept(), list)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
