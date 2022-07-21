package alura_stickers_maven.downloaders;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;

import alura_stickers_maven.clients.Fetcher;
import alura_stickers_maven.clients.StickerGenerator;
import alura_stickers_maven.models.Content;
import alura_stickers_maven.extractors.ContentExtractor;

public class ContentStickerDownloader {
    public void download(ContentExtractor extractor, String url) throws Exception {
        Fetcher fetcher = new Fetcher();
        StickerGenerator generator = new StickerGenerator();

        String json = fetcher.fetchBody(url);
        List<Content> contents = extractor.extract(json);

        for (Content content : contents) {
            String title = content.getTitle();
            String imageUrl = content.getImageUrl();

            try {
                generator.generate(title, "Topzera", new URL(imageUrl).openStream());
            } catch (FileNotFoundException e) {
                System.out.println("Generating image for " + title + " failed");
                continue;
            }
        }
    }
}
