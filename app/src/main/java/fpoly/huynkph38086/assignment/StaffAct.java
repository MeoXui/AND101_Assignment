package fpoly.huynkph38086.assignment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fpoly.huynkph38086.assignment.adapter.StaffAdap;
import fpoly.huynkph38086.assignment.model.Staff;

public class StaffAct extends ListAct {
    List<Staff> list;
    StaffAdap adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        read();
        refresh(list);

        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                search(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void refresh(List<Staff> list) {
        adapter = new StaffAdap(this, list);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void search(String name) {
        List<Staff> searchList = list.stream().filter(s -> s.name.toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        refresh(searchList);
    }

    private void read() {
        try {
            FileInputStream fis = this.openFileInput("employee.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Staff>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void write() {
        try {
            FileOutputStream fos = this.openFileOutput("employee.txt", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        refresh(list);
    }
    
    public void add(Staff staff) {
        list.add(staff);
        write();
    }

    public void update(Staff staff) {
        for (Staff s : list)
            if (s.id.equals(staff.id)) {
                list.add(list.indexOf(s), staff);
                list.remove(s);
                write();
                return;
            }
        add(staff);
    }

    public void delete(String id) {
        list.removeIf(s -> s.id.equals(id));
        write();
    }
}