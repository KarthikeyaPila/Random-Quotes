import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class RandomQuotes {
    public static void main (String[] args) throws InterruptedException, IOException {
        HttpClient client = HttpClient.newBuilder()
            .version(Version.HTTP_1_1)
            .build();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://uselessfacts.jsph.pl/api/v2/facts/random?language=en"))
            .build();
    
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println(jsonExtractText(response.body()));
    }

    static String jsonExtractText (String str) {
        return str.split("\",\"")[1].split("\":\"")[1];
    }
}