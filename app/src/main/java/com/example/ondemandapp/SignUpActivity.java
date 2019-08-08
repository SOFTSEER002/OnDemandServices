package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    TextView tv_log;
    ImageView iv_register_back;
    EditText ed_signupname, ed_signupemail, ed_signuppassword, ed_signupmobile;
    AppCompatButton btn_register;
    public static final String DATABASE_NAME = "ONDEMANDSERVICES.db";
    public static final String TABLE_NAME = "signup";
    public static final String ID = "signupkey";
    public static final String NAME = "signupname";
    public static final String EMAIL = "signupemail";
    public static final String MOBILE = "signupmobile";
    public static final String PASSWORD = "signuppassword";
    static final String CHECK = "signcheck";
    String valuecheck="false";
    SQLiteDatabase sqLiteDatabase;
    String INSERT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        tv_log = findViewById(R.id.tv_log);
        iv_register_back = findViewById(R.id.iv_register_back);
        ed_signupmobile = findViewById(R.id.ed_signupmobile);
        ed_signupname = findViewById(R.id.ed_signupname);
        ed_signupemail = findViewById(R.id.ed_signupemail);
        ed_signuppassword = findViewById(R.id.ed_signuppassword);
        btn_register = findViewById(R.id.btn_register);


        sqLiteDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " VARCHAR," +
                EMAIL + " VARCHAR," + MOBILE + " VARCHAR," +CHECK + " VARCHAR," + PASSWORD + " VARCHAR" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);


        tv_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                finish();
            }
        });

        iv_register_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed_signupname.getText().toString().isEmpty() && ed_signupemail.getText().toString().isEmpty() &&
                        ed_signupmobile.getText().toString().isEmpty() && ed_signuppassword.getText().toString().isEmpty()) {
                    ed_signupname.setError("Enter name");
                    ed_signupemail.setError("Enter email");
                    ed_signupmobile.setError("Enter 10 digit mobile");
                    ed_signuppassword.setError("Enter password");
                } else if (ed_signupname.getText().toString().isEmpty()) {
                    ed_signupname.setError("Enter name");
                } else if (ed_signupemail.getText().toString().isEmpty()) {
                    ed_signupemail.setError("Enter email");
                } else if (ed_signupmobile.getText().toString().isEmpty()) {
                    ed_signupmobile.setError("Enter 10 digit mobile");
                } else if (ed_signuppassword.getText().toString().isEmpty()) {
                    ed_signuppassword.setError("Enter password");
                } else {

                    INSERT = "INSERT INTO " + TABLE_NAME + " ("
                            + NAME + ", " + EMAIL + ", " + MOBILE + ", " +CHECK + ", " +
                            PASSWORD + ") Values ('" + ed_signupname.getText().toString().trim() + "', '" +
                            ed_signupemail.getText().toString().trim() + "', '" + ed_signupmobile.getText().toString().trim() + "', '" +
                            valuecheck + "', '" +ed_signuppassword.getText().toString().trim() + "')";
                    sqLiteDatabase.execSQL(INSERT);
                    ed_signupname.setText("");
                    ed_signupemail.setText("");
                    ed_signupmobile.setText("");
                    ed_signuppassword.setText("");
                    Toast.makeText(SignUpActivity.this, "Signup successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
