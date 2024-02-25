

class User {
    private int id;
    static int counter = 0;
    private String name;
    private String login;
    private String password;

    public User(String name, String login, String password) {
        this.id = counter++;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getId(){ return this.id; }
    public String getName(){ return this.name; }
    public String getLogin(){ return this.login; }
    public String getPassword(){ return this.password; }

    public void setName(String newValue){ this.name = newValue; }
    public void setLogin(String newValue){ this.login = newValue; }
    public void setPassword(String newValue){ this.password = newValue; }
}

