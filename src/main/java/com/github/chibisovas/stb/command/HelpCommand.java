package com.github.chibisovas.stb.command;


import com.github.chibisovas.stb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.chibisovas.stb.command.CommandEnum.*;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("<b>Доступные команды</b>\n\n"
                    + "%s - начать работу\n"
                    + "%s - приостановить работу\n"
                    + "%s - показать статьи\n"
                    + "%s - получить помощь\n",
            START.getCommandName(), STOP.getCommandName(),SHOW.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
