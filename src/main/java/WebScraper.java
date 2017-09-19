import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
/**
 * Retrieve contents from a URL and return them as a string.
 */
public class WebScraper {
    /**
     *
     * @param url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        int count = 0;
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        for (int i = 0; i < contents.length(); i++) {
            if (Character.isWhitespace(contents.charAt(i))) {
                count += 1;
            }
        }
        urlScanner.close();
        System.out.println(count);
        return contents;
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     * @param args does smt
     */
    public static void main(final String[] args) {
        urlToString("http://erdani.com/tdpl/hamlet.txt");
    }

}
