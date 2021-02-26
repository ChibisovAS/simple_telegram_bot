package com.github.chibisovas.stb.command;


import com.github.chibisovas.stb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;


public class UnknownCommand implements Command {

    public static final String UNKNOWN_MESSAGE = "Не знаю такой команды,\n" +
                                                 "но может она появиться в ближайшем будущем!\n" +
                                                 "Напиши /help чтобы узнать какие команды уже существуют.";

    private final SendBotMessageService sendBotMessageService;

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
