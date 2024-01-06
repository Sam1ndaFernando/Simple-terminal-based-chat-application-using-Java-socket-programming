package com.chtBot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            Socket socket = serverSocket.accept();
            System.out.println("Accepted");

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String message = "";
            String reply = "";

            while(!message.equals("bye")){

                message = dataInputStream.readUTF();
                System.out.println(message);

                reply = bufferedReader.readLine();

                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}