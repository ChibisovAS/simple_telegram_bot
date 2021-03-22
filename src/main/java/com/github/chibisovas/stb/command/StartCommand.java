package com.github.chibisovas.stb.command;

import com.github.chibisovas.stb.DAO.ArticleDAO;
import com.github.chibisovas.stb.DAO.UserDAO;
import com.github.chibisovas.stb.models.Article;
import com.github.chibisovas.stb.models.User;
import com.github.chibisovas.stb.parser.JavaRushParser;
import com.github.chibisovas.stb.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;


public class StartCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE = "Привет! Начинаю поиск статей.\n" +
            "Что бы узнать, что я нашел напиши /show";

    @Autowired
    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        JavaRushParser.parseNews();
        for (Article a: JavaRushParser.getARTICLES()) {
            ArticleDAO.saveArticle(a);
        }
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),START_MESSAGE);

        // Проверяем есть ли User в БД и если нет кладем Юзера в БД
        if (!UserDAO.checkUser(new User(update.getMessage().getChatId()))) {
            UserDAO.saveUser(new User(update.getMessage().getChatId(),ArticleDAO.getFirstArticleID()));
        }

    }
}
