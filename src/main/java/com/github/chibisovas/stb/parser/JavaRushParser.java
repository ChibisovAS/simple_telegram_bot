package com.github.chibisovas.stb.parser;

import com.github.chibisovas.stb.models.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class JavaRushParser {

    private static final Set<Article> ARTICLES = new LinkedHashSet<>();

    public static Set<Article> getARTICLES() {
        return ARTICLES;
    }

    public static Set<Article> parseNews() {

        Document document = null;
        try {
            //TO DO
            // парсит только 1ую страницу
            document = Jsoup.connect("https://javarush.ru/groups/posts?page=1").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.getElementsByAttributeValue("class ", "post-card__content");

        elements.forEach(element -> {
            Element e = element.child(0);
            String name = e.child(0).text();
            String url = e.baseUri() + e.attr("href").substring(1);
            Article article = new Article(name, url);
            ARTICLES.add(article);
        });

        return ARTICLES;
    }
}
