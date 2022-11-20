import org.jsoup.Jsoup;

public class TakeDataFromBrowser {
    private static final String TARGET_URL = "https://ekaterinburg.careerist.ru/cvs-ofitsiant/";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";

    public static WorkerManager getWaitersFromBrowser() {
        WorkerManager waiters = new WorkerManager();
        try {
            var document = Jsoup.connect(TARGET_URL).userAgent(USER_AGENT).referrer("http://www.google.com").get();
            for (var i = 4; i <= 33; i++) {
                var nameSurname = document
                        .select(String.format("#resume-tag > div > div:nth-child(%s) > div.list-block > div.block-with-big-foto > div.pull-md-left > p", i))
                        .get(0).text() + " -";
                var ages = document
                        .select(String.format("#resume-tag > div > div:nth-child(%s) > div.list-block > div.block-with-big-foto > div.pull-md-left > div > p:nth-child(5)", i));
                var age = ages.size() == 0 ? "-1" : ages.get(0).text();
                var exps = document
                        .select(String.format("#resume-tag > div > div:nth-child(%s) > div.list-block > div.block-with-big-foto > div.pull-md-left > div > p:nth-child(8)", i));
                var exp = exps.size() == 0 ? "Без опыта" : exps.get(0).text();
                exp = exp.equals("Без опыта") ? "0" : exp.split(" ")[0];
                waiters.addWorker(new Waiter(i, nameSurname.split(" ")[0], nameSurname.split(" ")[1],
                        Integer.parseInt(age.split(" ")[0]),
                        Integer.parseInt(exp),
                        i * 10 + i % 3, 24));
            }
            return waiters;
        } catch (Exception e) {
            throw new RuntimeException("Error conection, data don't download");
        }
    }
}



