package fpoly.huynkph38086.assignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import fpoly.huynkph38086.assignment.model.Account;

public class LoginAct extends AppCompatActivity {
    TextInputLayout tilUn, tilPw;
    CheckBox chkRe;
    Button btnIn, btnUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tilUn = findViewById(R.id.til_un);
        tilUn.setErrorEnabled(false);
        tilPw = findViewById(R.id.til_pw);
        tilPw.setErrorEnabled(false);
        chkRe = findViewById(R.id.chk_re);
        btnIn = findViewById(R.id.btn_in);
        btnUp = findViewById(R.id.btn_up);

        reme();

        chkRe.setOnCheckedChangeListener((buttonView, isChecked) -> memo());

        btnIn.setOnClickListener(v -> login());

        btnUp.setOnClickListener(v -> startActivity(SignUpAct.class));
    }

    void login() {
        String sUn = tilUn.getEditText().getText().toString();
        String sPw = tilPw.getEditText().getText().toString();

        if (sUn.isEmpty()) {
            tilUn.setErrorEnabled(true);
            tilUn.setError("Vui lòng nhập");
            return;
        }
        tilUn.setErrorEnabled(false);
        tilUn.setError(null);

        if (sPw.isEmpty()) {
            tilPw.setErrorEnabled(true);
            tilPw.setError("Vui lòng nhập");
            return;
        }
        tilPw.setErrorEnabled(false);
        tilPw.setError(null);

        List<Account> list;
        try {
            FileInputStream fis = this.openFileInput("account.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Account>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Account a : list) {
            if (sUn.equals(a.username)) {
                tilUn.setErrorEnabled(false);
                tilUn.setError(null);
                if (sPw.equals(a.password)) {
                    tilPw.setErrorEnabled(false);
                    tilPw.setError(null);
                    memo();
                    startActivity(MainAct.class);
                    return;
                } else {
                    tilPw.setErrorEnabled(true);
                    tilPw.setError("Sai mật khẩu");
                }
                return;
            } else {
                tilUn.setErrorEnabled(true);
                tilUn.setError("Tài khoản chưa tồn tại");
            }
        }
    }

    void memo() {
        SharedPreferences sp = getSharedPreferences("re", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        boolean re = chkRe.isChecked();
        editor.putBoolean("re", re);
        if (re) {
            editor.putString("un", tilUn.getEditText().getText().toString());
            editor.putString("pw", tilPw.getEditText().getText().toString());
        }
        editor.apply();
    }

    void reme() {
        SharedPreferences sp = getSharedPreferences("re", MODE_PRIVATE);
        boolean re = sp.getBoolean("re", false);
        chkRe.setChecked(re);
        if (re) {
            tilUn.getEditText().setText(sp.getString("un", ""));
            tilPw.getEditText().setText(sp.getString("pw", ""));
        }
    }

    void startActivity(Class<?> activity) {
        startActivity(new Intent(this, activity));
    }
}