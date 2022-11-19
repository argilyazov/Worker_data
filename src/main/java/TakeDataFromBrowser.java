import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;


public class TakeDataFromBrowser {
    private static final String TARGET_URL = "https://www.avito.ru/ekaterinburg/noutbuki?cd=1&s=2";
    private static final String outputPath = "texts_from_web";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";

    public static void func() {
        try {
            Document document = Jsoup.connect(TARGET_URL).userAgent(USER_AGENT).referrer("http://www.google.com").get();
            Elements elements = document.select("div.b-personnel.t-big_first.t-reg");
            List<String> lines = new ArrayList<>();

            elements.forEach(element -> {
                String class_a = element.attr("class");
                var s =element.text();
                if (s.contains("Шорнинг"))
                    System.out.println(s);
                if (class_a.equals("b-personnel__card-title empty_info")) {
                    lines.add(element.text());
                }
            });

            Path file = Paths.get("warning.txt");
            try {
                Files.write(file, lines, StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void func1() {

    }
}


