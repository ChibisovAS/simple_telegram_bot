package com.github.chibisovas.stb.command;

import com.github.chibisovas.stb.DAO.ArticleDAO;
import com.github.chibisovas.stb.DAO.UserDAO;
import com.github.chibisovas.stb.service.SendBotMessageService;
import com.github.chibisovas.stb.service.SendBotMessageServiceImpl;
import com.google.common.collect.ImmutableMap;

import com.github.chibisovas.stb.command.*;

import static com.github.chibisovas.stb.command.CommandEnum.*;

public class CommandContainer {

    private final ImmutableMap<String,Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .put(SHOW.getCommandName(),new ShowCommand(sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }


    public Command retrieveCommand(String commandName) {
        return commandMap.getOrDefault(commandName,unknownCommand);
    }
}
