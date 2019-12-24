package com.ecommerce.mymall;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tapadoo.alerter.Alerter;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragement extends Fragment {

    private EditText email;
    private EditText password;
    private Button loginbutton;
    private FirebaseAuth Mauth;
    private ProgressDialog Mprogress;
    private TextView forgotpasswordtext;

    public LoginFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_fragement, container, false);

        Mprogress = new ProgressDialog(getContext());
        Mauth = FirebaseAuth.getInstance();
        email = view.findViewById(R.id.LoginEmailID);
        password = view.findViewById(R.id.LoginPasswordID);
        loginbutton = view.findViewById(R.id.LoginButtonID);

        forgotpasswordtext = view.findViewById(R.id.ForgotPasswordButtonID);
        forgotpasswordtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ForGotPasswordActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String emailtext = email.getText().toString();
                String passwordtext = password.getText().toString();

                if(emailtext.isEmpty()){
                    email.setError("Email require");
                }
                else if(passwordtext.isEmpty()){
                    password.setError("Password require");
                }
                else {
                    Mprogress.setTitle("Please wait");
                    Mprogress.setMessage("We are reading your email and password");
                    Mprogress.setCanceledOnTouchOutside(false);
                    Mprogress.show();
                    Mauth.signInWithEmailAndPassword(emailtext, passwordtext)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Mprogress.dismiss();
                                        Toast.makeText(getContext(), "success", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(getContext(), HomeActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                        getActivity().finish();
                                    }
                                    else {
                                        Mprogress.dismiss();
                                        Alerter.create(getActivity())
                                                .setTitle("Error")
                                                .setText(task.getException().getMessage().toString())
                                                .show();
                                        email.setText("");
                                        password.setText("");
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Mprogress.dismiss();
                            Alerter.create(getActivity())
                                    .setTitle("Error")
                                    .setText(e.getMessage().toString())
                                    .show();
                            email.setText("");
                            password.setText("");
                        }
                    });
                }
            }
        });

        return view;
    }


    @Override
    public void onStart() {
        FirebaseUser user = Mauth.getCurrentUser();
        if(user != null){
            Intent intent = new Intent(getContext(), HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            getActivity().finish();
        }
        super.onStart();
    }
}
