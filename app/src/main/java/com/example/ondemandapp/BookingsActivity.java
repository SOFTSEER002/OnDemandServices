package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ondemandapp.adapter.BookingServiceAdapter;
import com.example.ondemandapp.interfaces.DeleteBooking;

import java.util.ArrayList;
import java.util.List;

public class BookingsActivity extends AppCompatActivity implements DeleteBooking {
    ImageView iv_bookings_back;
    TextView tv_loginn;
    LinearLayout ll_login;
    SQLiteDatabase sqLiteDatabase, sqLiteDatabasee;
    RecyclerView rv_bookings;
    public static final String DATABASE_NAME = "ONDEMANDSERVICES.db";
    public static final String TABLE_NAME = "signup";
    public static final String ID = "signupkey";
    public static final String NAME = "signupname";
    public static final String EMAIL = "signupemail";
    public static final String MOBILE = "signupmobile";
    public static final String PASSWORD = "signuppassword";
    static final String CHECK = "signcheck";
    String logincheck = "false";

    public static final String DATABASEE_NAME = "BookingServices.db";
    public static final String TABLEE_NAME = "booking";
    public static final String IDD = "bookingkey";
    public static final String SERVICENAME = "servicename";
    public static final String SERVICETYPE = "servicetype";
    public static final String TOTALAMOUNT = "totalamount";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String DAY = "day";
    List<String> servicename = new ArrayList<>();
    List<String> servicetype = new ArrayList<>();
    List<String> day = new ArrayList<>();
    List<String> date = new ArrayList<String>();
    List<String> total = new ArrayList<>();
    List<String> time = new ArrayList<>();
    List<String> bookingid = new ArrayList<>();
    BookingServiceAdapter bsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);
        iv_bookings_back = findViewById(R.id.iv_bookings_back);
        tv_loginn = findViewById(R.id.tv_loginn);
        ll_login = findViewById(R.id.ll_login);
        rv_bookings = findViewById(R.id.rv_bookings);


        sqLiteDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " VARCHAR," +
                EMAIL + " VARCHAR," + MOBILE + " VARCHAR," + CHECK + " VARCHAR," + PASSWORD + " VARCHAR" + ")";
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

        if (logincheck.equals("false")) {

        } else {
            ll_login.setVisibility(View.GONE);
            sqLiteDatabasee = openOrCreateDatabase(DATABASEE_NAME, MODE_PRIVATE, null);
            String CREATEE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLEE_NAME +
                    "(" + IDD + " INTEGER PRIMARY KEY AUTOINCREMENT," + SERVICENAME + " VARCHAR," +
                    SERVICETYPE + " VARCHAR," + TOTALAMOUNT + " VARCHAR," + DATE + " VARCHAR," +
                    DAY + " VARCHAR," + TIME + " VARCHAR" + ")";
            sqLiteDatabasee.execSQL(CREATEE_TABLE);


showbookings();


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

    private void showbookings() {
        servicename.clear();
        servicetype.clear();
        date.clear();
        time.clear();
        day.clear();
        total.clear();
        String selectQuery1 = "SELECT  * FROM " + TABLEE_NAME;
        Cursor c = sqLiteDatabasee.rawQuery(selectQuery1, null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    servicename.add(c.getString(c.getColumnIndex(SERVICENAME)));
                    servicetype.add(c.getString(c.getColumnIndex(SERVICETYPE)));
                    date.add(c.getString(c.getColumnIndex(DATE)));
                    time.add(c.getString(c.getColumnIndex(TIME)));
                    day.add(c.getString(c.getColumnIndex(DAY)));
                    total.add(c.getString(c.getColumnIndex(TOTALAMOUNT)));
                    bookingid.add(c.getString(c.getColumnIndex(IDD)));

                } while (c.moveToNext());
            }
        }

        rv_bookings.setLayoutManager(new LinearLayoutManager(BookingsActivity.this, RecyclerView.VERTICAL, false));
        bsa = new BookingServiceAdapter(BookingsActivity.this, servicename, servicetype, date, time, day, total,bookingid,
                BookingsActivity.this);
        rv_bookings.setAdapter(bsa);
    }

    @Override
    public void deletebooking(int position, int bookingid) {
        sqLiteDatabasee.execSQL("DELETE FROM " + TABLEE_NAME + " WHERE " + IDD + "='" + bookingid + "'");
        showbookings();
        Toast.makeText(this, "Booking cancelled", Toast.LENGTH_SHORT).show();
    }
}
