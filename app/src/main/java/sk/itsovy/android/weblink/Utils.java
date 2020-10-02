package sk.itsovy.android.weblink;

public class Utils {

    public String getWikipediaUrl(String title) {
        title = title.replaceAll(" ", "_");
        return "https://en.wikipedia.org/wiki/" + title;
    }

}
