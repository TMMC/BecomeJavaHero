package pl.edu.bogdan.training.patterns.adapter.example;

public class Adapter implements HttpConnection {
	private final TcpConnection connection;
	
	public Adapter(TcpConnection connection) {
		this.connection = connection;
	}
	
	@Override
	public String doGet(String s) {
		return connection.sendPackage(s, "127.0.0.1");
	}

}
