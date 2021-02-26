package com.github.chibisovas.stb;

import com.github.chibisovas.stb.command.CommandContainer;
import com.github.chibisovas.stb.service.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.github.chibisovas.stb.command.CommandEnum.NO;

@Component
public class Mytb extends TelegramLongPollingBot {

    private static final String COMMAND_PREFIX = "/";
    private final CommandContainer commandContainer;

    public Mytb() {
        commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;


    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandName = message.split(" ")[0].trim();
                commandContainer.retrieveCommand(commandName).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }
}
