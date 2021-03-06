package com.github.chibisovas.stb;

import com.github.chibisovas.stb.command.Command;
import com.github.chibisovas.stb.service.SendBotMessageService;
import com.github.chibisovas.stb.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class AbstractCommandTest {
    protected Mytb mytb = Mockito.mock(Mytb.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(mytb);

    abstract String getCommandName();
    abstract String getCommandMessage();
    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        //given
        Long chatId = 123456789L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sm = new SendMessage();
        sm.setChatId(chatId.toString());
        sm.setText(getCommandMessage());
        sm.enableHtml(true);

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(mytb).execute(sm);

    }

}
