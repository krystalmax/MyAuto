package com.seogchan.superman.myauto;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by superman on 2017. 1. 24..
 */

public class FuelInfoActivity extends AppCompatActivity {

    EditText date, distance, price, amount, quantity, shop, memo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_fuelinfo);

        date = (EditText)findViewById(R.id.date);
        distance = (EditText)findViewById(R.id.distance);
        price = (EditText)findViewById(R.id.price);
        amount = (EditText)findViewById(R.id.amount);
        quantity = (EditText)findViewById(R.id.quantity);
        shop = (EditText)findViewById(R.id.shop);
        memo = (EditText)findViewById(R.id.meno);

        // 최근에 입력한 주유정보 세팅 (주행거리, 주유금액, 주유단가, 주유소)

        // 현재날짜 세팅
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault());
        String strDate = dateFormat.format(new Date());
        date.setText(strDate);
    }


    /*
    ** 날짜 입력
    */
    public void showDatePickerDialog(View v) {
        int year, month, day;
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day= calendar.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this, dateSetListener, year, month, day).show();
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String strDate = String.format("%d-%d-%d", year, monthOfYear+1, dayOfMonth);
            date.setText(strDate);
        }

    };

}
