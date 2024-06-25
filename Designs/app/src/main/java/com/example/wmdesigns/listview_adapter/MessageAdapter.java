package com.example.wmdesigns.listview_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wmdesigns.listview_data.UserMessage;
import com.uos.designs.R;

import java.util.List;
public class MessageAdapter extends ArrayAdapter<UserMessage> {

    public MessageAdapter(Context context, List<UserMessage> messages) {
        super(context, 0, messages);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        UserMessage message = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_message, parent, false);
        }

        TextView tvMessage = convertView.findViewById(R.id.tvMessage);
        TextView tvEmail = convertView.findViewById(R.id.tvEmail);

        if (message != null) {
            // Display only the user's email and message without any additional formatting
            tvMessage.setText(message.getMessageText());
            tvEmail.setText(message.getEmail());
        }

        return convertView;
    }
}
