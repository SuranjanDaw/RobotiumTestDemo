package com.example.android.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {

    String infix = "";
    TextView exp;
    int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exp = findViewById(R.id.ExpText);
    }


    public void clearBtn(View view) {
        infix = "";
        exp.setText("");
    }

    public void getData(View view) {
        int id = view.getId();
        switch (id){
            case R.id.one: clear(); infix+="1"; break;
            case R.id.two: clear();infix+="2"; break;
            case R.id.three: clear();infix+="3"; break;
            case R.id.four: clear();infix+="4"; break;
            case R.id.five: clear();infix+="5"; break;
            case R.id.six: clear();infix+="6"; break;
            case R.id.seven: clear();infix+="7"; break;
            case R.id.eight: clear();infix+="8"; break;
            case R.id.nine: clear();infix+="9"; break;
            case R.id.zero: clear();infix+="0"; break;
            case R.id.plus: infix+="+"; break;
            case R.id.minus:  infix+="-"; break;
            case R.id.multiply: infix+="*"; break;
            case R.id.divide:  infix+="/"; break;
            case R.id.delete: if(infix.length()>=1){infix= infix.substring(0,infix.length()-1);} break;
            case R.id.dot: infix+="."; break;


        }
        state = 0;
        exp.setText(infix);

    }

    private void clear() {
        if (state == 1) {
            exp.setText("");
            infix = "";
        }
    }

    public void eval(View view) {
        String s;
        state = 1;
        try{
            s = ""+evaluate(infix);
            infix = s;
        }catch (Exception e){
            s = "Error";
            infix = "";
            Log.d("exp",e.toString());
        }
        exp.setText(s);

    }

    private String evaluate(String infix) {
        Expression expression =  new ExpressionBuilder(infix).build();
        double res = expression.evaluate();

        Log.d("exp",res+"");

        // For integer values
        if((int)res == res)
            return ""+(int)res;

        // For Decimal values truncate to correct to 2 decimal points
        return String.format("%.2f",res);
    }


    public void takeNotePage(View view) {
        Intent i = new Intent(MainActivity.this,NotesTaking.class);
        startActivity(i);
    }
}

