package fpoly.huynkph38086.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginAct extends AppCompatActivity {
    EditText edUN, edPW;
    Button btnIN, btnUP;

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

        edUN = findViewById(R.id.ed_un);
        edPW = findViewById(R.id.ed_pw);
        btnIN = findViewById(R.id.btn_in);
        btnUP = findViewById(R.id.btn_up);

        btnIN.setOnClickListener(v -> startActivity(MainAct.class));
        btnUP.setOnClickListener(v -> startActivity(SignUpAct.class));
    }

    void startActivity(Class<?> activity) {
        startActivity(new Intent(this, activity));
    }
}