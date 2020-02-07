package com.example.rvstogg;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int ch =1;
    float font=30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv=(TextView) findViewById(R.id.textView);
        final Button bt1=(Button) findViewById(R.id.button);
        final Button bt2=(Button) findViewById(R.id.button2);
        final Button bt3=(Button) findViewById(R.id.button3);
        bt1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setTextSize(font);
                font+=5;
                if(font==50)
                    font=30;
            }
        });
        bt2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(ch){
                    case 1: tv.setTextColor(Color.RED); break;
                    case 2: tv.setTextColor(Color.BLUE); break;
                    case 3: tv.setTextColor(Color.GREEN); break;
                    case 4: tv.setTextColor(Color.CYAN); break;
                    case 5: tv.setTextColor(Color.MAGENTA); break;
                    case 6: tv.setTextColor(Color.YELLOW); break;

                };
                ch++;
                if(ch==7)
                    ch=1;
            }
        });
        bt3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText()=="CSE")
                    tv.setText("ISE");
                else
                    tv.setText("CSE");
            }
        });
    }
}
