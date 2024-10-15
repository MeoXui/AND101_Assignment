package fpoly.huynkph38086.assignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fpoly.huynkph38086.assignment.R;

public class DepartAdap extends ArrayAdapter<String> {
    Context mContext;
    int itemLayout;

    public DepartAdap(Context context, List<String> list) {
        super(context, R.layout.item_depart, list);
        mContext = context;
        itemLayout = R.layout.item_depart;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        return fun(position, view);
    }

    @Override
    public View getDropDownView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        return fun(position, view);
    }

    View fun(int position, @Nullable View view) {
        if (view == null)
            view = LayoutInflater.from(mContext).inflate(itemLayout, null);

        TextView tv = view.findViewById(R.id.tv);

        String item = getItem(position);

        if (item != null) tv.setText(item);

        return view;
    }
}
