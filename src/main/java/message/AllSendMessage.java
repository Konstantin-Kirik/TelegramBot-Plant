package message;

import connect.BotConnect;
import employeeMethod.FindForBuilding;
import employeeMethod.SelectEmployee;
import workmethod.Examination;
import employeeMethod.FindEmployee;
import workmethod.RequestsClient;
import org.telegram.telegrambots.meta.api.objects.Message;


public class AllSendMessage implements RequestsClient {

    public AllSendMessage(Message message) {

        BotConnect botConnect = new BotConnect();
        Examination examination = new Examination();
        FindEmployee findEmployee = new FindEmployee();
        FindForBuilding findForBuilding = new FindForBuilding();
        SelectEmployee selectEmployee = new SelectEmployee();

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
                                    + EMPLOYEE_INFO_ALL + " Вся информация о работниках подразделения\n"
                                    + EMPLOYEE_FIND_SURNAME + " Поиск сотрудника по фамилии\n"
                                    + EMPLOYEE_FIND_BUILDING + " Поиск сотрудников по зданиям";
                    botConnect.sendMessage(message, messageMy);
                }
                case HELP -> {
                    if (message.hasText()) {
                        String messageMy = "Данный бот разработан для отдела опытного производства технологического бюра, в целях " +
                                "упрощения и скорости работы на производстве.\n" +
                                "Перечень возможностей бота:\n" +
                                "- расчет навесок на составы здания 605;\n" +
                                "- информация о работниках подразделения;\n" +
                                "- поиск по подразделению.";
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
                    botConnect.sendDataBaseEmployee(message, selectEmployee.selectEmployee());
                }
                case EMPLOYEE_INFO_ALL -> {
                    botConnect.sendDataBaseEmployeeInfo(message, selectEmployee.selectEmployeeInfoAll());
                }
                case EMPLOYEE_FIND_SURNAME -> {
                    String mail = "Поиск сотрудника по фамилии: введите 'работник=ххххх'";
                    botConnect.sendMessage(message, mail);
                }
                case EMPLOYEE_FIND_BUILDING -> {
                    String mail = "Поск сотрудников по зданию: введите 'здание=хххх'";
                    botConnect.sendMessage(message,mail);
                }
            }
        } else {
            String str = examination.content(message.getText());
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
                case employee_find_surname -> {
                    botConnect.sendDataBaseEmployeeInfo(message, findEmployee.selectFindEmployee(message.getText()));
                }
                case employee_find_building -> {
                    botConnect.sendDataBaseEmployeeInfo(message,findForBuilding.selectFindEmployee(message.getText()));
                }
            }
        }
    }
}




