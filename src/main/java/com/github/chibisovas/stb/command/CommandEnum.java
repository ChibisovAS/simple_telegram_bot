package com.github.chibisovas.stb.command;

public enum CommandEnum {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    SHOW("/show"),
    NO("");


    private final String commandName;

    CommandEnum(String commandName) {
        this.commandName = commandName;
    }


    public String getCommandName() {
        return commandName;
    }
}
