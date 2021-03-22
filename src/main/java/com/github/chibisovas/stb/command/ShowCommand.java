package com.github.chibisovas.stb.command;

import com.github.chibisovas.stb.DAO.ArticleDAO;
import com.github.chibisovas.stb.DAO.UserDAO;
import com.github.chibisovas.stb.models.Article;
import com.github.chibisovas.stb.models.User;
import com.github.chibisovas.stb.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.telegram.telegrambots.meta.api.objects.Update;


public class ShowCommand implements Command{

    private final SendBotMessageService sendBotMessageService;


    @Autowired
    public ShowCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;

    }

    @Override
    public void execute(Update update) {
        // получаем ID последней запрошеной User'ом статьи
        Long chatID = update.getMessage().getChatId();
        User user = new User(chatID);
        long userLastArticleID = UserDAO.getUserLastArticleID(user);


        // проверяем, все ли статьи показаны
        if(ArticleDAO.getLastArticleID() == userLastArticleID) {
            sendBotMessageService.sendMessage(chatID.toString(), "Пока новых статей нет. Возвращайся позже!");
        } else {
            // получаем статью
            Article article = ArticleDAO.showOne(userLastArticleID);
            // отправляем данные в telegram
            sendBotMessageService.sendMessage(chatID.toString(), article.toString());
            // меняем значение id последней статьи для User
            user.setLastArticleID(++userLastArticleID);
            UserDAO.setUserLastArticleID(user);
        }

}

}
