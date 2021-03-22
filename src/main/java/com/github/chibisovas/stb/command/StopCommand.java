package com.github.chibisovas.stb.command;

import com.github.chibisovas.stb.DAO.UserDAO;
import com.github.chibisovas.stb.models.User;
import com.github.chibisovas.stb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    public static final String STOP_MESSAGE = "Удаляю Вас из базы\uD83D\uDE1F.";

    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        User user = new User(update.getMessage().getChatId());
        UserDAO.removeUser(user);
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),STOP_MESSAGE);
    }
}
