package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et;
    Button del,equal,one,two,three,four,five,six,seven,eight,nine,div,mul,minus,plus,zero,dot,mod;
    Float num1,num2,res;
    Boolean addition,subtract,multiply,divide,modulo;
    String ress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.et);
        del = (Button)findViewById(R.id.del);
        equal = (Button)findViewById(R.id.equal);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        div = (Button)findViewById(R.id.div);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        mul = (Button)findViewById(R.id.mul);
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        dot = (Button)findViewById(R.id.dot);
        zero = (Button)findViewById(R.id.zero);
        minus = (Button)findViewById(R.id.minus);
        mod = (Button)findViewById(R.id.mod);
        plus = (Button)findViewById(R.id.plus);

        del.setOnClickListener(this);
        equal.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        div.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        mul.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        dot.setOnClickListener(this);
        zero.setOnClickListener(this);
        minus.setOnClickListener(this);
        mod.setOnClickListener(this);
        plus.setOnClickListener(this);

    }
    public void onClick(View view){
        if(view == one) et.setText(et.getText().toString()+"1");
        if(view == two) et.setText(et.getText().toString()+"2");
        if(view == three) et.setText(et.getText().toString()+"3");
        if(view == four) et.setText(et.getText().toString()+"4");
        if(view == five) et.setText(et.getText().toString()+"5");
        if(view == six) et.setText(et.getText().toString()+"6");
        if(view == seven) et.setText(et.getText().toString()+"7");
        if(view == eight) et.setText(et.getText().toString()+"8");
        if(view == nine) et.setText(et.getText().toString()+"9");
        if(view == zero) et.setText(et.getText().toString()+"0");
        if(view == dot) et.setText(et.getText().toString()+".");
        if(view == del){
            et.setText("");
            addition = false;
            subtract = false;
            multiply = false;
            divide = false;
            modulo = false;
        }
        if(view == plus || view == minus || view == mul || view == div || view == mod){
            num1 = Float.parseFloat(et.getText().toString());
            et.setText("");
            if(view == plus) addition = true;
            if(view == minus) subtract = true;
            if(view == mul) multiply = true;
            if(view == div) divide = true;
            if(view == mod) modulo = true;
        }
        if(view == equal){
            if(addition || subtract || multiply || divide || modulo) {
                num2 = Float.parseFloat(et.getText().toString());
            }
            if(addition){
                res = num1 + num2;
                ress = String.valueOf(res);
                et.setText(ress);
                addition = false;
            }
            if(subtract){
                res = num1 - num2;
                ress = String.valueOf(res);
                et.setText(ress);
                subtract = false;
            }
            if(multiply){
                res = num1 * num2;
                ress = String.valueOf(res);
                et.setText(ress);
                multiply = false;
            }
            if(divide){
                res = num1 / num2;
                ress = String.valueOf(res);
                et.setText(ress);
                divide = false;
            }
            if(modulo) {
                res = num1 % num2;
                ress = String.valueOf(res);
                et.setText(ress);
                modulo =false;
            }
        }
    }
}
