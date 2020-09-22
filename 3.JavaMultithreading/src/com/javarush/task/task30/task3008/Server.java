package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST, "Представьтесь, пожалуйста: "));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    String userName = message.getData();
                    if (userName != null && !userName.isEmpty() && !connectionMap.containsKey(userName)) {
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED, userName + ", вы добавлены к чату "));
                        return userName;
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String s : connectionMap.keySet()) {
                if (!userName.equals(s)) {
                    connection.send(new Message(MessageType.USER_ADDED, s));
                }
            }
        }


        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String text = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, text));
                } else {

                    ConsoleHelper.writeMessage("Неправильное сообщение: " + message);
                }
            }
        }

        @Override
        public void run() {
            try {
                // 1. Метод run() должен выводить на экран сообщение о том, что было установлено соединение с удаленным адресом (используя метод getRemoteSocketAddress()).
                ConsoleHelper.writeMessage("установлено соединение с удаленным адресом: " + socket.getRemoteSocketAddress());
                // 2. Метод run() должен создавать новое соединение (connection) используя в качестве параметра поле socket.
                Connection connection = new Connection(socket);
                // 3. Метод run() должен вызывать метод serverHandshake() используя в качестве параметра только что созданное соединение; результатом будет имя пользователя (userName).
                String userName = serverHandshake(connection);
                // 4. Метод run() должен вызывать метод sendBroadcastMessage() используя в качестве параметра новое сообщение (MessageType.USER_ADDED, userName).
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                // 5. Метод run() должен вызывать метод notifyUsers() используя в качестве параметров connection и userName.
                notifyUsers(connection, userName);
                // 6. Метод run() должен вызывать метод serverMainLoop используя в качестве параметров connection и userName.
                serverMainLoop(connection, userName);
                // 7. Прежде чем завершиться, метод run() должен удалять из connectionMap запись соответствующую userName, и отправлять всем участникам чата сообщение о том, что текущий пользователь был удален.
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                //8. Метод run() должен корректно обрабатывать исключения IOException и ClassNotFoundException.
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка: " + e.getMessage());
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> c : connectionMap.entrySet()) {
            Connection connection = c.getValue();
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.printf("Не смогли отправить сообщение '%s' '%s' '%s'", c.getKey(), c.getValue(), message);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Введите порт сервера: ");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен...");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            } catch (Exception e) {
                serverSocket.close();
                e.printStackTrace();
                break;
            }
        }

    }
}
