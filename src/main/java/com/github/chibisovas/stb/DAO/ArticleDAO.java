package com.github.chibisovas.stb.DAO;


import com.github.chibisovas.stb.models.Article;
import com.github.chibisovas.stb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ArticleDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveArticle(Article article) {
        jdbcTemplate.update("INSERT INTO article(name, url) VALUES(?,?)",article.getName(),article.getURL());
    }

    public Article getUnshownArticleByUser(User user) {
        return  jdbcTemplate.query(
                "SELECT name,url FROM article WHERE article.id > ?",
                new BeanPropertyRowMapper<Article>(Article.class), user.getLastArticleID())
                .stream().findFirst().orElse(null);
    }
    // костыль для теста
    public Article showOne() {
        return jdbcTemplate.query("SELECT name,url FROM article",new BeanPropertyRowMapper<Article>(Article.class))
                .stream().findFirst().orElse(null);
    }


}
