package my.examples.http;

public class Main {
    public static void main(String[] args){
        Connector connector = new Connector(8080);
        connector.start();
    }
}
