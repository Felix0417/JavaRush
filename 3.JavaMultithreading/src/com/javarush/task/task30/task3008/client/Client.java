package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

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

    public static class SocketThread extends Thread {

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        new Client().run();
    }
}
