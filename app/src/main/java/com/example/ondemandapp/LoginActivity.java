package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    TextView tv_forgot, tv_registerr;
    ImageView iv_login_back;
    EditText ed_email,ed_password;
Dialog d;
AppCompatButton btn_login;

    public static final String DATABASE_NAME = "ONDEMANDSERVICES.db";
    public static final String TABLE_NAME = "signup";
    public static final String ID = "signupkey";
    public static final String NAME = "signupname";
    public static final String EMAIL = "signupemail";
    public static final String MOBILE = "signupmobile";
    public static final String PASSWORD = "signuppassword";
    static final String CHECK = "signcheck";
    SQLiteDatabase sqLiteDatabase;
    String loginemail, loginpassword,loginId;
    String logincheck="false";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv_forgot = findViewById(R.id.tv_forgot);
        ed_email = findViewById(R.id.ed_email);
        ed_password = findViewById(R.id.ed_password);
        tv_registerr = findViewById(R.id.tv_registerr);
        iv_login_back = findViewById(R.id.iv_login_back);
        btn_login = findViewById(R.id.btn_login);

        d=new Dialog(LoginActivity.this);
        d.setContentView(R.layout.dialog_forgot_password);

        sqLiteDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " VARCHAR," +
                EMAIL + " VARCHAR," + MOBILE + " VARCHAR," +CHECK + " VARCHAR," + PASSWORD + " VARCHAR" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);


        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        String[] data = null;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    loginemail = cursor.getString(cursor.getColumnIndex(EMAIL));
                    loginpassword = cursor.getString(cursor.getColumnIndex(PASSWORD));
                    logincheck = cursor.getString(cursor.getColumnIndex(CHECK));
                    loginId = cursor.getString(cursor.getColumnIndex(ID));


                } while (cursor.moveToNext());
            }
        }


        tv_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
d.show();
            }
        });
        tv_registerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                finish();
            }
        });

        iv_login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed_email.getText().toString().isEmpty() && ed_password.getText().toString().isEmpty()) {
                    ed_email.setError("Enter email");
                    ed_password.setError("Enter password");
                } else if (ed_email.getText().toString().isEmpty()) {
                    ed_email.setError("Enter email");
                } else if (ed_password.getText().toString().isEmpty()) {
                    ed_password.setError("Enter password");
                } else {
                    if (ed_email.getText().toString().equals(loginemail) && ed_password.getText().toString().equals(loginpassword)) {

                        String update = "UPDATE " + TABLE_NAME + " SET " + CHECK + " = 'true' WHERE " + ID + " = " + loginId;
                        sqLiteDatabase.execSQL(update);

                        startActivity(new Intent(LoginActivity.this, BookingsActivity.class));
                        finish();
                    }
                    else {
                        ed_email.setText("");
                        ed_password.setText("");
                        ed_email.setError("Incorrect email");
                        ed_password.setError("Incorrect passwor");
                        Toast.makeText(LoginActivity.this, "Incorrect mobile or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
