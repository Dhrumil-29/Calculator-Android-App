package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button point;
    private Button zero;
    private Button clear;
    private Button plusminus;
    private ImageButton equal;
    private ImageButton back;
    private ImageButton divide;
    private ImageButton plus;
    private ImageButton minus;
    private ImageButton multiply;
    private TextView answer;
    private TextView display;
    public boolean pointcheck = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        point = findViewById(R.id.point);
        zero = findViewById(R.id.zero);
        plusminus = findViewById(R.id.plusminus);
        equal = findViewById(R.id.equal);
        divide = findViewById(R.id.divide);
        plus = findViewById(R.id.plus);
        clear = findViewById(R.id.clear);
        back = findViewById(R.id.back);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        answer = findViewById(R.id.answer);
        display = findViewById(R.id.display);
        pointcheck = false;

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                str = str + '1';
                answer.setText(str);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                str = str + '2';
                answer.setText(str);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                str = str + '3';
                answer.setText(str);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                str = str + '4';
                answer.setText(str);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                str = str + '5';
                answer.setText(str);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                str = str + '6';
                answer.setText(str);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                str = str + '7';
                answer.setText(str);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                str = str + '8';
                answer.setText(str);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                str = str + '9';
                answer.setText(str);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                if(str.length() != 0)
                {
                    str = str.substring(0,str.length()-1);
                }
                answer.setText(str);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText("");
                display.setText("");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                if(!pointcheck && str.length() != 0 && str.charAt(str.length()-1) != '.') {
                    str = str + '.';
                    pointcheck = true;
                }
                answer.setText(str);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                str = str + '0';
                answer.setText(str);
            }
        });
        plusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                if(str.length() == 0)
                {
//                    Toast.makeText(MainActivity.this, "Press Any Digit First", Toast.LENGTH_SHORT).show();
                    str = '-' + str;
                }
                else if(str.charAt(0) == '-')
                    str = str.substring(1);
                else
                    str = '-' + str;
                answer.setText(str);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                String s = display.getText().toString();
                if(str.length() == 0 && s.length() == 0){
                    Toast.makeText(MainActivity.this, "Press Any Digit First", Toast.LENGTH_SHORT).show();
                }
                else if((str.length() != 0)){
                    String num = "";
                    int idx = -1;
                    char op = '.';
                    double ans = 0;
                    for(int i = 0;i<str.length();i++)
                    {
//                        System.out.println(num);
//                        System.out.println(op);
                        if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                            num += str.charAt(i);
                        }
                        else
                        {
                            op = str.charAt(i);
                            idx = i+1;
                            break;
                        }
                    }
                    System.out.println(num);
                    System.out.println(op);
                    ans = Double.parseDouble(num);
//                    String num1 = "";
//                    String num2 = "";
                    num = "";
                    for(int i = idx;i<str.length();i++)
                    {
                        System.out.println(num);
                        System.out.println(op);
                        if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                            num += str.charAt(i);
                        }
                        else {
                            if (op == '+')
                            {
                                ans += Double.parseDouble(num);
                                op = str.charAt(i);
//                                continue;
                            }
                            else if (op == '-') {
                                ans -= Double.parseDouble(num);
                                op = str.charAt(i);
//                                continue;
                            }
                            else if (op == '*') {
                                ans *= Double.parseDouble(num);
                                op = str.charAt(i);
//                                continue;
                            }
                            else if (op == '/') {
                                ans /= Double.parseDouble(num);
                                op = str.charAt(i);
//                                continue;
                            }
                            num = "";
                        }
                        System.out.println(num);
                        System.out.println(op);
                    }
                    if(num.length() != 0) {
                        if (op == '+')
                            ans += Double.parseDouble(num);
                        if (op == '-')
                            ans -= Double.parseDouble(num);
                        if (op == '*')
                            ans *= Double.parseDouble(num);
                        if (op == '/')
                            ans /= Double.parseDouble(num);
                    }

                    display.setText(" = "+ans);
                    answer.setText(str);
                }
//                else if((str.length() == 0) && (s.length() != 0))
//                    display.setText(s);
//                else
//                {
//                    double ans = Double.parseDouble(s);
//                    String num2 = "";
//                    char op = '.';
//                    for(int i = str.length()-1;i >= 0;i--)
//                    {
//                        if(str.charAt(i) == '+'){
//                            op = '+';
//                            break;
//                        }
//                        if(str.charAt(i) == '-'){
//                            op = '-';
//                            break;
//                        }
//                        if(str.charAt(i) == '*'){
//                            op = '*';
//                            break;
//                        }
//                        if(str.charAt(i) == '/'){
//                            op = '/';
//                            break;
//                        }
//                        num2 = str.charAt(i) + num2;
//                    }
//                    if(op == '+')
//                        ans += Double.parseDouble(num2);
//                    if(op == '-')
//                        ans -= Double.parseDouble(num2);
//                    if(op == '*')
//                        ans *= Double.parseDouble(num2);
//                    if(op == '/')
//                        ans /= Double.parseDouble(num2);
//                    answer.setText(str);
//                    display.setText(""+ans);
//
//                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                String s = display.getText().toString();
                if(str.length() == 0 && s.length() == 0){
                    Toast.makeText(MainActivity.this, "Press Any Digit First", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(!(str.charAt(str.length()-1) <= '9' && str.charAt(str.length()-1) >= '0'))
                        str = str.substring(0, str.length() - 1);
                    str += '+';
                    answer.setText(str);
                }
            }
//                if(str.charAt(str.length()-1) <= '9' && str.charAt(str.length()-1) >= '0')
//                    str+= '+';
//                else {
//                    str = str.substring(0, str.length() - 1);
//                }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                String s = display.getText().toString();
                if(str.length() == 0 && s.length() == 0){
                    Toast.makeText(MainActivity.this, "Press Any Digit First", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(!(str.charAt(str.length()-1) <= '9' && str.charAt(str.length()-1) >= '0'))
                        str = str.substring(0, str.length() - 1);
                    str += '-';
                    answer.setText(str);
                }
//                if(str.charAt(str.length()-1) <= '9' && str.charAt(str.length()-1) >= '0')
//                    str+= '-';
//                else {
//                    str = str.substring(0, str.length() - 1);
//                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                String s = display.getText().toString();
                if(str.length() == 0 && s.length() == 0){
                    Toast.makeText(MainActivity.this, "Press Any Digit First", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(!(str.charAt(str.length()-1) <= '9' && str.charAt(str.length()-1) >= '0'))
                        str = str.substring(0, str.length() - 1);
                    str += '*';
                    answer.setText(str);
                }
//                if(str.charAt(str.length()-1) <= '9' && str.charAt(str.length()-1) >= '0')
//                    str+= '*';
//                else {
//                    str = str.substring(0, str.length() - 1);
//                }

            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                String s = display.getText().toString();
                if(str.length() == 0 && s.length() == 0){
                    Toast.makeText(MainActivity.this, "Press Any Digit First", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(!(str.charAt(str.length()-1) <= '9' && str.charAt(str.length()-1) >= '0'))
                        str = str.substring(0, str.length() - 1);
                    str += '/';
                    answer.setText(str);
                }
//                if(str.charAt(str.length()-1) <= '9' && str.charAt(str.length()-1) >= '0')
//                    str+= '/';
//                else {
//                    str = str.substring(0, str.length() - 1);
//                }

            }
        });

    }
}