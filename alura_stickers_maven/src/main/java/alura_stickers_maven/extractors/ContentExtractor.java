package alura_stickers_maven.extractors;

import java.util.List;

import alura_stickers_maven.models.Content;

public interface ContentExtractor {
    List<Content> extract(String json) throws Exception;
}
