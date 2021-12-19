package calculations;

import method.ParsingComponent;
import java.text.DecimalFormat;

public class Calculations_502_4k {

    //расчет каучука HTPB
    public static String rubberHTPB(String message) {

        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double valueButadien = ParsingComponent.parsingComponentsOne(message);
        String str_valueButadien = decimalFormat.format(valueButadien);
        String Mas_Butadien = decimalFormat.format(valueButadien * 0.615);

        double V_SPIRT = valueButadien * 0.626;
        String V_spirt = decimalFormat.format(V_SPIRT);
        String SPIRT = decimalFormat.format(V_SPIRT / 1.200);
        double V_PEREKES = valueButadien * 0.0546;
        String V_perekes = decimalFormat.format(V_PEREKES);
        String PEREKES = decimalFormat.format(V_PEREKES / 0.786);

        return "<code>" + "Пропорции реагентов для реактора\n"
                + "150 л (наполняемость 80 %, 120 л)\n"
                + "синтез каучука HTPB:\n"
                + "| Компонент |Масса[кг]/Объем[л]|\n"
                + "|-----------|------------------|\n"
                + " Бутадиен      " + Mas_Butadien + " / " + str_valueButadien + "\n"
                + " Изопрапанол   " + SPIRT + " / " + V_spirt + "\n"
                + " Перекись      " + PEREKES + " / " + V_perekes + "</code>";
    }

    public static String rubberCTPB(String message) {

        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double valueButadien = ParsingComponent.parsingComponentsOne(message);
        String str_valueButadien = decimalFormat.format(valueButadien);
        String Mas_Butadien = decimalFormat.format(valueButadien * 0.615);

        double Mas_Tret_Butanol = valueButadien * 0.615;
        String V_Tret_Butanol = decimalFormat.format(Mas_Tret_Butanol / 0.781);
        String str_Mas_Tret_Butanol = decimalFormat.format(valueButadien * 0.615);

        String AZOBIS = decimalFormat.format((4 * valueButadien * 0.615) / 100);

        return "<code>" + "Пропорции реагентов для реактора \n"
                + "150 л (наполняемость 80 %, 120 л)\n"
                + "синтез какчука CTPB:\n"
                + "| Компонент |Масса[кг]/Объем[л]|\n"
                + "|-----------|------------------|\n"
                + " Бутадиен      " + Mas_Butadien + " / " + str_valueButadien + "\n"
                + " Трет-бутанол  " + str_Mas_Tret_Butanol + " / " + V_Tret_Butanol + "\n"
                + " 4,4'-Азобис   " + AZOBIS + " / - \n"
                + " (4-циановалериановая кислота)" + "</code>";
    }

    public static String rubberIHTPB(String message) {

        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double valueButadien = ParsingComponent.parsingComponentsOne(message);
        double Mas_Butadien = valueButadien * 0.615;
        String str_valueButadien = decimalFormat.format(valueButadien);
        String strMas_Butadien = decimalFormat.format(Mas_Butadien);

        double Mas_IZOPREN = Mas_Butadien * 0.25;
        String strMas_Izopren = decimalFormat.format(Mas_IZOPREN);
        String V_IZOPREN = decimalFormat.format(Mas_IZOPREN / 0.681);

        double Mas_DIETILOVUI_EFIR = (Mas_Butadien + Mas_IZOPREN) * 3;
        String str_Mas_DIETILOVUI_EFIR = decimalFormat.format(Mas_DIETILOVUI_EFIR);
        String V_DIETILOVUI_EFIR = decimalFormat.format(Mas_DIETILOVUI_EFIR / 0.714);

        // расчет инициатора 1,0M дилитобутаг
        double massa_monomera = Mas_Butadien * 1000;
        int koncentraciya = 1;
        int ogudaemaya_massa_polimera = 2500;
        double V_inicilizatora = massa_monomera / (koncentraciya * ogudaemaya_massa_polimera);
        double V_10M_DILITABUTAG = V_inicilizatora * 1.2;
        String Mas_10M_DILITABUTAG = decimalFormat.format(V_10M_DILITABUTAG * 0.68);
        String str_V_10M_DILITABUTAG = decimalFormat.format(V_10M_DILITABUTAG);

        double V_OKSID_PROPILENA = V_10M_DILITABUTAG;
        String Mas_OKSID_PROPILENA = decimalFormat.format(V_OKSID_PROPILENA * 0.859);
        String str_V_OKSID_PROPILENA = decimalFormat.format(V_OKSID_PROPILENA);

        double V_METANOL = ((V_10M_DILITABUTAG) * 1000 / 200) * 0.05 * 2;
        String Mas_METANOL = decimalFormat.format(V_METANOL * 0.792);
        String str_V_METANOL = decimalFormat.format(V_METANOL);

        return "<code>" + "Пропорции реагентов для реактора \n"
                + "50 л (наполняемость 80 %, 40 л)\n"
                + "синтез какчука IHTPB:\n"
                + "|   Компонент  |Масса[кг]/Объем[л]|\n"
                + "|--------------|------------------|\n"
                + " Бутадиен         " + strMas_Butadien + " / " + str_valueButadien + "\n"
                + " Изопропен        " + strMas_Izopren + " / " + V_IZOPREN + "\n"
                + " Диэтиловый эфир  " + str_Mas_DIETILOVUI_EFIR + " / " + V_DIETILOVUI_EFIR + "\n"
                + " 1,0M дилитобутаг " + Mas_10M_DILITABUTAG + " / " + str_V_10M_DILITABUTAG + "\n"
                + " Оксид пропилена  " + Mas_OKSID_PROPILENA + " / " + str_V_OKSID_PROPILENA + "\n"
                + " Метанол          " + Mas_METANOL + " / " + str_V_METANOL + "\n"
                + "</code>";
    }

    public static String rubberIPB(String message) {

        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double valueButadien = ParsingComponent.parsingComponentsOne(message);
        double Mas_valueButadien = valueButadien * 0.615;
        String str_Mas_valueButadien = decimalFormat.format(Mas_valueButadien);
        String str_valueButadien = decimalFormat.format(valueButadien);

        double Mas_IZOPREN = Mas_valueButadien * 0.25;
        String V_IZOPREN = decimalFormat.format(Mas_IZOPREN / 0.681);
        String strMas_IZOPREN = decimalFormat.format(Mas_IZOPREN);

        double Mas_GEKSAN = (Mas_valueButadien + Mas_IZOPREN) * 2;
        String V_Mas_GEKSAN = decimalFormat.format(Mas_GEKSAN / 0.655);
        String str_Mas_GEKSAN = decimalFormat.format(Mas_GEKSAN);

        double V_BUTIULITIU = ((Mas_valueButadien + Mas_IZOPREN) * 1000) / (2.5 * 2000) * 1.3;
        String Mas_BUTIULITIU = decimalFormat.format(V_BUTIULITIU * 0.682);
        String str_V_BUTIULITIU = decimalFormat.format(V_BUTIULITIU);

        double Mas_METANOL = 0.05 * (V_BUTIULITIU / 0.2);
        String V_METANOL = decimalFormat.format(Mas_METANOL / 0.792);
        String str_Mas_METANOL = decimalFormat.format(Mas_METANOL);

        return "<code>" + "Пропорции реагентов для реактора \n"
                + "50 л (наполняемость 80 %, 40 л)\n"
                + "синтез какчука IPB:\n"
                + "|   Компонент  |Масса[кг]/Объем[л]|\n"
                + "|--------------|------------------|\n"
                + " Бутадиен         " + str_Mas_valueButadien + " / " + str_valueButadien + "\n"
                + " Изопрен          " + strMas_IZOPREN + " / " + V_IZOPREN + "\n"
                + " Гексан           " + str_Mas_GEKSAN + " / " + V_Mas_GEKSAN + "\n"
                + " н-бутиллитий     " + Mas_BUTIULITIU + " / " + str_V_BUTIULITIU + "\n"
                + " Метанол          " + str_Mas_METANOL + " / " + V_METANOL + "\n"
                + "</code>";
    }

    public static String rubberPB(String message) {

        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double valueButadien = ParsingComponent.parsingComponentsOne(message);
        double Mas_valueButadien = valueButadien * 0.615;
        String str_valueButadien = decimalFormat.format(valueButadien);
        String str_Mas_valueButadien = decimalFormat.format(Mas_valueButadien);

        double Mas_GEKSAN = Mas_valueButadien * 2;
        String str_Mas_GEKSAN = decimalFormat.format(Mas_GEKSAN);
        String str_V_GEKSAN = decimalFormat.format(Mas_GEKSAN / 0.655);

        double V_N_BUTIILITII = (Mas_valueButadien * 1000 / (2.5 * 2000)) * 1.3;
        String Mas_N_BUTIILITII = decimalFormat.format(V_N_BUTIILITII * 0.682);
        String str_V_N_BUTIILITII = decimalFormat.format(V_N_BUTIILITII);

        double Mas_METANOL = 0.05 * (V_N_BUTIILITII / 0.2);
        String str_Mas_METANOL = decimalFormat.format(Mas_METANOL);
        String str_V_METANOL = decimalFormat.format(Mas_METANOL / 0.792);


        return "<code>" + "Пропорции реагентов для реактора \n"
                + "50 л (наполняемость 80 %, 40 л)\n"
                + "синтез какчука PB:\n"
                + "|   Компонент  |Масса[кг]/Объем[л]|\n"
                + "|--------------|------------------|\n"
                + " Бутадиен         " + str_Mas_valueButadien + " / " + str_valueButadien + "\n"
                + " Гексан           " + str_Mas_GEKSAN + " / " + str_V_GEKSAN + "\n"
                + " н-бутиллитий     " + Mas_N_BUTIILITII + " / " + str_V_N_BUTIILITII + "\n"
                + " Метанол          " + str_Mas_METANOL + " / " + str_V_METANOL + "\n"
                + "</code>";
    }
}
