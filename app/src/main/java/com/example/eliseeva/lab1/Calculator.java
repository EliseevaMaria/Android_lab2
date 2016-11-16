package com.example.eliseeva.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textView = (TextView) findViewById(R.id.text);
    }

    boolean textIsResult = false;

    public void AddNum(View target){
        if (textIsResult)
            textView.setText("");

        String curText = textView.getText().toString();
        String lastNumber = getLastNumber(curText);
        Log.d("tag", lastNumber);
        if (lastNumber.equals("0"))
            textView.setText(((Button) target).getText().toString());
        else
            textView.setText(curText + ((Button) target).getText().toString());

        textIsResult = false;
    }

    public void Add0(View target){
        if (textIsResult)
            textView.setText("");

        String curText = (String) textView.getText();
        String lastNumber = getLastNumber(curText);

        Pattern p = Pattern.compile("0+");
        Matcher m = p.matcher(lastNumber);
        if (m.matches())
            return;

        textView.setText(curText + "0");
        textIsResult = false;
    }

    public void AddDot(View target){
        if (textIsResult)
            textView.setText("");
        String curText = (String) textView.getText();
        if (curText.equals("") || curText.equals("-")){
            textView.setText(curText + "0.");
            textIsResult = false;
            return;
        }

        String lastNumber = getLastNumber(curText);
        if (lastNumber.indexOf('.') > -1)
            return;
        Character lastChar = curText.charAt(curText.length() - 1);
        if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/')
            textView.setText(curText + "0.");
        else
            textView.setText(curText + ".");
        textIsResult = false;
    }

    public void AddOperator(View target) {
        String curText = (String) textView.getText();
        String sign = ((Button) target).getText().toString();
        if (curText.equals("-"))
            return;
        if (!curText.equals("")) {
            Character lastChar = curText.charAt(curText.length() - 1);
            if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/'
                    || lastChar == '.')
                curText = curText.substring(0, curText.length() - 1);
            textView.setText(curText + sign);
        }
        else if (sign.equals("-"))
            textView.setText("-");
        textIsResult = false;
    }

    public void AddEqual(View target){
        Expression e = new ExpressionBuilder((String) textView.getText())
                .build();
        double result = e.evaluate();
        result = Math.rint(100000.0 * result) / 100000.0;
        if (result % 1.0 == 0)
            textView.setText(String.valueOf((int) result));
        else
            textView.setText(String.valueOf(result));
        textIsResult = true;
    }

    public void Backspace(View target){
        String curText = (String) textView.getText();
        if (!curText.equals(""))
            textView.setText(curText.substring(0, curText.length() - 1));
    }

    public void Delete(View target){
        textView.setText("");
    }

    private String getLastNumber(String text)
    {
        String lastNumber = "";
        for (int i = text.length() - 1; i >= 0; i--)
        {
            char textChar = text.charAt(i);
            if (Character.isDigit(textChar) || textChar == '.')
                lastNumber += textChar;
            else
                break;
        }
        return lastNumber;
    }
}
