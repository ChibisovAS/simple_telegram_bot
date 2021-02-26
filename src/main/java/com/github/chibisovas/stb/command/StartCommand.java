package com.github.chibisovas.stb.command;

import com.github.chibisovas.stb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE = "Привет. Я бот написанный ChibisovAS. Нихрена не умею, но обязательно научусь!";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),START_MESSAGE);
    }
}
