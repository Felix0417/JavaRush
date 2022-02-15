package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static class Handler extends Thread {
        Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void main(String[] args) throws IOException {
        int serverSock = ConsoleHelper.readInt();
        ServerSocket serverSocket = new ServerSocket(serverSock);
        System.out.println("Сервер запущен!");

        Socket socket;

        while (true) {
            try {
                socket = serverSocket.accept();
                new Handler(socket).start();
            } catch (Exception e) {
                try {
                    serverSocket.close();
                    break;
                }catch (Exception f) {
                    f.printStackTrace();
                }
            }
        }
    }
}
