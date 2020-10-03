package sk.itsovy.android.weblink;

import java.io.Serializable;

public class Weblink implements Serializable {

    private String title;
    private int rating;
    private String url;

    public Weblink(String title) {
        this(title, 3);
    }

    public Weblink(String title, int rating) {
        this.title = title;
        this.rating = rating;
        this.url = Utils.getWikipediaUrl(title);
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
        this.url = Utils.getWikipediaUrl(title);
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public String getUrl() {
        return url;
    }
}
