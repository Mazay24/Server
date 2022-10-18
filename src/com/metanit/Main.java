package com.metanit;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception{
        try(Socket socket = new Socket("localhost", 1020)){
            for(int i = 0; i < 10; i++){
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(i);
                outputStream.flush();

                InputStream inputStream = socket.getInputStream();
                int response = inputStream.read();
                System.out.println("Клеент " +response);
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
