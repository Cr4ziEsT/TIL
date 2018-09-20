package my.examples.http;

public class MiniWAS extends Thread {
    @Override
    public void run() {
        Connector connector = new Connector(8080);
        connector.run();
    }
}