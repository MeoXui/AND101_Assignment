package fpoly.huynkph38086.assignment.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fpoly.huynkph38086.assignment.AddEditAct;
import fpoly.huynkph38086.assignment.R;
import fpoly.huynkph38086.assignment.StaffAct;
import fpoly.huynkph38086.assignment.model.Staff;

public class StaffAdap extends ArrayAdapter<Staff> {
    StaffAct activity;
    int itemLayout;

    public StaffAdap(StaffAct activity, List<Staff> list) {
        super(activity, R.layout.item_staff, list);
        this.activity = activity;
        itemLayout = R.layout.item_staff;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        if (view == null)
            view = LayoutInflater.from(activity).inflate(itemLayout, null);

        TextView tvID = view.findViewById(R.id.tv_id),
                tvName = view.findViewById(R.id.tv_name),
                tvDepart = view.findViewById(R.id.tv_depart);
        ImageButton ibDLT = view.findViewById(R.id.ib_dlt);

        Staff item = getItem(position);

        if (item != null) {
            view.setOnClickListener(v -> {
                Intent i = new Intent(activity, AddEditAct.class);
                i.putExtra("id", item.id);
                i.putExtra("name", item.name);
                i.putExtra("depart", item.depart);
                activity.arl.launch(i);
            });

            tvID.setText("NV" + item.id);
            tvName.setText("Họ tên: " + item.name);
            tvDepart.setText("Phòng ban: " + (item.depart == 0 ? "Nhân sự" : (item.depart == 1 ? "Hành chính" : (item.depart == 2 ? "Đào tạo" : "chưa có phòng ban"))));

            ibDLT.setOnClickListener(v -> activity.delete(item.id));
        }

        return view;
    }
}
