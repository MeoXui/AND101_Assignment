package fpoly.huynkph38086.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import fpoly.huynkph38086.assignment.adapter.DepartAdap;

public class AddEditAct extends AppCompatActivity {
    TextInputLayout til;
    Spinner spn;
    Button btn;

    List<String> list;
    DepartAdap adapter;

    public static final int ResultCode = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_edit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        til = findViewById(R.id.til);
        til.setErrorEnabled(false);
        spn = findViewById(R.id.spn);
        btn = findViewById(R.id.btn);

        list = new ArrayList<>();
        list.add("Nhân sự");
        list.add("Hành chính");
        list.add("Đào tạo");
        adapter = new DepartAdap(this, list);
        spn.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        Intent i = getIntent();
        if (i.getIntExtra("id", -1) >= 0) {
            til.getEditText().setText(i.getStringExtra("name"));
            spn.setSelection(i.getIntExtra("depart", 0));
        }

        btn.setOnClickListener(v -> validate(i.getIntExtra("id", -1)));
    }

    void validate(int id) {
        String name = til.getEditText().getText().toString();

        if (name.isEmpty()) {
            til.setErrorEnabled(true);
            til.setError("Vui lòng nhập");
            return;
        }
        til.setErrorEnabled(false);
        til.setError(null);

        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putInt("id", id);
        b.putString("name", name);
        b.putInt("depart", spn.getSelectedItemPosition());
        i.putExtras(b);
        setResult(ResultCode, i);
        finish();
    }
}