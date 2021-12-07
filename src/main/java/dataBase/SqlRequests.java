package dataBase;

public interface SqlRequests {

    String EMPLOYEE_GET_ALL = "select * from employee";
    String EMPLOYEE_ALL_INFO = "select employee.name, surname, patronymic, personnel_number, " +
            "born, education, profession_name, building.number, level_skills\n" +
            "            from empt_prof_buld_skil\n" +
            "\t\t\tjoin employee on empt_prof_buld_skil.employee_id = employee.id\n" +
            "            join profession on empt_prof_buld_skil.profession_id = profession.id\n" +
            "            join building on empt_prof_buld_skil.building_id = building.id\n" +
            "            join skills on empt_prof_buld_skil.skills_id = skills.id;";

}
