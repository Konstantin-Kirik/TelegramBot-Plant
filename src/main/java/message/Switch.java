package message;

import method.ContentRequest;

public class Switch implements ContentRequest {
    //проверка формулу применим
    @Override
    public String content(String message) {
        String[] subStr = message.split("="); // Разделения строки str с помощью метода split()
        String[] result = new String[subStr.length];
        for (int i = 0; i < subStr.length; i++) {
            result[i] = subStr[i].trim();
        }
        return result[0];
    }

    //определяем являеться message запросом или числом
    public boolean numeralOrNot(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '/')
                return false;
            break;
        }
        return true;
    }
}
