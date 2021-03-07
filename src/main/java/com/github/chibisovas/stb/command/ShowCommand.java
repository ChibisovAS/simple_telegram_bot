package com.github.chibisovas.stb.command;

import com.github.chibisovas.stb.DAO.ArticleDAO;
import com.github.chibisovas.stb.models.Article;
import com.github.chibisovas.stb.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.telegram.telegrambots.meta.api.objects.Update;


public class ShowCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    // жалкая попытка подключить JdbcTemplate
    private static final ArticleDAO articleDAO = new ArticleDAO(new JdbcTemplate());

    @Autowired
    public ShowCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;

    }

    @Override
    public void execute(Update update) {
//        Article article = new Article("Статья","URL");
        Article article = articleDAO.showOne();
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),article.toString());
}

}
