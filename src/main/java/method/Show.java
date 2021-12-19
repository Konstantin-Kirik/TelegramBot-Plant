package method;

import connect.BotConnect;
import org.telegram.telegrambots.meta.api.objects.Message;
import tableMySql.*;

import java.util.List;

public class Show {

    public void selectFindEmployee(Message message, List<EmpProfBuldSkil> listEmp) {
        BotConnect botConnect = new BotConnect();
        String emp = null;
        String prof = null;
        String buil = null;
        String skil = null;
        for (EmpProfBuldSkil empProfBuldSkil : listEmp) {
            for (Employee employee : empProfBuldSkil.getEmployees()) {
                emp = "<code>" + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() + "\n"
                        + "Табельный номер : " + employee.getPersonnel_number() + "\n"
                        + "Год рождения : " + employee.getBorn() + " \n"
                        + "Образование : " + employee.getEducation() + "</code>" + "\n";
            }
            for (Profession professions : empProfBuldSkil.getProfessions()) {
                prof = "<code>" + "Профессия : " + professions.getProfession_name() + "</code>" + "\n";
            }
            for (Building building : empProfBuldSkil.getBuildings()) {
                buil = "<code>" + "Номер здание : " + building.getNumber() + "</code>" + "\n";

            }
            for (Skills skills : empProfBuldSkil.getSkills()) {
                skil = "<code>" + "Навыки : " + skills.getLevel_skills() + "</code>" + "\n";
            }

            String obj = emp + prof + buil + skil;
            botConnect.sendMessage(message, obj);
        }
    }

    public void showEmployee(Message message, List<Employee> employeeList) {
        BotConnect botConnect = new BotConnect();
        for (Employee employee : employeeList) {
            String emp = employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() + "\n"
                    + "Табельный № " + employee.getPersonnel_number();
            botConnect.sendMessage(message, emp);
        }
    }
}

