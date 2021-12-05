package message;

import connect.BotConnect;
import dataBase.DataBaseRequest;
import workmethod.Examination;
import workmethod.RequestsClient;
import org.telegram.telegrambots.meta.api.objects.Message;

public class AllSendMessage implements RequestsClient {

    public AllSendMessage(Message message) {

        BotConnect botConnect = new BotConnect();

        // определяем в каких случаях есть текст
        if (!Examination.numeralOrNot(message.getText())) {

            switch (message.getText()) {
                case START -> {
                    String messageMy =
                            "Привет я бот, и я могу помочь тебе в следующем :\n"
                                    + HELP + "\n"
                                    + KMK + " Расчет состава КМК-1\n"
                                    + KC + " Расчет состава КС\n"
                                    + KM + " Расчет состава КМ\n"
                                    + EMPLOYEE_ALL + " Работники подразделения\n"
                                    + EMPLOYEE_INFO_ALL + " Вся информация о работниках подразделения";
                    botConnect.sendMessage(message, messageMy);
                }
                case HELP -> {
                    if (message.hasText()) {
                        String messageMy = "Этот бот может посчитать формулы касающиеся здания 605(НО ЭТО ПОКА ЧТО!!!)";
                        botConnect.sendMessage(message, messageMy);
                    }
                }
                case KMK -> {
                    String mail = "Для рассчета навесок состава КМК введите 'kmk=xxx=xxx' массу какую Вы хотите получить " +
                            "+ долю эпоксидных групп";
                    botConnect.sendMessage(message, mail);
                }
                case KC -> {
                    String mail = "Для рассчета навесок КС введите 'kc=xxx' массу какую Вы хотите получить ";
                    botConnect.sendMessage(message, mail);
                }
                case KM -> {
                    String mail = "Для рассчета навесок КМ введите 'km=xxx=xxx' массу какую Вы хотите получить " +
                            "+ долю эпоксидных групп";
                    botConnect.sendMessage(message, mail);
                }
                case EMPLOYEE_ALL -> {
                    botConnect.sendDataBaseEmployee(message, DataBaseRequest.selectEmployee());
                }
                case EMPLOYEE_INFO_ALL -> {
                    botConnect.sendDataBaseEmployeeInfo(message, DataBaseRequest.selectEmployeeInfoAll());
                }
            }
        } else {
            String str = Examination.sostav(message.getText());
            switch (str) {
                case kmk -> {
                    botConnect.sendMessageString(message, Examination.parsingKMK(message.getText()));
                }
                case kc -> {
                    botConnect.sendMessageString(message, Examination.parsingKC(message.getText()));
                }
                case km -> {
                    botConnect.sendMessageString(message, Examination.parsingKM(message.getText()));
                }
            }
        }
    }
}


