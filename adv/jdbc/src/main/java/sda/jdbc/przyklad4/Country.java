package sda.jdbc.przyklad4;

public class Country {

    private int id;
    private String name;
    private String alias;

    public Country(int id, String name, String alias) {
        this.id = id;
        this.name = name;
        this.alias = alias;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}