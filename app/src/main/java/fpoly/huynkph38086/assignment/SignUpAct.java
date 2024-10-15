package fpoly.huynkph38086.assignment;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import fpoly.huynkph38086.assignment.model.Account;

public class SignUpAct extends AppCompatActivity {
    TextInputLayout tilUn, tilPw;
    Button btnIn, btnUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tilUn = findViewById(R.id.til_un);
        tilPw = findViewById(R.id.til_pw);
        btnUp = findViewById(R.id.btn_up);
        btnIn = findViewById(R.id.btn_in);

        btnUp.setOnClickListener(v -> signUp());
        btnIn.setOnClickListener(v -> finish());
    }

    void signUp() {
        String sUn = tilUn.getEditText().getText().toString();
        String sPw = tilPw.getEditText().getText().toString();

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

        if (sUn.isEmpty()) {
            tilUn.setErrorEnabled(true);
            tilUn.setError("Vui lòng nhập");
            return;
        }

        for (Account a : list)
            if (sUn.equals(a.username)) {
                tilUn.setErrorEnabled(true);
                tilUn.setError("Tài khoản đã tồn tại");
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

        try {
            FileOutputStream fos = this.openFileOutput("account.txt", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            list.add(new Account(sUn, sPw));
            oos.writeObject(list);
            oos.close();
            fos.close();
            finish();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}