package message;

import calculations.Calculations_502_4k;
import calculations.Calculations_605;
import connect.BotConnect;
import employee.SelectEmployee;
import method.Show;
import org.telegram.telegrambots.meta.api.objects.Message;

// экзекутерс
public class AllSendMessage implements RequestsClient {

    public AllSendMessage(Message message) {

        BotConnect botConnect = new BotConnect();
        Switch s = new Switch();
        SelectEmployee selectEmployee = new SelectEmployee();
        Show show = new Show();

        // определяем в каких случаях есть текст
        if (!s.numeralOrNot(message.getText())) {

            switch (message.getText()) {
                case START -> {
                    String mail =
                            "<b>Привет, я телеграм бот, и я могу помочь тебе в следующем:</b>\n"
                                    + "если ты в первые работаешь с данным ботом, нажми на кнопку info "
                                    + "для того чтобы узнать о возможностях данного бота."
                                    + " В противном случае ты знаешь, что делать. Удачи мой друг!";
                    botConnect.sendMessage(message, mail);
                }
                case INFO -> {
                    String mail = "Данный бот разработан для отдела опытного производства технологического бюра, в целях " +
                            "упрощения и скорости работы на производстве.\n" +
                            "Перечень возможностей бота:\n" +
                            "- расчет навесок для здания 605;\n" +
                            "- расчет пропорции реагентов для здания 1-502/4k;\n" +
                            "- информация о работниках подразделения;\n" +
                            "- поиск по подразделению.";
                    botConnect.sendMessage(message, mail);
                }
                case EMPLOYEE -> {
                    String mail = EMPLOYEE_ALL + " Работники подразделения\n"
                            + EMPLOYEE_FIND + " Поиск по параметрам\n";
                    botConnect.sendMessage(message, mail);
                }
                case BUILDING_605 -> {
                    String mail = KMK + " Расчет состава КМК-1\n"
                            + KC + " Расчет состава КС\n"
                            + KM + " Расчет состава КМ";
                    botConnect.sendMessage(message, mail);
                }
                case BUILDING_1_502_4k -> {
                    String mail = HTPB + " Расчет пропорции реагентов для синтеза каучука HTPB\n"
                            + CTPB + " Расчет пропорции реагентов для синтеза каучука CTPB\n"
                            + IHTPB + " Расчет пропорции реагентов для синтеза каучука IHTPB\n"
                            + IPB + " Расчет пропорции реагентов для синтеза каучука IPB\n"
                            + PB + " Расчет пропорции реагентов для синтеза каучука PB";
                    botConnect.sendMessage(message, mail);
                }
                case KMK -> {
                    String mail = "<b>Для рассчета навесок состава КМК введите 'кмк=массу=долю эпоксидных групп'</b>\n";
                    botConnect.sendMessage(message, mail);
                }
                case KC -> {
                    String mail = "<b>Для рассчета навесок КС введите 'кс=массу'</b>\n";
                    botConnect.sendMessage(message, mail);
                }
                case KM -> {
                    String mail = "<b>Для рассчета навесок КМ введите 'км=массу=долю эпоксидных групп'</b>\n";
                    botConnect.sendMessage(message, mail);
                }
                case EMPLOYEE_ALL -> {
                    show.showEmployee(message, selectEmployee.selectEmployee());
                }
                case EMPLOYEE_FIND -> {
                    String mail = "<b>Поиск: " + "\n"
                            + "- по фамилии сотрудника: введите 'поиск=фамилия'\n"
                            + "- по номеру здания: введите 'поиск=номер здания'</b>\n";
                    botConnect.sendMessage(message, mail);
                }
                case HTPB -> {
                    String mail = "<b>Для расчета навесок: введите 'htpb=объем бутадиена'(литры)</b>\n";
                    botConnect.sendMessage(message, mail);
                }
                case CTPB -> {
                    String mail = "<b>Для расчета навесок: введите 'ctpb=объем бутадиена'(литры)</b>\n";
                    botConnect.sendMessage(message, mail);
                }
                case IHTPB -> {
                    String mail = "<b>Для расчета навесок: введите 'ihtpb=объем бутадиена'(литры)</b>\n";
                    botConnect.sendMessage(message, mail);
                }
                case IPB -> {
                    String mail = "<b>Для расчета навесок: введите 'ipb=объем бутадиена'(литры)</b>\n";
                    botConnect.sendMessage(message, mail);
                }
                case PB -> {
                    String mail = "<b>Для расчета навесок: введите 'pb=объем бутадиена'(литры)</b>\n";
                    botConnect.sendMessage(message, mail);
                }
            }
        } else {
            String str = s.content(message.getText());
            switch (str) {
                case kmk -> {
                    botConnect.sendMessage(message, Calculations_605.KMK(message.getText()));
                }
                case kc -> {
                    botConnect.sendMessage(message, Calculations_605.KC(message.getText()));
                }
                case km -> {
                    botConnect.sendMessage(message, Calculations_605.KM(message.getText()));
                }
                case employee_find -> {
                    show.selectFindEmployee(message, selectEmployee.selectFindEmployee(message.getText()));
                }
                case htpb -> {
                    botConnect.sendMessage(message, Calculations_502_4k.rubberHTPB(message.getText()));
                }
                case ctpb -> {
                    botConnect.sendMessage(message, Calculations_502_4k.rubberCTPB(message.getText()));
                }
                case ihtpb -> {
                    botConnect.sendMessage(message, Calculations_502_4k.rubberIHTPB(message.getText()));
                }
                case ipb -> {
                    botConnect.sendMessage(message, Calculations_502_4k.rubberIPB(message.getText()));
                }
                case pb -> {
                    botConnect.sendMessage(message, Calculations_502_4k.rubberPB(message.getText()));
                }
            }
        }
    }
}




