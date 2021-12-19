package calculations;

import method.ParsingComponent;

import java.text.DecimalFormat;

//расчет навесок для здания 605
public class Calculations_605 {

    //расчеты компонентов для состава КМК-1
    public static String KMK(String message) {
        double[] result = ParsingComponent.parsingComponentsTwo(message);
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double group = result[1];
        double value = result[0];
        double X = 0.63 * group;
        String PKPB_E = decimalFormat.format(((83.6 - X) / 100) * value);
        String m_fealenDeamin = decimalFormat.format((value * X) / 100);
        String yglerod = decimalFormat.format(value * 0.164);
        return "<code>" + "  Масса навесок состава КМК-1:\n"
                + "| наименование    | " + "вес (грамм)|\n"
                + "|-----------------|------------|\n"
                + "  каучук          | " + PKPB_E + "\n"
                + "  м-фенилендиамин | " + m_fealenDeamin + "\n"
                + "  углерод         | " + yglerod + "" + "</code>";
    }

    //расчеты компонентов для состава КC
    public static String KC(String message) {
        double result = ParsingComponent.parsingComponentsOne(message);
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String PKPB_E = decimalFormat.format(result * 0.432);
        String ED_20 = decimalFormat.format(result * 0.1055);
        String UMGFA = decimalFormat.format(result * 0.065);
        String TUYRAM = decimalFormat.format(result * 0.002);
        String ETILACETAT = decimalFormat.format(result * 0.3955);

        return "<pre>" + "  Масса навесок состава КС:\n"
                + "| наименование    | " + "вес (грамм)|\n"
                + "|-----------------|------------|\n"
                + "  каучук          | " + PKPB_E + "\n"
                + "  ED-20           | " + ED_20 + "\n"
                + "  таурама         | " + TUYRAM + "\n"
                + "  этилацитата     | " + ETILACETAT + "\n"
                + "  ИМТГФА          | " + UMGFA + "</pre>";
    }

    //расчеты компонентов для состава КM-1
    public static String KM(String message) {
        double[] result = ParsingComponent.parsingComponentsTwo(message);
        double group = result[1];
        double value = result[0];
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double X = ((43.7 * group) / (31.41 + group));
        String PKPB_E = decimalFormat.format((87.4 - X * 2) * (value / 100));
        String ANDEGRID_MALEINOVII = decimalFormat.format((value * X) / 100);
        String UMGFA = decimalFormat.format((value * X) / 100);
        String YGLEROD = decimalFormat.format(value * 0.126);
        String NEFTAM_2 = decimalFormat.format(value * 0.01);
        String GLICIDOL = decimalFormat.format(value * 0.01);
        String ETILACETAT = decimalFormat.format(value * 0.08);

        return "<code>" + "     Масса навесок состава КМ-1:\n"
                + "| наименование       | " + "вес (грамм)|\n"
                + "|--------------------|------------|\n"
                + "  каучук             | " + PKPB_E + "\n"
                + "  ангидрид малеиновый| " + ANDEGRID_MALEINOVII + "\n"
                + "  углерод            | " + YGLEROD + "\n"
                + "  этилацитата        | " + ETILACETAT + "\n"
                + "  нафтам-2           | " + NEFTAM_2 + "\n"
                + "  глицидол           | " + GLICIDOL + "\n"
                + "  ИМТГФА             | " + UMGFA + "</code>";
    }

}
