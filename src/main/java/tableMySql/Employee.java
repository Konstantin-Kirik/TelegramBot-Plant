package tableMySql;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private int personnel_number;
    private String born;
    private String education;

    public Employee() {

    }

    public Employee(String name, String surname, String patronymic, int personnel_number, String born, String education) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.personnel_number = personnel_number;
        this.born = born;
        this.education = education;
    }

    public Employee(int id, String name, String surname, String patronymic, int personnel_number, String born, String education) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.personnel_number = personnel_number;
        this.born = born;
        this.education = education;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getPersonnel_number() {
        return personnel_number;
    }

    public void setPersonnel_number(int personnel_number) {
        this.personnel_number = personnel_number;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic + "\n"
                + "Табельный номер : " + personnel_number + "\n"
                + "Год рождения : " + born + " \n"
                + "Образование : " + education + "\n\n";
    }
}
