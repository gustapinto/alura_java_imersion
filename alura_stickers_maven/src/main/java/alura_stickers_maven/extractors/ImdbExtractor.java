package alura_stickers_maven.extractors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import alura_stickers_maven.models.Content;
import alura_stickers_maven.parsers.JsonParser;

public class ImdbExtractor implements ContentExtractor {
    public List<Content> extract(String json) throws Exception {
        JsonParser parser = new JsonParser();

        List<Map<String, String>> data = parser.parse(json);
        List<Content> contents = new ArrayList<>();

        for (Map<String, String> d : data) {
            String title = d.get("title");
            String url = d.get("image").replace("_V1_UX128_CR0,3,128,176_AL_", "");

            Content content = new Content(title, url);

            contents.add(content);
        }

        return contents;
    }
}
