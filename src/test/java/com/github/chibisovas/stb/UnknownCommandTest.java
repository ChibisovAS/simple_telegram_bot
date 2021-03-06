package com.github.chibisovas.stb;

import com.github.chibisovas.stb.command.Command;
import com.github.chibisovas.stb.command.UnknownCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit test for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "/fdgdfgdfgdbd";
    }

    @Override
    String getCommandMessage() {
        return UnknownCommand.UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
