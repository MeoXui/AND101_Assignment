package fpoly.huynkph38086.assignment.model;

public class Staff {
    public String id;
    public String name;
    public int depart; //1: Nhân sự; 2: Hành chính; 3: Đào tạo;

    public Staff(String id, String name, int depart) {
        this.id = id;
        this.name = name;
        this.depart = depart;
    }
}
