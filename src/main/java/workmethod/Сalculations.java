package workmethod;

import java.util.ArrayList;
import java.util.List;

public class Сalculations {

    //расчеты компонентов для состава КМК-1
    public static List<String> KMK(double value, double group) {
        List<String> doubleList = new ArrayList<>();
        double X = 0.63 * group;
        String PKPB_E = Double.toString(Math.round(((83.6 - X) / 100) * value));
        String m_fealenDeamin = Double.toString(Math.round((value * X) / 100));
        String yglerod = Double.toString(Math.round(value * 0.164));
        doubleList.add("Масса навесок состава КМК-1:\n");
        doubleList.add("каучук =" + PKPB_E + " грамм\n");
        doubleList.add("м-фенилендиамин = " + m_fealenDeamin + " грамм\n");
        doubleList.add("углерод = " + yglerod + " грамм");
        return doubleList;
    }

    //расчеты компонентов для состава КC
    public static List<String> KC(double value) {
        List<String> doubleList = new ArrayList<>();
        String PKPB_E = Double.toString(Math.round(value * 0.432));
        String ED_20 = Double.toString(Math.round(value * 0.1055));
        String UMGFA = Double.toString(Math.round(value * 0.065));
        String TUYRAM = Double.toString(Math.round(value * 0.002));
        String ETILACETAT = Double.toString(Math.round(value * 0.3955));
        doubleList.add("Масса навесок состава КС:\n");
        doubleList.add("каучука = " + PKPB_E + " грамм\n");
        doubleList.add("ED-20 =" + ED_20 + " грамм\n");
        doubleList.add("ИМТГФА =" + UMGFA + " грамм\n");
        doubleList.add("таурама =" + TUYRAM + " грамм\n");
        doubleList.add("этилацитата =" + ETILACETAT + " грамм");
        return doubleList;
    }

    //расчеты компонентов для состава КM-1
    public static List<String> KM(double value, double group) {
        List<String> doubleList = new ArrayList<>();
        double X = ((43.7 * group) / (31.41 + group));
        String PKPB_E = Double.toString(Math.round((87.4 - X * 2) * (value / 100)));
        String ANDEGRID_MALEINOVII = Double.toString(Math.round((value * X) / 100));
        String UMGFA = Double.toString(Math.round((value * X) / 100));
        String YGLEROD = Double.toString(Math.round(value * 0.126));
        String NEFTAM_2 = Double.toString(Math.round(value * 0.01));
        String GLICIDOL = Double.toString(Math.round(value * 0.01));
        String ETILACETAT = Double.toString(Math.round(value * 0.08));
        doubleList.add("Масса навесок состава КМ-1:\n");
        doubleList.add("каучук =" + PKPB_E + " грамм\n");
        doubleList.add("андигрид малеиновый =" + ANDEGRID_MALEINOVII + " грамм\n");
        doubleList.add("ИМТГФА =" + UMGFA + " грамм\n");
        doubleList.add("углерод =" + YGLEROD + " грамм\n");
        doubleList.add("нафтам-2 = " + NEFTAM_2 + " грамм\n");
        doubleList.add("глицидол =" + GLICIDOL + " грамм\n");
        doubleList.add("этилоцетат = " + ETILACETAT + " грамм");
        return doubleList;
    }

}
