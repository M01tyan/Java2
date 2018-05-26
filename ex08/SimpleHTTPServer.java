import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;


public class SimpleHTTPServer {

  private final int port;

  public SimpleHTTPServer(int port)
  {
    this.port = port;
  }

  public void start() {
    // TODO
    // Start a ServerSocker
    // wait for connection
    // then send the corresponding socket to an instance of Handler
    // and let it handle the request
      try{
	  ServerSocket ss = new ServerSocket(port);
	  while(true){
	      try{
		  Socket connection = ss.accept();
		  Handler socket = new Handler(connection);
		  socket.start();
	      } catch(Exception e){
		  System.out.println("Exception: " + e);
	      }
	  }
      } catch(Exception e){
	  System.out.println("Exception: "+e);
      }
  }

  private class Handler {
    private final Socket connection;

    Handler(Socket connection) {
      this.connection = connection;
    }

    public void start() {
      // Get InputStream and OutputStream from the socket.
      //
      // 1. read the request from the client.
      // 2. if it is not starting by "GET" then ignore
      // 3. otherwise, extract the file name from the request.
      // It will look like: "GET /filename.html HTTP/1.1"
      // You can split the string by whitespaces.
      // 4. open the file and reads its content
      // 5. create an HTTP header
      // 6. send the header then the content via the OutputStream
	try{
	    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    OutputStream out = connection.getOutputStream();	    
	    String read;
	    while(true){
		read = reader.readLine();
		if(read.indexOf("GET") == -1) continue;
		String[] str = read.split(" ", 0);
		String str1 = str[1].replace("/", "");
		try {
		    		    
		    File file = new File(str1); // to be initialized somewhere with the obtained filename
		    byte[] content;
		    content = Files.readAllBytes(file.toPath());
		    
		    String headerStr = "HTTP/1.0 200 OK\r\n"
			+ "Server: SimpleHTTPServer\r\n"
			+ "Content-length: " + content.length + "\r\n"
			+ "Content-type: text/html"
			+ "; charset=utf-8" + "\r\n\r\n";
		    byte[] header = headerStr.getBytes(Charset.forName("UTF-8"));
		    
		    // send the header then the content as byte[] via the OutputStream
		    out.write(header);
		    out.write(content);

		    out.close();
		    break;
		} catch(IOException e){
		    File file = new File("404.html"); // to be initialized somewhere with the obtained filename
		    byte[] content;
		    content = Files.readAllBytes(file.toPath());
		    
		    String headerStr = "HTTP/1.0 404 NO\r\n"
			+ "Server: SimpleHTTPServer\r\n"
			+ "Content-length: " + content.length + "\r\n"
			+ "Content-type: text/html"
			+ "; charset=utf-8" + "\r\n\r\n";
		    byte[] header = headerStr.getBytes(Charset.forName("UTF-8"));
		    
		    // send the header then the content as byte[] via the OutputStream
		    out.write(header);
		    out.write(content);

		    out.close();
		    break;
		}
	    }
	} catch(Exception e){
	    // System.out.println("Exception: "+e);
	}
      return;
    }
  }


  public static void main(String[] args) {
    int port;
    try {
      port = Integer.parseInt(args[0]);
      if (port < 1024 || port > 65535) port = 8080;
    } catch (RuntimeException ex) {
      port = 8080;
    }

    try {
      SimpleHTTPServer server = new SimpleHTTPServer(port);
      server.start();

    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.println("Usage: java SimpleHTTPServer [port]");
    }
  }

}
