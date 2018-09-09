package com.example.luci4.basic_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equals;
    private Button clear;
    private Button dot;

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString()+"0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!text.getText().toString().matches(""))
                    text.setText(text.getText().toString() + "+" );
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!text.getText().toString().matches(""))
                    text.setText(text.getText().toString() + "-" );
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!text.getText().toString().matches(""))
                    text.setText(text.getText().toString() + "*" );
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!text.getText().toString().matches(""))
                    text.setText(text.getText().toString() + "/" );
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "." );
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String temp = text.getText().toString();
                if (!temp.matches("")) {
                    valueCalculation(temp);
                }
                else
                    text.setText("");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
            }
        });
    }

    private void valueCalculation(String s){

        float[] ans = new float[2];
        s = s+" ";
        String temp="";
        char ch = ' ',operator=' ';
        for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                ans[0]=Float.parseFloat(temp);
                temp="";
                operator = ch;
            }
            else if(ch==' '){ // added here
                ans[1]=Float.parseFloat(temp);
            }
            else{ // and here
                temp+=ch;
            }
        }



        switch(operator){
            case '+':
                text.setText(Float.toString(add(ans[0],ans[1])));
                break;
            case '-':
                text.setText(Float.toString(sub(ans[0],ans[1])));
                break;
            case '*':
                text.setText(Float.toString(mul(ans[0],ans[1])));
                break;
            case '/':
                text.setText(Float.toString(div(ans[0],ans[1])));
                break;
            default:
                text.setText("Operation Unavailable");
        }
    }


    private void setupUIViews(){
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);
        dot = (Button)findViewById(R.id.dot);
        add = (Button)findViewById(R.id.add);
        sub = (Button)findViewById(R.id.sub);
        mul = (Button)findViewById(R.id.mul);
        div = (Button)findViewById(R.id.div);
        clear = (Button)findViewById(R.id.clear);
        equals = (Button)findViewById(R.id.equals);

        text = (TextView)findViewById(R.id.text);
    }

    private float add(float a,float b){
        float sum = a+b;
        return sum;
    }
    private float sub(float a,float b){
        float dif = a-b;
        return dif;
    }
    private float mul(float a,float b){
        float mul = a*b;
        return mul;
    }
    private float div(float a,float b){
        float div = a/b;
        return div;
    }
}
