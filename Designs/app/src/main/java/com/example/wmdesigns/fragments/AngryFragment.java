package com.example.wmdesigns.fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.wmdesigns.DisplayMessagesActivity;
//import com.example.wmdesigns.R;
import com.example.wmdesigns.listview_adapter.MessageAdapter;
import com.example.wmdesigns.listview_data.UserMessage;
import com.uos.designs.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AngryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AngryFragment extends Fragment {

    private static final int MY_PERMISSION_REQUEST_CALL_PHONE = 1;
    Button buttonSendText, call, buttonDisplay;
    EditText editTextMessage;
    EditText editTextEmail;
    private List<UserMessage> messageList = new ArrayList<>();
    private MessageAdapter messageAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AngryFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AngryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AngryFragment newInstance(String param1, String param2) {
        AngryFragment fragment = new AngryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_angry, container, false);

        editTextMessage = view.findViewById(R.id.text);
        buttonSendText = view.findViewById(R.id.buttonSendText);
        editTextEmail = view.findViewById(R.id.email);
        buttonDisplay = view.findViewById(R.id.display);
        call = view.findViewById(R.id.phone);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });

        buttonSendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTextMessage();
            }
        });


        buttonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = editTextEmail.getText().toString();

                if (!userEmail.isEmpty() && !messageList.isEmpty()) {
                    Intent intent = new Intent(requireContext(), DisplayMessagesActivity.class);
                    intent.putExtra("userEmail", userEmail);
                    intent.putExtra("messageList", (Serializable) messageList);
                    startActivity(intent);
                } else {
                    Toast.makeText(requireContext(), "Please enter your email and send messages first.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void makeCall() {
        Log.i("Make call to 3waash Designs?", "");
        String phoneNumber = "971543758384";
        String uri = "tel:" + phoneNumber;
        Intent phoneIntent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));

        if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{android.Manifest.permission.CALL_PHONE}, MY_PERMISSION_REQUEST_CALL_PHONE);
        } else {
            try {
                startActivity(phoneIntent);
            } catch (SecurityException ex) {
                Toast.makeText(requireContext(), "Call failed, try again later: " + ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    private void sendTextMessage() {
        String email = getEmail();
        String messageText = editTextMessage.getText().toString();

        if (!messageText.isEmpty() && !email.isEmpty()) {
            UserMessage newMessage = new UserMessage(messageText, email);
            messageList.add(newMessage);

            if (messageAdapter == null) {
                messageAdapter = new MessageAdapter(requireContext(), messageList);
            }

            messageAdapter.notifyDataSetChanged();
            editTextMessage.setText("");
            Toast.makeText(requireContext(), "Message sent..", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(requireContext(), "Please enter both email and message text", Toast.LENGTH_SHORT).show();
        }
    }

    private String getEmail() {
        String email = editTextEmail.getText().toString().trim();

        if (isValidEmail(email)) {
            return email;
        } else {
            Toast.makeText(requireContext(), "Invalid email format", Toast.LENGTH_SHORT).show();
            return "";
        }
    }

    private boolean isValidEmail(String email) {
        // Define a simple email validation using a regular expression
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        return email.matches(emailRegex);
    }

}