package sk.itsovy.android.weblink;

public class Weblink {

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
