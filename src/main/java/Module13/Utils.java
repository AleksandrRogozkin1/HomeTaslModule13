package Module13;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Utils {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();
    public static User createNewObject(User user, URI uri) throws IOException, InterruptedException {
        String restructuredBody=GSON.toJson(user);
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(uri+"/users"))
                .POST(HttpRequest.BodyPublishers.ofString(restructuredBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("POST " + response.statusCode());

        return GSON.fromJson(response.body(),User.class) ;

    }
    //    public static renewObject(){
//
//    }
//    public static deleteObject(){
//
//    }
//    public static getInformationAboutAllObject(){
//
//    }
//    public static getInformationAboutObjectFromId(){
//
//    }
//    public static getInformationAboutObjectFromName(){
//
//    }

}
