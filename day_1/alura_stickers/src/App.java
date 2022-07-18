import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://alura-imdb-api.herokuapp.com/movies";

        // Abre novo cliente HTTP para lidar com a requisição Get
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        BodyHandler<String> responseHandler = BodyHandlers.ofString();

        // Faz a requisição e obtém o corpo da resposta como uma String
        String json = client.send(request, responseHandler).body();

        // Usa regex para obter os dados de título, poster e classificação
        // a partir do Json
        JsonParser parser = new JsonParser();
        List<Map<String, String>> movies = parser.parse(json);

        // Exibe todos os filmes
        for (Map<String, String> movie : movies) {
            System.out.println(movie);
            System.out.println();
        }
    }
}
