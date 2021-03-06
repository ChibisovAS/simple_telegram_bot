package com.github.chibisovas.stb;

import com.github.chibisovas.stb.command.Command;
import com.github.chibisovas.stb.command.CommandEnum;
import com.github.chibisovas.stb.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit test for StartCommand")
class StartCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandEnum.START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StartCommand.START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}
