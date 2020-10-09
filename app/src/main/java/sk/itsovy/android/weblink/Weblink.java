package sk.itsovy.android.weblink;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Weblink implements Serializable {

    private UUID uuid;
    private String title;
    private int rating;
    private String url;

    public Weblink(String title) {
        this(title, 3);
    }

    public Weblink(String title, int rating) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.rating = rating;
        this.url = Utils.getWikipediaUrl(title);
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weblink weblink = (Weblink) o;
        return Objects.equals(uuid, weblink.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
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
