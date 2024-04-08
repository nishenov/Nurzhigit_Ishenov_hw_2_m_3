package com.example.nurzhigit_ishenov_hw_2_m_3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SendMessage extends Fragment {
    private EditText emailOfReceiver;
    private EditText themeOfMessage;
    private EditText messageText;
    private Button sendButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        emailOfReceiver = view.findViewById(R.id.et_email_of_receiver);
        themeOfMessage = view.findViewById(R.id.et_theme_of_message);
        messageText = view.findViewById(R.id.et_message_text);
        sendButton = view.findViewById(R.id.btn_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }
    private void sendEmail(){
        String email = emailOfReceiver.getText().toString().trim();
        String theme = themeOfMessage.getText().toString().trim();
        String message = messageText.getText().toString().trim();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + email));
        intent.putExtra(Intent.EXTRA_SUBJECT, theme);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(intent);
    }
}