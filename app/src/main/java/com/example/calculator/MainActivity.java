package com.example.calculator;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void onClick(View v) {
        EditText firstNumET = findViewById(R.id.firstNum);
        EditText secondNumET = findViewById(R.id.secondNum);
        try {
            String stringNum1 = firstNumET.getText().toString();
            String stringNum2 = secondNumET.getText().toString();
            if (isInteger(stringNum1) && isInteger(stringNum2)) {
                int firstNum = Integer.parseInt(stringNum1);
                int secondNum = Integer.parseInt(stringNum2);
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("firstNum", firstNum);
                intent.putExtra("secondNum", secondNum);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Неверные данные", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}