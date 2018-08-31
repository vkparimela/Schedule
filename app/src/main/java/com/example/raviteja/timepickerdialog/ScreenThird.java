package com.example.raviteja.timepickerdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class ScreenThird extends AppCompatActivity {
    Button set_starttime;
    Button set_endtime;
    Button set_schedule;
    TextView tv1;
    TextView tv2;
    AudioManager am;
    int DIALOG_ID1=1;
    int DIALOG_ID2=2;
    int hour_x,hour_y,c_hour;
    int minute_x,minute_y,c_min;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_first);
        showTimePickerDialog();
        Calendar cal = Calendar.getInstance();
        c_hour = cal.get(Calendar.HOUR_OF_DAY);
        c_min = cal.get(Calendar.MINUTE);
    }

    public final void showTimePickerDialog ()
    {
        set_starttime = (Button)findViewById(R.id.timepicker1);
        set_starttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID1);
            }
        });

        set_endtime = (Button)findViewById(R.id.timepicker2);
        set_endtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID2);
            }
        });

        set_schedule = (Button)findViewById(R.id.timesetter);
        set_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compareTime(hour_x,hour_y,c_hour,minute_x,minute_y,c_min);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID1)
            return new TimePickerDialog(ScreenThird.this,TimePickerListener1, hour_x, minute_x,true);
        if(id == DIALOG_ID2)
            return new TimePickerDialog(ScreenThird.this,TimePickerListener2, hour_y, minute_y,true);
        return null;
    }

    protected TimePickerDialog.OnTimeSetListener TimePickerListener1 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hour_x = hourOfDay;
            minute_x = minute;
            Toast.makeText(ScreenThird.this,hour_x+":"+minute_x,Toast.LENGTH_LONG).show();
            tv1 = (TextView) findViewById(R.id.tv1);
            tv1.setText(""+hour_x+":"+minute_x);
        }
    };

    protected TimePickerDialog.OnTimeSetListener TimePickerListener2 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hour_y = hourOfDay;
            minute_y = minute;
            Toast.makeText(ScreenThird.this,hour_y+":"+minute_y,Toast.LENGTH_LONG).show();
            tv2 = (TextView) findViewById(R.id.tv2);
            tv2.setText(""+hour_y+":"+minute_y);
        }
    };

    public void compareTime(int hour_x,int hour_y,int c_hour,int minute_x,int minute_y,int c_min){
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if((c_hour >= hour_x) && (c_hour <= hour_y)) {
            Toast.makeText(ScreenThird.this, " Mode on", Toast.LENGTH_LONG).show();
            am.setRingerMode(0);
        }
        else {
            Toast.makeText(ScreenThird.this,"Silent Mode off",Toast.LENGTH_LONG).show();
            am.setRingerMode(2);
        }
    }
}
