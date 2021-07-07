package lesson6;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)){
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
    // текст запроса
//            String text = "GET /\\n\\n";
//            String text = "GET /get\\n\\n";
            String text = "POST /post\n\n";

    // отправка запроса
            out.write((text).getBytes());

    // получение ответа от сервера
            int t;
            while ((t = in.read()) > -1 ) {
                System.out.print((char) t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
