package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.*;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private volatile boolean clientConnected = false;
    protected Connection connection;

    protected String getServerAddress() {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("ошибка");
            clientConnected = false;
        }
    }

    public void run() {
        String text;
        SocketThread socketThread = getSocketThread();
        getSocketThread().setDaemon(true);
        getSocketThread().start();
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Ошибка запуска");
            clientConnected = false;
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        while (clientConnected) {
            text = ConsoleHelper.readString();
            if (text.equals("exit")) break;

            if (shouldSendTextFromConsole()) {
                sendTextMessage(text);
            }
        }

    }


    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            Message message;
            while (true){
                message = connection.receive();
                if (MessageType.NAME_REQUEST.equals(message.getType())){
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                }else if (MessageType.NAME_ACCEPTED.equals(message.getType())){
                    notifyConnectionStatusChanged(true);
                    break;
                }else throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            Message message;
            while (true){
                message = connection.receive();
                if (MessageType.TEXT.equals(message.getType())){
                    processIncomingMessage(message.getData());
                }else if (MessageType.USER_ADDED.equals(message.getType())){
                    informAboutAddingNewUser(message.getData());
                }else if (MessageType.USER_REMOVED.equals(message.getType())){
                    informAboutDeletingNewUser(message.getData());
                }else throw new IOException("Unexpected MessageType");
            }
        }


        @Override
        public void run() {
            try {
                connection = new Connection(new Socket(getServerAddress(), getServerPort()));
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e ) {
                notifyConnectionStatusChanged(false);
            }


        }
    }

    public static void main(String[] args) {
        new Client().run();
    }
}
