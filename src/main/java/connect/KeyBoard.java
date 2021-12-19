package connect;

import message.RequestsClient;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class KeyBoard implements RequestsClient {

    public static void setButtons(SendMessage sendMessage){

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true); //разметка
        replyKeyboardMarkup.setResizeKeyboard(true); //подгоняет размер клавиатуры
        replyKeyboardMarkup.setOneTimeKeyboard(false);//не скрывает клавиатуру после нажатия

        List<KeyboardRow> keyboardRowsList = new ArrayList<>();
        KeyboardRow keyInfoBoard = new KeyboardRow();
        KeyboardRow keySendBoard = new KeyboardRow();

        keyInfoBoard.add(new KeyboardButton(INFO));
        keySendBoard.add(new KeyboardButton(EMPLOYEE));
        keySendBoard.add(new KeyboardButton(BUILDING_605));
        keySendBoard.add(new KeyboardButton(BUILDING_1_502_4k));

        keyboardRowsList.add(keyInfoBoard);
        keyboardRowsList.add(keySendBoard);

        replyKeyboardMarkup.setKeyboard(keyboardRowsList);
    }
}
