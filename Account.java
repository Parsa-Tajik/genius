import java.io.Serializable;

public abstract class Account implements Serializable {
    private String name;
    private int age;
    private String email;
    private String username;
    private String password;

    public Account(String name, int age, String email, String username, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Account)) return false;

        Account acc = (Account) o;
        return this.getUsername().equals(acc.getUsername());
    }
}