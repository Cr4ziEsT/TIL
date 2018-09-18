package my.examples.chat;

import my.examples.chat.ChatServer;

public class Main {
    public static void main(String[] args){
        ChatServer chatServer = new ChatServer(11000);
        chatServer.start();
    }
}


/*
import java.net.Socket;

public class Main{
    public static void main(String[] args){
        ChatServer chatServer = new ChatServer(11500);
        chatServer.start();
    }
}

*/











