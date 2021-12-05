package workmethod;

import java.util.List;

public class Examination {

    //определяем являеться message запросом или числом
    public static boolean numeralOrNot(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '/')
                return false;
        }
        return true;
    }

    //проверка для какою формулу применим
    public static String sostav(String message) {

        String[] subStr = message.split("="); // Разделения строки str с помощью метода split()
        String[] result = new String[subStr.length];
        for (int i = 0; i < subStr.length; i++) {
            result[i] = subStr[i].trim();
        }
        return result[0];
    }

    //парсим строку из чисел
    public static List<String> parsingKMK(String message) {

        String[] subStr = message.split("="); // Разделения строки str с помощью метода split()
        double[] results = new double[subStr.length];
        for (int i = 1; i < subStr.length; i++) {
            results[i] = Double.parseDouble(subStr[i].trim());
        }
        return Сalculations.KMK(results[1], results[2]);
    }

    //парсим строку из чисел
    public static List<String> parsingKC(String message) {

        String[] subStr = message.split("=");
        double[] results = new double[subStr.length];
        for (int i = 1; i < subStr.length; i++) {
            results[i] = Double.parseDouble(subStr[i].trim());
        }
        return Сalculations.KC(results[1]);
    }

    //парсим строку из чисел
    public static List<String> parsingKM(String message) {

        String[] subStr = message.split("="); // Разделения строки str с помощью метода split()
        double[] results = new double[subStr.length];
        for (int i = 1; i < subStr.length; i++) {
            results[i] = Double.parseDouble(subStr[i].trim());
        }
        return Сalculations.KM(results[1], results[2]);
    }
}
