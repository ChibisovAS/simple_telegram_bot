package com.github.chibisovas.stb;

import com.github.chibisovas.stb.service.SendBotMessageService;
import com.github.chibisovas.stb.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-test for SendBotMessageService")
public class SendBotMessageServiceTest {

    //1
    private SendBotMessageService sendBotMessageService;
    private Mytb mytb;

    @BeforeEach
    public void init() {
        mytb = Mockito.mock(Mytb.class);
        sendBotMessageService = new SendBotMessageServiceImpl(mytb);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sm = new SendMessage();
        sm.setChatId(chatId);
        sm.setText(message);
        sm.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId,message);

        //then
        Mockito.verify(mytb).execute(sm);

    }
}
