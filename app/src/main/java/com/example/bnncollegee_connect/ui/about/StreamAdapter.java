package com.example.bnncollegee_connect.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.bnncollegee_connect.R;

import java.util.List;

public class StreamAdapter extends PagerAdapter {
    private Context context;
    private List<StreamModel> list;

    public StreamAdapter(Context context, List<StreamModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.stream_item_layout,container,false);

        ImageView streamIcon;
        TextView streamTitle, streamDescription, streamDescription2 ;

        streamIcon = view.findViewById(R.id.streamIcon);
        streamTitle = view.findViewById(R.id.streamTitle);
        streamDescription = view.findViewById(R.id.streamDescription);


        streamIcon.setImageResource(list.get(position).getImg());
        streamTitle.setText(list.get(position).getTitle());
        streamDescription.setText(list.get(position).getDescription());


        container.addView(view,0);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
