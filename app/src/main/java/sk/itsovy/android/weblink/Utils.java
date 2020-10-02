package sk.itsovy.android.weblink;

public class Utils {

    public static String getWikipediaUrl(String title) {
        title = title.replaceAll(" ", "_");
        return "https://en.wikipedia.org/wiki/" + title;
    }

}
