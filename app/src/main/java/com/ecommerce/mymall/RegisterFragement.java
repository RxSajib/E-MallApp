package com.ecommerce.mymall;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tapadoo.alerter.Alerter;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragement extends Fragment {

    private EditText email;
    private EditText username;
    private EditText password;
    private EditText confrimpassword;
    private Button registerbutton;
    private FirebaseAuth Mauth;
    private ProgressDialog Mprogress;
    private FirebaseFirestore MprofileStore;

    public RegisterFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_fragement, container, false);

        MprofileStore = FirebaseFirestore.getInstance();

        Mprogress = new ProgressDialog(getContext());
        Mauth = FirebaseAuth.getInstance();

        email = view.findViewById(R.id.RegisterEmailID);
        password = view.findViewById(R.id.RegusterPasswordID);
        username = view.findViewById(R.id.RegisterUserNameID);
        confrimpassword = view.findViewById(R.id.RegisterConfrimPasswordID);

        registerbutton = view.findViewById(R.id.RegisterButtonID);

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = email.getText().toString();
                String usernametext = username.getText().toString();
                String passwordtext = password.getText().toString();
                String confrimpasstext = confrimpassword.getText().toString();

                if (emailtext.isEmpty()) {
                    email.setError("Email require");
                } else if (passwordtext.isEmpty()) {
                    password.setError("Password require");
                } else if (confrimpasstext.isEmpty()) {
                    confrimpassword.setError("Confrim password require");
                } else if (!confrimpasstext.equals(passwordtext)) {
                    password.setError("Password not match");
                    confrimpassword.setError("Password not match");
                } else if (confrimpasstext.length() <= 8) {
                    Toast.makeText(getContext(), "Password must need 8 char", Toast.LENGTH_LONG).show();
                } else {

                    Mprogress.setTitle("Please wait");
                    Mprogress.setMessage("We are creating your account");
                    Mprogress.setCanceledOnTouchOutside(false);
                    Mprogress.show();

                    Mauth.createUserWithEmailAndPassword(emailtext, passwordtext)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        Map<Object, String> usermap = new HashMap();
                                        usermap.put("user", username.getText().toString());
                                        MprofileStore.collection("User").add(usermap)
                                                .addOnCompleteListener(new OnCompleteListener() {
                                                    @Override
                                                    public void onComplete(@NonNull Task task) {
                                                        if (task.isSuccessful()) {
                                                            Mprogress.dismiss();
                                                            Toast.makeText(getContext(), "Success", Toast.LENGTH_LONG).show();
                                                            Intent intent = new Intent(getContext(), HomeActivity.class);
                                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                            startActivity(intent);
                                                            getActivity().finish();
                                                        } else {
                                                            Toast.makeText(getContext(), task.getException().getMessage().toString(), Toast.LENGTH_LONG).show();
                                                        }
                                                    }
                                                });


                                    } else {
                                        Mprogress.dismiss();
                                        Alerter.create(getActivity())
                                                .setTitle("Error")
                                                .setText(task.getException().getMessage().toString())
                                                .show();

                                        email.setText("");
                                        username.setText("");
                                        password.setText("");
                                        confrimpassword.setText("");

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
                            username.setText("");
                            password.setText("");
                            confrimpassword.setText("");
                        }
                    });
                }
            }
        });


        return view;
    }


    @Override
    public void onStart() {

        FirebaseUser Musers = Mauth.getCurrentUser();
        if (Musers != null) {
            Intent intent = new Intent(getContext(), HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            getActivity().finish();
        }

        super.onStart();
    }
}
