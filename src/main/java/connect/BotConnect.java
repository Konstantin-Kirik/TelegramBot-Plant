package connect;

import message.AllSendMessage;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotConnect extends TelegramLongPollingBot {

    private static final String TOKEN = "1973090417:AAFkzU-2UHkdXmAyvwclpYr5D7Zh8UgWIS8";
    private static final String USER_NAME = "PCPlant";

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            new AllSendMessage(update.getMessage());
        }
    }
    @Override
    public String getBotUsername() {
        return USER_NAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    public void sendMessage(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setParseMode(ParseMode.HTML);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
       // sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(String.valueOf(text));

        try {
            KeyBoard.setButtons(sendMessage);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}







