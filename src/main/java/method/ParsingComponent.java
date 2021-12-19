package method;

public class ParsingComponent  {

    //парсим строку из чисел
    public static double  parsingComponentsOne(String message) {

        String[] subStr = message.split("=");
        double[] results = new double[subStr.length];
        for (int i = 1; i < subStr.length; i++) {
            results[i] = Double.parseDouble(subStr[i].trim());
        }
        return  results[1] ;
    }

    public static double[] parsingComponentsTwo(String message) {

        String[] subStr = message.split("="); // Разделения строки str с помощью метода split()
        double[] results = new double[subStr.length];
        for (int i = 1; i < subStr.length; i++) {
            results[i] = Double.parseDouble(subStr[i].trim());
        }
        return new double[]{results[1], results[2]};
    }
}
