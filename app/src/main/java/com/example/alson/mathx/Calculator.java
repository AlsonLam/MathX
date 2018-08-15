package com.example.alson.mathx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class Calculator extends AppCompatActivity {
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private ImageButton add;
    private ImageButton sub;
    private ImageButton mul;
    private Button div;
    private Button equal;
    private Button clear;
    private TextView info;
    private TextView result;
    private Button openbrackets;
    private Button closebrackets;
    private Button decimal;
    private Button sqroot;
    private ImageButton delete;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '0' ;
    private double vall = Double.NaN;
    private double vall2;
    private char ACTION;
    public String equation = "";
    public String pastequation = "";
    public String pastans = "";
    public Boolean answered = false;
    public Boolean firsttime = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        setupUIViews();



        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == true) {
                    equation = "";
                    answered = false;
                }

                equation = equation + "0";
                info.setText(equation);

            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == true) {
                    equation = "";
                    answered = false;
                }
                equation = equation + "1";
                info.setText(equation);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == true) {
                    equation = "";
                    answered = false;
                }
                equation = equation + "2";
                info.setText(equation);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == true) {
                    equation = "";
                    answered = false;
                }
                equation = equation + "3";
                info.setText(equation);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == true) {
                    equation = "";
                    answered = false;
                }
                equation = equation + "4";
                info.setText(equation);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == true) {
                    equation = "";
                    answered = false;
                }
                equation = equation + "5";
                info.setText(equation);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == true) {
                    equation = "";
                    answered = false;
                }
                equation = equation + "6";
                info.setText(equation);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == true) {
                    equation = "";
                    answered = false;
                }
                equation = equation + "7";
                info.setText(equation);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == true) {
                    equation = "";
                    answered = false;
                }
                equation = equation + "8";
                info.setText(equation);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == true) {
                    equation = "";
                    answered = false;
                }
                equation = equation + "9";
                info.setText(equation);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "+";
                info.setText(equation);
                answered = false;
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "-";
                info.setText(equation);
                answered = false;
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.length() != 0) {
                    equation = equation + "*";
                    info.setText(equation);
                    answered = false;
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.length() != 0) {
                    equation = equation + "/";
                    info.setText(equation);
                    answered = false;
                }
            }
        });
        openbrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equation.length() == 0){
                    equation = equation + "(";
                    info.setText(equation);
                    answered = false;
                }else {
                    try{
                        Integer hi = Integer.parseInt(equation.substring(equation.length()-1));
                        equation = equation + "*(";
                        info.setText(equation);
                        answered = false;
                    }catch (NumberFormatException ex) {
                        equation = equation + "(";
                        info.setText(equation);
                        answered = false;
                    }

                }
            }
        });
        closebrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                equation = equation + ")";
                info.setText(equation);
                answered = false;

            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.length() != 0) {
                    equation = equation + ".";
                    info.setText(equation);
                    answered = false;
                }
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + ".";
                info.setText(equation);
                answered = false;
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered ==true){

                }else {
                    equation = removeLastChar(equation);
                    info.setText(equation);
                }
            }
        });
        sqroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.length() != 0) {
                    System.out.println(pastans);
                    equation = equation.replace("Ans", "(" + pastans + ")");
                    equation = equation.replace("--", "+");
                    String string1 = "+";
                    Integer initial = equation.length();
                    for (int y = 0; y <= equation.length(); y++) {
                        System.out.println(y);
                        string1 = "+";
                        for (int x = 0; x <= initial - y + 1; x++) {
                            string1 = string1 + "+";
                        }
                        System.out.println(string1);
                        equation = equation.replace(string1, "+");
                    }
                    equation = equation.replace("+-", "-");
                    equation = equation.replace("-+", "-");
                    equation = equation.replace(")(", ")*(");
                    equation = "sqrt(" + equation + ")";
                    Expression e = new Expression(equation);
                    mXparser.consolePrintln("Res: " + e.getExpressionString() + " = " + e.calculate());
                    mXparser.consolePrintln(e.checkSyntax());
                    if (e.checkSyntax() == true) {
                        info.setText("" + e.calculate());
                        result.setText(e.getExpressionString() + " = " + e.calculate());
                        equation = "Ans";
                        pastans = "" + e.calculate();
                        answered = true;
                    } else {
                        info.setText("Syntax error");

                    }

                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.length() != 0) {
                    System.out.println(pastans);
                    equation = equation.replace("Ans", "(" + pastans + ")");
                    equation = equation.replace("--", "+");
                    String string1 = "+";
                    Integer initial = equation.length();
                    for (int y = 0; y <= equation.length() + 1; y++) {
                        System.out.println(y);
                        string1 = "+";
                        for (int x = 0; x <= initial - y + 1; x++) {
                            string1 = string1 + "+";
                        }
                        System.out.println(string1);
                        equation = equation.replace(string1, "+");
                    }
                    equation = equation.replace("+-", "-");
                    equation = equation.replace("-+", "-");
                    equation = equation.replace(")(", ")*(");
                    Expression e = new Expression(equation);
                    mXparser.consolePrintln("Res: " + e.getExpressionString() + " = " + e.calculate());
                    mXparser.consolePrintln(e.checkSyntax());
                    if (e.checkSyntax() == true) {
                        info.setText("" + e.calculate());
                        result.setText(e.getExpressionString() + " = " + e.calculate());
                        equation = "Ans";
                        pastans = "" + e.calculate();
                        answered = true;
                    } else {
                        info.setText("Syntax error");

                    }

                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = "";
                info.setText("");
                result.setText("");
            }
        });
    }
    private void setupUIViews(){
        one = (Button) findViewById(R.id.btn1);
        zero = (Button) findViewById(R.id.btn0);
        two = (Button) findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);
        six = (Button) findViewById(R.id.btn6);
        seven = (Button) findViewById(R.id.btn7);
        eight = (Button) findViewById(R.id.btn8);
        nine = (Button) findViewById(R.id.btn9);
        add = (ImageButton) findViewById(R.id.btnadd);
        sub = (ImageButton) findViewById(R.id.btnsub);
        mul = (ImageButton) findViewById(R.id.btnmul);
        div = (Button) findViewById(R.id.btndivide);
        equal = (Button) findViewById(R.id.btnequal);
        info = (TextView) findViewById(R.id.tvControl);
        result = (TextView) findViewById(R.id.tvResult);
        clear = (Button) findViewById(R.id.btnclear);
        openbrackets = (Button) findViewById(R.id.butnopenbrackets);
        closebrackets = (Button) findViewById(R.id.butnclosebrackets);
        decimal = (Button) findViewById(R.id.butb);
        delete =  (ImageButton) findViewById(R.id.butndelet);
        sqroot =  (Button) findViewById(R.id.butnsquareroot);

    }
    public String removeLastChar(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, s.length()-1);
    }

}