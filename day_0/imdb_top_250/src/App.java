import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws Exception {
        var url = "https://alura-imdb-api.herokuapp.com/movies";
        URI uri = URI.create(url); // Cria uma nova URI para uso no client

        // Abre um cliente HTTP
        var client = HttpClient.newHttpClient();

        // Faz uma requisição GET criando request e response e as
        // processando com o cliente HTTP
        var request = HttpRequest.newBuilder(uri).build();
        var responseHandler = HttpResponse.BodyHandlers.ofString();
        var json = client.send(request, responseHandler).body();

        // Exibe o json exraído da API do IMDB
        System.out.println(json);
    }
}

