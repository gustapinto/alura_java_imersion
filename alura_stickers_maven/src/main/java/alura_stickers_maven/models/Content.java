package alura_stickers_maven.models;

public class Content {
    private final String title;
    private final String imageUrl;

    public Content(String title, String url) {
        this.title = title;
        this.imageUrl = url;
    }

    public String getTitle() {
        return this.title;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
}
