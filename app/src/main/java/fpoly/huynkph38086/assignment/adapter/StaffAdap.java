package fpoly.huynkph38086.assignment.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
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
import fpoly.huynkph38086.assignment.model.Staff;

public class StaffAdap extends ArrayAdapter<Staff> {
    Context mContext;
    int itemLayout;

    public StaffAdap(Context context, List<Staff> list) {
        super(context, R.layout.item_staff, list);
        mContext = context;
        itemLayout = R.layout.item_staff;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        if (view == null)
            view = LayoutInflater.from(mContext).inflate(itemLayout, null);

        TextView tvID = view.findViewById(R.id.tv_id),
                tvName = view.findViewById(R.id.tv_name),
                tvDepart = view.findViewById(R.id.tv_depart);
        ImageButton ibDLT = view.findViewById(R.id.ib_dlt);

        Staff item = getItem(position);

        if (item != null) {
            tvID.setText(item.id);
            tvName.setText(item.name);
            switch (item.depart) {
                case 1: tvDepart.setText("Nhân sự"); break;
                case 2: tvDepart.setText("Hành chính"); break;
                case 3: tvDepart.setText("Đào tạo"); break;
                default: tvDepart.setText("chưa có phòng ban");
            }
        }

        ibDLT.setOnClickListener(v -> {});

        return view;
    }
}
