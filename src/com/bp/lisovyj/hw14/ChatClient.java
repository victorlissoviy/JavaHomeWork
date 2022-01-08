package com.bp.lisovyj.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.exit;

public class ChatClient {
    private static boolean end = false;

    public static void read(BufferedReader br) {
        String str;
            try {
                while((str = br.readLine()) != null){
                    if(str.equals("exit")){
                        end = true;
                        exit(0);
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        int port = 1234;

        try(Socket socket = new Socket("localhost", port);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in))){

            System.out.println("Client Start");
            new Thread(() -> read(br)).start();
            String str;
            while(!end && (str = sin.readLine()) != null){
                pw.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
