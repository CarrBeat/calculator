package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        try {
            TextView textView = (TextView) findViewById(R.id.resView);
            Integer firstNum = getIntent().getExtras().getInt("firstNum");
            Integer secondNum = getIntent().getExtras().getInt("secondNum");
            int sum = firstNum + secondNum;
            textView.setText(firstNum.toString() + " + " + secNeg(secondNum) + " = " + sum);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public String secNeg(Integer num) {
        if (num < 0) {
            return "(" + num.toString() + ")";
        }
        return num.toString();
    }
}