package com.github.chibisovas.stb.command;

import com.github.chibisovas.stb.DAO.ArticleDAO;
import com.github.chibisovas.stb.models.Article;
import com.github.chibisovas.stb.parser.JavaRushParser;
import com.github.chibisovas.stb.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.telegram.telegrambots.meta.api.objects.Update;


public class StartCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    // жалкая попытка подключить JdbcTemplate
    private static final ArticleDAO articleDAO = new ArticleDAO(new JdbcTemplate());

    public final static String START_MESSAGE = "Привет. Ищю новые статьи с JavaRush!";

    @Autowired
    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        JavaRushParser.parseNews();
        for (Article a: JavaRushParser.getARTICLES()) {
            articleDAO.saveArticle(a);
        }

        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),START_MESSAGE);
    }
}
