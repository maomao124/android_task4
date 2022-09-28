package mao.android_task4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity
{

    int fontColor = 1;
    int fontStyle = 1;
    float font = 30;
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = findViewById(R.id.TextView);

        Button button1 = findViewById(R.id.Button1);
        Button button2 = findViewById(R.id.Button2);
        Button button3 = findViewById(R.id.Button3);

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                textView.setTextSize(font);
                font = font + 5;
                if (font == 50)
                {
                    font = 30;
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (fontColor)
                {
                    case 1:
                        textView.setTextColor(Color.RED);
                        break;
                    case 2:
                        textView.setTextColor(Color.GREEN);
                        break;
                    case 3:
                        textView.setTextColor(Color.BLUE);
                        break;
                    case 4:
                        textView.setTextColor(Color.CYAN);
                        break;
                    case 5:
                        textView.setTextColor(Color.YELLOW);
                        break;
                    case 6:
                        textView.setTextColor(Color.MAGENTA);
                        break;
                }
                fontColor++;
                if (fontColor == 7)
                {
                    fontColor = 1;
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    switch (fontStyle)
                    {
                        case 1:
                            typeface = Typeface.createFromAsset(getAssets(), "fonts/greatvibes.otf");
                            break;
                        case 2:
                            typeface = Typeface.createFromAsset(getAssets(), "fonts/montserrat.otf");
                            break;
                        case 3:
                            typeface = Typeface.createFromAsset(getAssets(), "fonts/opensans.ttf");
                            break;
                        case 4:
                            typeface = Typeface.createFromAsset(getAssets(), "fonts/pacifico.ttf");
                            break;
                        case 5:
                            typeface = Typeface.createFromAsset(getAssets(), "fonts/raleway.ttf");
                            break;
                        case 6:
                            typeface = Typeface.createFromAsset(getAssets(), "fonts/roboto.ttf");
                            break;
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity2.this, "异常：" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                textView.setTypeface(typeface);
                fontStyle++;
                if (fontStyle == 7)
                {
                    fontStyle = 1;
                }
            }
        });
    }
}