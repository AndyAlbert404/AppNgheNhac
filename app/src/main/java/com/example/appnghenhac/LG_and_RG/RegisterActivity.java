package com.example.appnghenhac.LG_and_RG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appnghenhac.MainActivity;
import com.example.appnghenhac.Model.User;
import  com.google.gson.Gson;
import com.example.appnghenhac.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText edUsernameB, edPasswordB, edRepass, edEmail;
    private SharedPreferences.Editor editor;
    private Button btBack, btDangky;
    SharedPreferences sharedPreferences;
    private final Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");
        sharedPreferences = getSharedPreferences(Utils.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        taosukien();
        sukienDangky();
    }
    void anhxadulieu()
    {
        edUsernameB = findViewById(R.id.edUsernameR);
        edPasswordB = findViewById(R.id.edPasswordR);
        edRepass = findViewById(R.id.edRepass);
        edEmail = findViewById(R.id.edEmail);
        btDangky = findViewById(R.id.btRegister);
        btBack = findViewById(R.id.btBack);
    }

    void taosukien()
    {
        btDangky.setOnClickListener(v -> sukienDangky());
        btBack.setOnClickListener(v -> finish());
    }

    void sukienDangky()
    {
        String userName = edUsernameB.getText().toString().trim();
        String Password = edPasswordB.getText().toString().trim();
        String rePass = edRepass.getText().toString().trim();
        String email = edEmail.getText().toString().trim();
        boolean isVaild = checkUsername(userName) && checkPassword(Password, rePass);
        if(isVaild)
        {
            User userNew = new User();
            userNew.setUsername(userName);
            userNew.setPassword(Password);
            userNew.setEmail(email);
            //
            String userStr = gson.toJson(userNew);
            editor.putString(Utils.KEY_USER, userStr);
            editor.commit();
            //
            Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
            finish();
        }
    }
    private boolean checkUsername(String userName)
    {
        if (userName.isEmpty()){
            edUsernameB.setError("Vui lòng nhaạp tên người dùng");
            return  false;
        }
        if (userName.length() <= 5){
            edUsernameB.setError("Tên người dùng quá ngắn");
            return  false;
        }
        return  true;
    }
    private  boolean checkPassword(String password, String rePass)
    {
        if(password.isEmpty()){
            edPasswordB.setError("Vui lòng nhập mật khẩu");
            return false;
        }
        if (password.length() <= 5){
            edPasswordB.setError("Mật khẩu quá ngắn");
            return  false;
        }
        if (!password.equals(rePass)){
            edRepass.setError("Xác minh mật khẩu không đúng");
            return false;
        }
        return true;
    }
}