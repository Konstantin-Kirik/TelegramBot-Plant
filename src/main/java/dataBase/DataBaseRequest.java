package dataBase;

import tableMySql.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRequest {

    private static final String EMPLOYEE_GET_ALL = "select * from employee";
    private static final String EMPLOYEE_ALL_INFO = "select employee.name, surname, patronymic, personnel_number, " +
            "born, education, profession_name, building.number, level_skills\n" +
            "            from empt_prof_buld_skil\n" +
            "\t\t\tjoin employee on empt_prof_buld_skil.employee_id = employee.id\n" +
            "            join profession on empt_prof_buld_skil.profession_id = profession.id\n" +
            "            join building on empt_prof_buld_skil.building_id = building.id\n" +
            "            join skills on empt_prof_buld_skil.skills_id = skills.id;";

    public static List<Employee> selectEmployee() {

        List<Employee> listEmp = new ArrayList<>();

        try {
            ConnectionDB connectionDB = new ConnectionDB();
            Statement statement = connectionDB.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(EMPLOYEE_GET_ALL);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setPatronymic(resultSet.getString("patronymic"));
                employee.setPersonnel_number(resultSet.getInt("personnel_number"));
                employee.setBorn(resultSet.getString("born"));
                employee.setEducation(resultSet.getString("education"));
                listEmp.add(employee);
            }
            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return listEmp;
    }

    public static List<EmpProfBuldSkil> selectEmployeeInfoAll() {

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

                empProfBuldSkil.setEmployees(employeeList);
                empProfBuldSkil.setProfessions(professionList);
                empProfBuldSkil.setBuildings(buildingList);
                empProfBuldSkil.setSkills(skillsList);
                listInfo.add(empProfBuldSkil);
            }

            resultSet.close();
            statement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return listInfo;
    }
}
