package employeeMethod;

import dataBase.ConnectionDB;
import dataBase.FindRequest;
import dataBase.SqlRequests;
import tableMySql.*;
import workmethod.ContentRequest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FindEmployee implements ContentRequest, SqlRequests, FindRequest {

    @Override
    public String content(String message) {
        String[] subStr = message.split("="); // Разделения строки str с помощью метода split()
        String[] result = new String[subStr.length];
        for (int i = 0; i < subStr.length; i++) {
            result[i] = subStr[i].trim();
        }
        return result[1];
    }

    @Override
    public List<EmpProfBuldSkil> selectFindEmployee(String message) {

        String surname = content(message);

        List<EmpProfBuldSkil> listInfo = new ArrayList<>();

        try {
            ConnectionDB connectionDB = new ConnectionDB();
            Statement statement = connectionDB.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(EMPLOYEE_ALL_INFO);

            while (resultSet.next()) {

                List<Employee> employeeList = new ArrayList<>();
                List<Profession> professionList = new ArrayList<>();
                List<Building> buildingList = new ArrayList<>();
                List<Skills> skillsList = new ArrayList<>();

                Employee employee = new Employee();
                Profession profession = new Profession();
                Building building = new Building();
                Skills skills = new Skills();
                EmpProfBuldSkil empProfBuldSkil = new EmpProfBuldSkil();

                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setPatronymic(resultSet.getString("patronymic"));
                employee.setPersonnel_number(resultSet.getInt("personnel_number"));
                employee.setBorn(resultSet.getString("born"));
                employee.setEducation(resultSet.getString("education"));
                employeeList.add(employee);

                profession.setProfession_name(resultSet.getString("profession_name"));
                professionList.add(profession);

                building.setNumber(resultSet.getString("number"));
                buildingList.add(building);

                skills.setLevel_skills(resultSet.getString("level_skills"));
                skillsList.add(skills);

                    if (employee.getSurname().equalsIgnoreCase(surname)) {
                        empProfBuldSkil.setEmployees(employeeList);
                        empProfBuldSkil.setProfessions(professionList);
                        empProfBuldSkil.setBuildings(buildingList);
                        empProfBuldSkil.setSkills(skillsList);
                        listInfo.add(empProfBuldSkil);
                }
            }

            resultSet.close();
            statement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return listInfo;
    }
}
