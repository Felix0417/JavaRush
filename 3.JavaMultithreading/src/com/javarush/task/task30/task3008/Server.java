package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()){
            try {
                entry.getValue().send(message);
            }catch (IOException e){
                System.out.println("не смогли отправить сообщение");
            }
        }
    }

    private static class Handler extends Thread {
        Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message msg;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                msg = connection.receive();
                if (msg.getType().equals(MessageType.USER_NAME) && !connectionMap.containsKey(msg.getData())
                        && !msg.getData().equals("")) {
                    connectionMap.put(msg.getData(), connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return msg.getData();
                }
            }

        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry <String, Connection> user : connectionMap.entrySet()){
                if (!user.getKey().equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED, user.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            Message message;
            while (true){
                message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT,
                            userName + ": " + message.getData()));
                }else if (message.getType() != MessageType.TEXT){
                    ConsoleHelper.writeMessage("принятое сообщение не является текстом");
                }
            }
        }

        @Override
        public void run() {
            System.out.println(socket.getRemoteSocketAddress());
            String newUserName = "";
            try (Connection connection = new Connection(socket)) {
                newUserName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUserName));
                notifyUsers(connection,newUserName);
                serverMainLoop(connection, newUserName);
                if (newUserName != null){
                    connectionMap.remove(newUserName);
                }
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUserName));
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage(e.getMessage());

                }
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
