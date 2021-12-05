package tableMySql;

public class Profession {
    private int id;
    private String profession_name;

    public Profession() {
    }

    public Profession(String profession_name) {
        this.profession_name = profession_name;
    }

    public Profession(int id, String profession_name) {
        this.id = id;
        this.profession_name = profession_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfession_name() {
        return profession_name;
    }

    public void setProfession_name(String profession_name) {
        this.profession_name = profession_name;
    }

    @Override
    public String toString() {
        return "Профессия : " + profession_name + "\n";
    }
}
