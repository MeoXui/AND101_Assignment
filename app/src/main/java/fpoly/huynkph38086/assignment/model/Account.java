package fpoly.huynkph38086.assignment.model;

import java.io.Serializable;

public class Account implements Serializable {
    public String username;
    public String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
