package fpoly.huynkph38086.assignment.model;

import java.io.Serializable;

public class Staff implements Serializable {
    public int id;
    public String name;
    public int depart; //0: Nhân sự; 1: Hành chính; 2: Đào tạo;

    public Staff() {
        id = -1;
    }

    public Staff(String name, int depart) {
        id = -1;
        this.name = name;
        this.depart = depart;
    }
}
