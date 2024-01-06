package com.chtBot;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            // Create a socket and connect to the server on localhost at port 3000
            Socket socket = new Socket("localhost", 3000);

            // Create input and output streams for communication with the server
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Create a buffered reader to read input from the console
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            // Initialize variables for user input and server reply
            String messge = "";
            String reply = "";

            while(!messge.equals("bye")){

                // Read a line of text from the user
                reply = bufferedReader.readLine();

                // Send the user's message to the server and flush the output stream
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();

                // Receive a message from the server
                messge = dataInputStream.readUTF();
                System.out.println(messge);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
