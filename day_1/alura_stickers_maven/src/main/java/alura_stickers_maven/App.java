package alura_stickers_maven;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URL;
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

        // Cria novo gerador de imagens
        StickerGenerator generator = new StickerGenerator();

        // Exibe todos os filmes
        for (Map<String, String> movie : movies) {
            String title = movie.get("title");
            String imageUrl = movie.get("image").replace("_V1_UX128_CR0,3,128,176_AL_", "");
            System.out.println("Generating image for movie " + title);

            try {
                generator.generate(title, "Topzera", new URL(imageUrl).openStream());
            } catch (FileNotFoundException e) {
                System.out.println("Generating image for movie " + title + " failed");
                continue;
            }

            System.out.println("Generating image for movie " + title + " success");
        }
    }
}

