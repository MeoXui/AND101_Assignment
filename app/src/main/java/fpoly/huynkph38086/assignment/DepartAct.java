package fpoly.huynkph38086.assignment;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fpoly.huynkph38086.assignment.adapter.DepartAdap;

public class DepartAct extends ListAct {
    List<String> list;
    DepartAdap adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fab.setVisibility(View.GONE);

        list = new ArrayList<>();
        list.add("Nhân sự");
        list.add("Hành chính");
        list.add("Đào tạo");
        adapter = new DepartAdap(this, list);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}