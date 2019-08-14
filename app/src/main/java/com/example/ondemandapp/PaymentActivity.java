package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    LinearLayout ll_placerequest;
    RadioButton rd_card, rd_cash;
    String totalamount;
    TextView tv_payment_total, tv_service_total, tv_amount_payable, tv_service_pay, tv_amazonlink;
    SharedPreferences sp_total;
    SharedPreferences.Editor ed_total;
    ImageView iv_payment_back;
    public static final String DATABASEE_NAME = "BookingServices.db";
    public static final String TABLEE_NAME = "booking";
    public static final String IDD = "bookingkey";
    public static final String SERVICENAME = "servicename";
    public static final String SERVICETYPE = "servicetype";
    public static final String TOTALAMOUNT = "totalamount";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String DAY = "day";
    static final String CHECK = "signcheck";
    String valuecheck = "false";
    SQLiteDatabase sqLiteDatabasee;
    String INSERTT;
    String servicename, servicetype, day, time, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        radioGroup = findViewById(R.id.radioGroup);
        rd_card = findViewById(R.id.rd_card);
        rd_cash = findViewById(R.id.rd_cash);
        iv_payment_back = findViewById(R.id.iv_payment_back);
        tv_amazonlink = findViewById(R.id.tv_amazonlink);
        ll_placerequest = findViewById(R.id.ll_placerequest);
        tv_payment_total = findViewById(R.id.tv_payment_total);
        tv_service_pay = findViewById(R.id.tv_service_pay);
        tv_amount_payable = findViewById(R.id.tv_amount_payable);
        tv_service_total = findViewById(R.id.tv_service_total);

        sp_total = getSharedPreferences("BOOKINGSERVICE", MODE_PRIVATE);
        ed_total = sp_total.edit();

        totalamount = sp_total.getString("sum", "");
        servicename = sp_total.getString("servicee_name", "");
        servicetype = sp_total.getString("serviceee_type", "");
        day = sp_total.getString("day", "");
        time = sp_total.getString("time", "");
        date = sp_total.getString("date", "");

        tv_payment_total.setText("Rs. " + totalamount);
        tv_service_pay.setText("Rs. " + totalamount);
        tv_amount_payable.setText("Rs. " + totalamount);
        tv_service_total.setText("Rs. " + totalamount);


        sqLiteDatabasee = openOrCreateDatabase(DATABASEE_NAME, MODE_PRIVATE, null);
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLEE_NAME +
                "(" + IDD + " INTEGER PRIMARY KEY AUTOINCREMENT," + SERVICENAME + " VARCHAR," +
                SERVICETYPE + " VARCHAR," + TOTALAMOUNT + " VARCHAR," + DATE + " VARCHAR," +
                DAY + " VARCHAR," + TIME + " VARCHAR" + ")";
        sqLiteDatabasee.execSQL(CREATE_TABLE);

        ll_placerequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rd_cash.isChecked() || rd_card.isChecked()) {
                    startActivity(new Intent(PaymentActivity.this, PlaceRequestActivity.class));
                    INSERTT = "INSERT INTO " + TABLEE_NAME + " ("
                            + SERVICENAME + ", " + SERVICETYPE + ", " + TOTALAMOUNT + ", " + DATE + ", " + DAY + ", " +
                            TIME + ") Values ('" + servicename + "', '" +
                            servicetype + "', '" + totalamount + "', '" + date + "', '" + day + "', '" +
                            time + "')";
                    sqLiteDatabasee.execSQL(INSERTT);
                    //Toast.makeText(PaymentActivity.this, ""+INSERTT, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(PaymentActivity.this, "Select Payment Option", Toast.LENGTH_SHORT).show();
                }
            }
        });

        iv_payment_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }

        });

        tv_amazonlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amazon.com/gp/mas/dl/andro" + "id?p=com.yapp.blah"));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

    }
}
