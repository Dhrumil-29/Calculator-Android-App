package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public boolean pointcheck = false;
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
                String str = display.getText().toString();
                str = str + '1';
                display.setText(str);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString();
                str = str + '2';
                display.setText(str);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString();
                str = str + '3';
                display.setText(str);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString();
                str = str + '4';
                display.setText(str);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString();
                str = str + '5';
                display.setText(str);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString();
                str = str + '6';
                display.setText(str);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString();
                str = str + '7';
                display.setText(str);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString();
                str = str + '8';
                display.setText(str);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString();
                str = str + '9';
                display.setText(str);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString();
                if (str.length() != 0) {
                    str = str.substring(0, str.length() - 1);
                }
                display.setText(str);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText("");
                display.setText("");
                pointcheck = false;
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString();
                if (!pointcheck && str.length() != 0 && str.charAt(str.length() - 1) != '.') {
                    str = str + '.';
                    pointcheck = true;
                }
                display.setText(str);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString();
                str = str + '0';
                display.setText(str);
            }
        });
        plusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString();
                if (str.length() == 0) {
//                    Toast.makeText(MainActivity.this, "Press Any Digit First", Toast.LENGTH_SHORT).show();
                    str = '-' + str;
                } else if (str.charAt(0) == '-')
                    str = str.substring(1);
                else
                    str = '-' + str;
                display.setText(str);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = answer.getText().toString();
                String s = display.getText().toString();
                if (str.length() == 0 && s.length() == 0) {
                    Toast.makeText(equal.getContext(), "Press Any Digit First", Toast.LENGTH_SHORT).show();
                } else if (str.length() == 0) {
                    if (s.charAt(0) != '=') display.setText("= " + s);
//                    if(s.charAt(0) == '-') answer.setText("(" + s + ")");
//                    else answer.setText(s);
                } else if (str.length() != 0) {
                    if (s.length() > 0) {
                        if (s.charAt(0) == '-')
                            str += '(' + s + ')';
                        else
                            str += s;
                    }
                    System.out.println(str);
                    String num = "";
                    int idx = -1;
                    boolean pm = false;
                    char op = '.';
                    double ans = 0;
                    for (int i = 0; i < str.length(); i++) {
//                        System.out.println(num);
//                        System.out.println(op);
                        if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                            num += str.charAt(i);
                        } else if (str.charAt(i) == '.') {
                            num += str.charAt(i);
                        } else if (str.charAt(i) == '(') {
                            i++;
                            pm = true;
                        } else if (str.charAt(i) == ')') continue;
                        else {
                            op = str.charAt(i);
                            idx = i + 1;
                            break;
                        }
                    }
                    System.out.println(num);
                    System.out.println(op);
                    ans = Double.parseDouble(num);
                    if (pm == true)
                        ans = 0 - ans;
                    num = "";
                    pm = false;
                    for (int i = idx; i < str.length(); i++) {
//                        System.out.println(num);
//                        System.out.println(op);
                        if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                            num += str.charAt(i);
                        }  else if (str.charAt(i) == '.') {
                            num += str.charAt(i);
                        }  else if (str.charAt(i) == '(') {
                            i++;
                            pm = true;
                        } else if (str.charAt(i) == ')') continue;
                        else {
                            if (op == '+') {
                                double n = Double.parseDouble(num);
                                if (pm == true) n = 0 - n;
                                ans += n;
                                op = str.charAt(i);
                                pm = false;
//                                continue;
                            } else if (op == '-') {
                                double n = Double.parseDouble(num);
                                if (pm == true) n = 0 - n;
                                ans -= n;
                                op = str.charAt(i);
                                pm = false;
                            } else if (op == '*') {
                                System.out.println(num);
                                double n = Double.parseDouble(num);
                                System.out.println(n);
                                if (pm == true) n = 0 - n;
                                ans *= n;
                                op = str.charAt(i);
                                pm = false;
                            } else if (op == '/') {
                                double n = Double.parseDouble(num);
                                if (pm == true) {
                                    n = 0 - n;
                                }
                                ans /= n;
                                op = str.charAt(i);
                                pm = false;
                            }
                            num = "";
                        }
//                        System.out.println(num);
//                        System.out.println(op);
                    }
                    if(num.length()==0) num="0";
                    System.out.println("@@" + num);
                    double n = Double.parseDouble(num);
                    System.out.println(n);
                    if (pm) n = 0 - n;
                    if (num.length() != 0) {
                        if (op == '+')
                            ans += n;
                        if (op == '-')
                            ans -= n;
                        if (op == '*')
                            ans *= n;
                        if (op == '/')
                            ans /= n;
                    }

                    display.setText("= " + ans);
                    answer.setText("");
                    pointcheck = false;
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointcheck = false;
                String str = answer.getText().toString();
                String s = display.getText().toString();
                if (str.length() == 0 && s.length() == 0) {
                    Toast.makeText(plus.getContext(), "Press Any Digit First", Toast.LENGTH_SHORT).show();
                } else {
                    if (str.length() > 0 && s.length() == 0 && !(str.charAt(str.length() - 1) <= '9' && str.charAt(str.length() - 1) >= '0'))
//                        if (str.charAt(str.length() - 1) != '+')
                        str = str.substring(0, str.length() - 1);
                    else if (s.charAt(0) == '=') {
                        s = s.substring(2);
                    }

                    if (s.length() == 0) {
                        str += '+';
                        answer.setText(str);
                    } else {
                        if (s.charAt(0) == '-') {
                            s = '(' + s;
                            s += ')';
                        }
                        if (str.length() > 0) {
//                            System.out.println(str);
                            str = str + s + "+";
                        } else {
                            str += s;
                            str += "+";
                        }
                        System.out.println(str);
                        answer.setText(str);
                        display.setText("");
                    }
                }
                pointcheck = false;
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointcheck = false;
                String str = answer.getText().toString();
                String s = display.getText().toString();
                if (str.length() == 0 && s.length() == 0) {
                    Toast.makeText(minus.getContext(), "Press Any Digit First", Toast.LENGTH_SHORT).show();
                } else {
                    if (str.length() > 0 && s.length() == 0 && !(str.charAt(str.length() - 1) <= '9' && str.charAt(str.length() - 1) >= '0'))
//                        if (str.charAt(str.length() - 1) != '-')
                        str = str.substring(0, str.length() - 1);
                    else if (s.charAt(0) == '=') {
                        s = s.substring(2);
                    }
                    if (s.length() == 0) {
                        str += '-';
                        answer.setText(str);
                    } else {
                        if (s.charAt(0) == '-') {
                            s = '(' + s;
                            s += ')';
                        }
                        if (str.length() > 0) {
                            System.out.println(str);
                            str = str + s + "-";
                        } else {
                            str += s;
                            str += "-";
                        }
                        System.out.println(str);
                        answer.setText(str);
                        display.setText("");
                    }
                }
                pointcheck = false;
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointcheck = false;
                String str = answer.getText().toString();
                String s = display.getText().toString();
                if (str.length() == 0 && s.length() == 0) {
                    Toast.makeText(multiply.getContext(), "Clicked Add Add Cover", Toast.LENGTH_SHORT).show();
                } else {
                    if (str.length() > 0 && s.length() == 0 && !(str.charAt(str.length() - 1) <= '9' && str.charAt(str.length() - 1) >= '0'))
//                        if (str.charAt(str.length() - 1) != '*')
                        str = str.substring(0, str.length() - 1);
                    else if (s.charAt(0) == '=') {
                        s = s.substring(2);
                    }
                    if (s.length() == 0) {
                        str += '*';
                        answer.setText(str);
                    } else {
                        if (s.charAt(0) == '-') {
                            s = '(' + s;
                            s += ')';
                        }
                        if (str.length() > 0) {
                            System.out.println(str);
                            str = str + s + "*";
                        } else {
                            str += s;
                            str += "*";
                        }
                        System.out.println(str);
                        answer.setText(str);
                        display.setText("");
                    }
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointcheck = false;
                String str = answer.getText().toString();
                String s = display.getText().toString();
                if (str.length() == 0 && s.length() == 0) {
                    Toast.makeText(divide.getContext(), "Press Any Digit First", Toast.LENGTH_SHORT).show();
                } else {
                    if (str.length() > 0 && s.length() == 0 && !(str.charAt(str.length() - 1) <= '9' && str.charAt(str.length() - 1) >= '0'))
//                        if (str.charAt(str.length() - 1) != '/')
                        str = str.substring(0, str.length() - 1);
                    else if (s.charAt(0) == '=') {
                        s = s.substring(2);
                    }
                    if (s.length() == 0) {
                        str += '/';
                        answer.setText(str);
                    } else {
                        if (s.charAt(0) == '-') {
                            s = '(' + s;
                            s += ')';
                        }
                        if (str.length() > 0) {
                            System.out.println(str);
                            str = str + s + "/";
                        } else {
                            str += s;
                            str += "/";
                        }
                        System.out.println(str);
                        answer.setText(str);
                        display.setText("");
                    }
                }
                pointcheck = false;
            }
        });

    }
}