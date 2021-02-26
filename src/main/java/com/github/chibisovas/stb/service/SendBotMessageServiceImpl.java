package com.github.chibisovas.stb.service;

import com.github.chibisovas.stb.Mytb;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {
    private final Mytb mytb;

    @Autowired
    public SendBotMessageServiceImpl(Mytb mytb) {
        this.mytb = mytb;
    }

    @Override
    public void sendMessage(String chatID, String message) {
        SendMessage sm = new SendMessage();
        sm.setChatId(chatID);
        sm.enableHtml(true);
        sm.setText(message);

        try {
            mytb.execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
