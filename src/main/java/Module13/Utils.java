package Module13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Utils {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();
    public static User createNewObject(User user, URI uri) throws IOException, InterruptedException {
        String restructuredBody=GSON.toJson(user);
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(uri)))
                .POST(HttpRequest.BodyPublishers.ofString(restructuredBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());

        return GSON.fromJson(response.body(),User.class) ;

    }
        public static User renewObject(User user, URI uri, int id) throws IOException, InterruptedException {
            String restructuredBody=GSON.toJson(user);
            HttpRequest request=HttpRequest.newBuilder()
                    .uri(URI.create(uri+"/"+id))
                    .PUT(HttpRequest.BodyPublishers.ofString(restructuredBody))
                    .header("Content-type", "application/json")
                    .build();
            HttpResponse<String> response =
                    CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());

            return GSON.fromJson(response.body(),User.class) ;


    }
    public static void deleteObject(URI uri, int id) throws IOException, InterruptedException {
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create((uri+"/"+id)))
                .DELETE()
                .build();
        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }
    public static List<User> getInformationAboutAllObject(URI uri) throws IOException, InterruptedException {
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(uri)))
                .GET()
                .build();
        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        Type userList = new TypeToken<List<User>>(){}.getType();
        return GSON.fromJson(response.body(),userList);

    }
    public static User getInformationAboutObjectFromId(URI uri, int id) throws IOException, InterruptedException {
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(uri+"/"+id)))
                .GET()
                .build();
        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        return GSON.fromJson(response.body(), User.class);
    }
//    public static getInformationAboutObjectFromName(){
//
//    }

}
