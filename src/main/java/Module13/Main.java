package Module13;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static final String USERS = "https://jsonplaceholder.typicode.com";
    public static void main(String[] args) throws IOException, InterruptedException {

        User user = new User();
        user.setId(1);
        user.setName("Oleksandr");
        user.setUserName("Oleksandr11");
        user.setEmail("rogozkin371@gmail.com");
        User userCreate = Utils.createNewObject(user, URI.create(USERS));
        System.out.println(userCreate);
    }



}
