package fpoly.huynkph38086.assignment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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

    public void refresh(List<String> list) {
        adapter = new DepartAdap(this, list);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void search(String name) {
        List<String> searchList = list.stream().filter(s -> s.toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        refresh(searchList);
    }
}