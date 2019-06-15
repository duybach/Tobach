package com.example.tobach;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private List<String> userList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView user_name;
        public ImageButton remove_user;

        public MyViewHolder(View view) {
            super(view);
            user_name = (TextView) view.findViewById(R.id.user_name);
            remove_user = (ImageButton) view.findViewById(R.id.remove_user);
        }
    }

    public UserAdapter(List<String> userList) {
        this.userList = userList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String user = userList.get(position);
        holder.user_name.setText(user);
        holder.remove_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userList.size() != 0) {
                    userList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, userList.size());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}