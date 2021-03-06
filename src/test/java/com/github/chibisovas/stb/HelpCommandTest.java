package com.github.chibisovas.stb;

import com.github.chibisovas.stb.command.Command;
import com.github.chibisovas.stb.command.CommandEnum;
import com.github.chibisovas.stb.command.HelpCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit test for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return CommandEnum.HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HelpCommand.HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
