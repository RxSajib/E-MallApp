package com.ecommerce.mymall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForGotPasswordActivity extends AppCompatActivity {

    private ProgressBar Mprogress;
    private ImageView progressimage;
    private ImageView infoimage;
    private TextView infotext;
    private EditText emailtext;
    private Button setsupbutton;
    private FirebaseAuth Mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_got_password);

        Mauth = FirebaseAuth.getInstance();
        setsupbutton = findViewById(R.id.ResetPasswordButtonID);
        emailtext = findViewById(R.id.ForgotEmailID);
        Mprogress = findViewById(R.id.ProgressBarID);
        progressimage = findViewById(R.id.ProgressImageID);
        infoimage = findViewById(R.id.SendMessageID);
        infotext = findViewById(R.id.MessageTextID);

        Mprogress.setVisibility(View.INVISIBLE);
        progressimage.setVisibility(View.INVISIBLE);

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.M){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        setsupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = emailtext.getText().toString();
                if(email.isEmpty()){
                    infoimage.setVisibility(View.VISIBLE);
                    infotext.setVisibility(View.VISIBLE);
                    infoimage.setBackgroundResource(R.drawable.erroricon);
                    infotext.setText("Input your email address");
                    emailtext.setText("");
                }
                else {
                    infoimage.setVisibility(View.INVISIBLE);
                    infotext.setVisibility(View.INVISIBLE);
                    Mprogress.setVisibility(View.VISIBLE);
                    progressimage.setVisibility(View.VISIBLE);

                    Mauth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @SuppressLint("ResourceAsColor")
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Mprogress.setVisibility(View.INVISIBLE);
                                        progressimage.setVisibility(View.INVISIBLE);
                                        infoimage.setVisibility(View.VISIBLE);
                                        infotext.setVisibility(View.VISIBLE);
                                        infoimage.setBackgroundResource(R.drawable.sendmessageicon);
                                        infotext.setText(email+ " we are send a message please cheack your inbox");
                                        emailtext.setText("");
                                    }
                                    else {
                                        Mprogress.setVisibility(View.INVISIBLE);
                                        progressimage.setVisibility(View.INVISIBLE);
                                        infoimage.setBackgroundResource(R.drawable.erroricon);
                                        infotext.setText(task.getException().getMessage().toString());
                                        infotext.setTextColor(R.color.cpb_red);
                                        emailtext.setText("");
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Mprogress.setVisibility(View.INVISIBLE);
                            progressimage.setVisibility(View.INVISIBLE);
                            infoimage.setBackgroundResource(R.drawable.erroricon);
                            infotext.setText(e.getMessage().toString());
                            infotext.setTextColor(R.color.cpb_red);
                            emailtext.setText("");
                        }
                    });
                }
            }
        });
    }
}
