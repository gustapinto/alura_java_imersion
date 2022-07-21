package alura_stickers_maven.clients;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

public class Fetcher {
    public String fetchBody(String url) {
        try {
            // Faz a requisição e obtém o corpo da resposta como uma String
            HttpClient client = HttpClient.newHttpClient();
            URI uri = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            BodyHandler<String> responseHandler = BodyHandlers.ofString();

            // Faz a requisição e obtém o corpo da resposta como uma String
            HttpResponse<String> response = client.send(request, responseHandler);

            return response.body();
        } catch (IOException | InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }
}
