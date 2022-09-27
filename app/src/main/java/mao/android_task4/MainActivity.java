package mao.android_task4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this,"Hello, World", Toast.LENGTH_SHORT).show();

        TextView textView = findViewById(R.id.TextView_result);

        findViewById(R.id.Button1).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener()
                        {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                            {
                                textView.setText(year + "  " + (month + 1) + "   " + dayOfMonth);
                            }
                        }, Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MARCH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH));


                datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
                {
                    @Override
                    public void onCancel(DialogInterface dialog)
                    {
                        Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                        textView.setText("");
                    }
                });
                datePickerDialog.show();
            }
        });
    }
}