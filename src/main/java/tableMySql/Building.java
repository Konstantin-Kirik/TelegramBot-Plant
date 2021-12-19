package tableMySql;

public class Building {

    private int id;
    private String number;

    public Building() {
    }

    public Building(String number) {
        this.number = number;
    }

    public Building(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
