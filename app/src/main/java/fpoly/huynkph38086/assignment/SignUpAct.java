package fpoly.huynkph38086.assignment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpAct extends AppCompatActivity {
    EditText edUN, edPW, edEmail;
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

        edUN = findViewById(R.id.ed_un);
        edPW = findViewById(R.id.ed_pw);
        edEmail = findViewById(R.id.ed_email);
        btnUp = findViewById(R.id.btn_up);
        btnIn = findViewById(R.id.btn_in);

        btnUp.setOnClickListener(v -> finish());
        btnIn.setOnClickListener(v -> finish());
    }
}