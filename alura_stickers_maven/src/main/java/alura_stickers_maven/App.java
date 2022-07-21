package alura_stickers_maven;

import alura_stickers_maven.extractors.NasaExtractor;
import alura_stickers_maven.extractors.ImdbExtractor;
import alura_stickers_maven.downloaders.ContentStickerDownloader;

public class App {
    public static void main(String[] args) throws Exception {
        ContentStickerDownloader downloader = new ContentStickerDownloader();

        NasaExtractor nasaExtractor = new NasaExtractor();
        String nasaUrl = "https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope";

        ImdbExtractor imdbExtractor = new ImdbExtractor();
        String imdbUrl = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";

        downloader.download(nasaExtractor, nasaUrl);
        downloader.download(imdbExtractor, imdbUrl);
    }
}

