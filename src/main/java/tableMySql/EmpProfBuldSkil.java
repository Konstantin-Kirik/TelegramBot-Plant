package tableMySql;

import java.util.List;

public class EmpProfBuldSkil {

    private List<Employee> employees;
    private List<Profession> professions;
    private List<Building> buildings;
    private List<Skills> skills;

    public EmpProfBuldSkil() {
    }

    public EmpProfBuldSkil(List<Employee> employees, List<Profession> professions, List<Building> buildings, List<Skills> skills) {
        this.employees = employees;
        this.professions = professions;
        this.buildings = buildings;
        this.skills = skills;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<Profession> professions) {
        this.professions = professions;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return employees + " " + professions + " " + buildings + " " + skills;
    }
}
