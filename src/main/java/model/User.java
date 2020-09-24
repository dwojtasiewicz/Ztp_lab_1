package model;

public class User {

    private String name;
    private String password;
    private Rola rola;

    public User(String name, String password, Rola rola)
    {
        this.name=name;
        this.password=password;
        this.rola=rola;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rola getRola() {
        return rola;
    }

    public void setRola(Rola rola) {
        this.rola = rola;
    }
}
