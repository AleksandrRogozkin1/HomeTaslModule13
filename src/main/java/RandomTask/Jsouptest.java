package RandomTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.math.BigDecimal;

public class Jsouptest {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://bt.rozetka.com.ua/ua/365136075/p365136075/")
                .get();
        Element element = document.selectFirst("p.product-price__big");
        System.out.println(element.text());

        long parseLong=Long.parseLong(element.text().replace(" ","").replace("₴",""));
        System.out.println(parseLong);



    }
}
