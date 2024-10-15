package fpoly.huynkph38086.assignment.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

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
            tvID.setText(item.id);
            tvName.setText(item.name);
            switch (item.depart) {
                case 0: tvDepart.setText("Nhân sự"); break;
                case 1: tvDepart.setText("Hành chính"); break;
                case 2: tvDepart.setText("Đào tạo"); break;
                default: tvDepart.setText("chưa có phòng ban");
            }

            ibDLT.setOnClickListener(v -> activity.delete(item.id));
        }

        return view;
    }
}
