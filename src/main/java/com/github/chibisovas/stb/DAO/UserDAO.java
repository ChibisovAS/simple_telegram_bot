package com.github.chibisovas.stb.DAO;

import com.github.chibisovas.stb.models.Article;
import com.github.chibisovas.stb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveUser(User user) {
        jdbcTemplate.update("INSERT INTO user(chat_id, last_article_id) VALUES(?,null)",user.getChatID());
    }
    public void setUserLastChatID(User user) {
        jdbcTemplate.update("UPDATE user SET last_article_id = ? WHERE  chat_id = ?",user.getLastArticleID(),user.getChatID());
    }

}
