package com.github.chibisovas.stb;


import com.github.chibisovas.stb.command.Command;
import com.github.chibisovas.stb.command.CommandContainer;
import com.github.chibisovas.stb.command.CommandEnum;
import com.github.chibisovas.stb.command.UnknownCommand;
import com.github.chibisovas.stb.service.SendBotMessageService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit test for CommandContainer")
public class CommandContainerTest {

    CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        //when-then
        Arrays.stream(CommandEnum.values()).forEach(x -> {
            Command command = commandContainer.retrieveCommand(x.getCommandName());
            Assertions.assertNotEquals(UnknownCommand.class,command.getClass());
        });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        //given
        String wrongCommand = "asddadasd";
        //when
        Command command = commandContainer.retrieveCommand(wrongCommand);
        //then
        Assertions.assertEquals(UnknownCommand.class,command.getClass());
    }
}
