package com.rosetvonline.rosetvonline.RoseC;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rosetvonline.rosetvonline.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private EditText email,password;
    private Button button_signIn, button_CreateUser;
    private TextView textView;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.pass);
        button_signIn = view.findViewById(R.id.btn_signIN);
        button_CreateUser =  view.findViewById(R.id.btn_signUP);
        textView = view.findViewById(R.id.textarea);

        firebaseAuth = FirebaseAuth.getInstance();

        button_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().isEmpty () && !password.getText().toString().isEmpty () ) {
                    firebaseAuth.signInWithEmailAndPassword (email.getText ().toString (), password.getText ().toString ());
                    //firebaseAuth.signInWithEmailAndPassword("s@y.com","123456")
                    firebaseAuth.signInWithEmailAndPassword (email.getText ().toString (), password.getText ().toString ())
                            .addOnCompleteListener (getActivity (), new OnCompleteListener<AuthResult> () {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful ()) {
                                        textView.setText ("login success");
                                        //startActivity(new Intent(Admin.this, MainActivity.class));
                                        FragmentManager fm = getFragmentManager ();
                                        FragmentTransaction ft = fm.beginTransaction ();
                                        ft.replace (R.id.admin_container, new Go_Y_Fragment ());
                                        //ft.addToBackStack(null);
                                        ft.commit ();
                                    }
                                }
                            })
                            .addOnFailureListener (getActivity (), new OnFailureListener () {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    //textView.setText(e.getLocalizedMessage());
                                }
                            });
                }
            }
        });

        button_CreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m = email.getText().toString();
                String p = password.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(m,p)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    textView.setText("successFull User Create");
                                }
                            }
                        })
                        .addOnFailureListener(getActivity(), new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                textView.setText(e.getLocalizedMessage());
                            }
                        });
            }
        });
        return view;
    }

}
