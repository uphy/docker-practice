import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.OutputStream;
import java.io.IOException;

public class SimpleHttpServer {

    public static void main(String... args) throws IOException {
        final HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/tellme", t->{
            final String query = t.getRequestURI().getQuery();
            final String response = query.hashCode() % 2 == 0 ? "Yes" : "No";
            t.sendResponseHeaders(200, response.length());
            final OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();

            System.out.printf("Question : %s%n", query);
            System.out.printf("Answer   : %s%n", response);
        });
        server.setExecutor(null);
        server.start();
        System.out.println("Server started.");
    }

}