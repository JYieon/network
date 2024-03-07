package network.chap11;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Example4 {

    static void getPage(int page) throws IOException {
        // 페이지 번호 query string이 포함된 URL
        String list_url = "https://www.skhu.ac.kr/skhu/1038/subview.do?page=" + page;

        Document document = Jsoup.connect(list_url).get();
        Elements tr_list = document.select("table.board-table.horizon1 tbody tr");
        for (Element tr : tr_list ) {
            Element a = tr.selectFirst("td.td-subject a");
            String article_url = a.attr("href");
            String title = a.text();
            System.out.println(article_url + " " + title);

            Document doc2 = Jsoup.connect("https://www.skhu.ac.kr/" + article_url).get();
            Element div = doc2.selectFirst("div.view-con");
            String content = div.text();
            System.out.println(content + "\n\n");
        }
    }

    public static void main(String[] args) throws IOException {
        String list_url = "https://www.skhu.ac.kr/skhu/1038/subview.do";
        Document document = Jsoup.connect(list_url).get();

        // 마지막 페이지 링크 a 태그를 찾고, href 값을 꺼낸다.
        Element last_a = document.selectFirst("div._paging div._inner a._last");
        String hrefValue = last_a.attr("href");

        // href 값에서 숫자 부분만 추출한다.
        Pattern pattern = Pattern.compile("[0-9]+"); // 숫자 부분 정규식 패턴
        Matcher matcher = pattern.matcher(hrefValue);
        if (matcher.find()) { // 숫자 부분을 찾았으면
            String lastPage = matcher.group(0); // 찾은 부분을 꺼낸다
            int lastPageNo = Integer.parseInt(lastPage); // int 타입으로 변환

            // 1번 페이지부터 마지막 페이지까지 크롤링
            for (int page = 1; page <= lastPageNo; ++page) {
				getPage(page);
			}
        } else {
            System.out.println("lastPageNo not found");
        }
    }
}
