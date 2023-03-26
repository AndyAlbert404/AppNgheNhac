package com.example.appnghenhac.LG_and_RG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appnghenhac.R;
import com.example.appnghenhac.MainActivity;
import com.example.appnghenhac.Model.User;
import com.example.appnghenhac.fragment.HomeFragment;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity{
    private Button btLogin, btRegister;
    private EditText edUsernameC, edPasswordC;
    SharedPreferences.Editor editor;
    private final Gson gson = new Gson();
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        anhxa();
        taosukien();
    }
    private void anhxa()
    {
        btLogin = findViewById(R.id.btLogin);
        btRegister = findViewById(R.id.btRegister);
        edUsernameC = findViewById(R.id.edUsernameL);
        edPasswordC = findViewById(R.id.edPasswordL);
    }
    private void taosukien()
    {
        btLogin.setOnClickListener(v -> checkUserLogin());
        btRegister.setOnClickListener(funRegister());
    }
    private void checkUserLogin() {
        String userPref = sharedPreferences.getString(Utils.KEY_USER, null);
        User user = gson.fromJson(userPref, User.class);
        if (user == null){
            return;
        }
        boolean isValid = edUsernameC.getText().toString().trim().equals(user.getUsername()) && edPasswordC.getText().toString().trim().equals(user.getPassword());
        if (isValid){
            Intent intent = new Intent(this, MainActivity.class);
            //
            Bundle bundle = new Bundle();
            //
            bundle.putSerializable(Utils.KEY_USER_PROFILE, user);

            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    };
    private View.OnClickListener funRegister(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        };
    }

}
