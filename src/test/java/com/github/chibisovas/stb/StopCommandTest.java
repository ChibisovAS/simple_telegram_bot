package com.github.chibisovas.stb;

import com.github.chibisovas.stb.command.Command;
import com.github.chibisovas.stb.command.CommandEnum;
import com.github.chibisovas.stb.command.StopCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit test for StopCommand")
public class StopCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandEnum.STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StopCommand.STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}
