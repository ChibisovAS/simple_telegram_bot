package com.github.chibisovas.stb.DAO;

import com.github.chibisovas.stb.models.Article;
import com.github.chibisovas.stb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDAO extends AbstractDAO {

    public static void saveUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(chat_id, last_article_id) VALUES(?,?)");

            preparedStatement.setLong(1,user.getChatID());
            preparedStatement.setLong(2,user.getLastArticleID());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean checkUser(User user) {
        boolean isUserExist = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE chat_id = ?");
            preparedStatement.setLong(1, user.getChatID());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                isUserExist = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return isUserExist;
    }

    public static void setUserLastArticleID(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET last_article_id = ? WHERE chat_id = ?");

            preparedStatement.setLong(1,user.getLastArticleID());
            preparedStatement.setLong(2,user.getChatID());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static long getUserLastArticleID(User user) {
        long lastArticleID = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT last_article_id FROM user WHERE chat_id = ?");

            preparedStatement.setLong(1,user.getChatID());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            lastArticleID =  resultSet.getLong("last_article_id");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lastArticleID;
    }
    public static void removeUser(User user) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE chat_id = ?");

            preparedStatement.setLong(1,user.getChatID());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
