package com.github.chibisovas.stb.models;

public class Article {
    private String name;
    private String URL;

    public Article() {
    }

    public Article(String name, String URL) {
        this.name = name;
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return String.format("<b> %s </b>\n" +
                            "Ссылка: \n" +
                            "%s", name, URL);


    }
}
