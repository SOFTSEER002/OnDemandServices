package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BookingsActivity extends AppCompatActivity {
    ImageView iv_bookings_back;
    TextView tv_loginn;
    LinearLayout ll_login;
    SQLiteDatabase sqLiteDatabase;
    public static final String DATABASE_NAME = "ONDEMANDSERVICES.db";
    public static final String TABLE_NAME = "signup";
    public static final String ID = "signupkey";
    public static final String NAME = "signupname";
    public static final String EMAIL = "signupemail";
    public static final String MOBILE = "signupmobile";
    public static final String PASSWORD = "signuppassword";
    static final String CHECK = "signcheck";
    String logincheck="false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);
        iv_bookings_back = findViewById(R.id.iv_bookings_back);
        tv_loginn = findViewById(R.id.tv_loginn);
        ll_login = findViewById(R.id.ll_login);


        sqLiteDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " VARCHAR," +
                EMAIL + " VARCHAR," + MOBILE + " VARCHAR," +CHECK + " VARCHAR," + PASSWORD + " VARCHAR" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);


        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    logincheck = cursor.getString(cursor.getColumnIndex(CHECK));

                } while (cursor.moveToNext());
            }
        }

        if(logincheck.equals("false")){

        }
        else {
            ll_login.setVisibility(View.GONE);
            //Toast.makeText(this, "Show Bookings", Toast.LENGTH_SHORT).show();
        }




        iv_bookings_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tv_loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookingsActivity.this, LoginActivity.class));
            }
        });
    }
}
