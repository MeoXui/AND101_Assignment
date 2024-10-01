package fpoly.huynkph38086.assignment;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import fpoly.huynkph38086.assignment.adapter.StaffAdap;
import fpoly.huynkph38086.assignment.model.Staff;

public class StaffAct extends ListAct {
    List<Staff> list;
    StaffAdap adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        list.add(new Staff("0", "mẫu", 0));
        adapter = new StaffAdap(this, list);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}