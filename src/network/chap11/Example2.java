package network.chap11;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Example2 {

    public static void main(String[] args) throws IOException {
        String list_url = "https://www.skhu.ac.kr/skhu/1038/subview.do";
        Document document = Jsoup.connect(list_url).get();
        Elements tr_list = document.select("table.board-table.horizon1 tbody tr");
        for (Element tr : tr_list ) {
            Element a = tr.selectFirst("td.td-subject a");
            String article_url = a.attr("href");
            String title = a.text();
            System.out.println(article_url + " " + title);
        }
    }
}
