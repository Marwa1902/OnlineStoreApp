package com.example.wmdesigns;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wmdesigns.listview_adapter.MessageAdapter;
import com.example.wmdesigns.listview_data.UserMessage;
import com.uos.designs.R;

import java.util.List;

public class DisplayMessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        // Retrieve the user's email and message list from the intent
        String userEmail = getIntent().getStringExtra("userEmail");
        List<UserMessage> messageList = (List<UserMessage>) getIntent().getSerializableExtra("messageList");

        // Display messages in a ListView using the MessageAdapter
        ListView listView = findViewById(R.id.LVDisplay);
        MessageAdapter adapter = new MessageAdapter(this, messageList);
        listView.setAdapter(adapter);
    }
}
