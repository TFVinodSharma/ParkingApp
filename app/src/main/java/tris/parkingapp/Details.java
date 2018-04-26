package tris.parkingapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Details extends AppCompatActivity {

     Button mDisplayDate,mDisplayTime;
      TextView showdate, showtime;
    private static  String TAG="Details";
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    // Get Current time
    final Calendar calender = Calendar.getInstance();
    int hour = calender.get(Calendar.HOUR_OF_DAY);
    int minute = calender.get(Calendar.MINUTE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        showdate=findViewById(R.id.date);
        showtime=findViewById(R.id.showtime);


        mDisplayDate=(Button) findViewById(R.id.dateselect);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month =cal.get(Calendar.MONTH);
                int date=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog;
                dialog = new DatePickerDialog(Details.this,
                        mDateSetListener,
                        year,month,date);
// .parseColor(""); causes the color.java file which is red mark inside it(ColorInt and Size), so remove this red mark  gone.
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FDD7E4")));
                dialog.show();

            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Log.d(TAG, "onDateSet:mm/dd/yy:" + month + "/" + day + "/" + year);
                String date = month+1 + "/" + day + "/" + year;
                showdate.setText(date);
            }
        };

    }

    public void ShowTime(View v)
    {
        mDisplayTime=(Button) findViewById(R.id.selecttime);
        TimePickerDialog timePickerDialog = new TimePickerDialog(Details.this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        showtime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);
        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FDD7E4")));
        timePickerDialog.show();

    }

}
