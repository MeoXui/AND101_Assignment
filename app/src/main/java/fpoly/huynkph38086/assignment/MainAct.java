package fpoly.huynkph38086.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainAct extends AppCompatActivity {
    Button btnDepart, btnStaff, btnOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnDepart = findViewById(R.id.btn_depart);
        btnStaff = findViewById(R.id.btn_staff);
        btnOut = findViewById(R.id.btn_out);

        btnDepart.setOnClickListener(v -> startActivity(DepartAct.class));
        btnStaff.setOnClickListener(v -> startActivity(StaffAct.class));
        btnOut.setOnClickListener(v -> finish());
    }

    void startActivity(Class<?> activity) {
        startActivity(new Intent(this, activity));
    }
}