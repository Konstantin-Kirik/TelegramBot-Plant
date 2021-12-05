package tableMySql;

public class Skills {
    private int id;
    private String level_skills;

    public Skills() {
    }

    public Skills(String level_skills) {
        this.level_skills = level_skills;
    }

    public Skills(int id, String level_skills) {
        this.id = id;
        this.level_skills = level_skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel_skills() {
        return level_skills;
    }

    public void setLevel_skills(String level_skills) {
        this.level_skills = level_skills;
    }

    @Override
    public String toString() {
        return "Навыки = " + level_skills + "\n"
                + "------------------------------------------\n";
    }
}
