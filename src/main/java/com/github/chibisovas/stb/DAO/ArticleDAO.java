package com.github.chibisovas.stb.DAO;


import com.github.chibisovas.stb.models.Article;
import org.springframework.stereotype.Component;
import java.sql.*;

@Component
public class ArticleDAO extends AbstractDAO {

    public static void saveArticle(Article article) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO article(name, url) VALUES(?,?)");
            preparedStatement.setString(1, article.getName());
            preparedStatement.setString(2, article.getURL());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    // показывает 1 статью
    public static Article showOne(Long getLastArticleID) {
        Article article = new Article();

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT name,url FROM article WHERE article.id > ?");

            preparedStatement.setLong(1, getLastArticleID);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            article.setName(resultSet.getString("name"));
            article.setURL(resultSet.getString("url"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return article;

    }

    public static long getFirstArticleID() {
        long firstID = 0;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT id FROM article ORDER BY id LIMIT 1");

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            firstID = resultSet.getInt("id");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return firstID;
    }

    public static long getLastArticleID() {
        long lastID = 0;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT id FROM article ORDER BY id DESC LIMIT 1");

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            lastID = resultSet.getInt("id");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lastID;
    }
}
