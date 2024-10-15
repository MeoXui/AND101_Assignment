package fpoly.huynkph38086.assignment.model;

import java.io.Serializable;

public class Staff implements Serializable {
    public String id;
    public String name;
    public int depart; //0: Nhân sự; 1: Hành chính; 2: Đào tạo;

    public Staff(String id, String name, int depart) {
        this.id = id;
        this.name = name;
        this.depart = depart;
    }
}
