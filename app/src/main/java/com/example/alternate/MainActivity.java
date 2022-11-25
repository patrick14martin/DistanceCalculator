package com.example.alternate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText first,second,third,fourth;
    Integer x1,x2,y1,y2;
    double distance;

    public void CalculateDistance(View v) {
        first = findViewById(R.id.etNumber1);
        second = findViewById(R.id.etNumber2);
        third = findViewById(R.id.etNumber3);
        fourth = findViewById(R.id.etNumber4);


        Button calculate = findViewById(R.id.button);

        String a = first.getText().toString();
        String b = second.getText().toString();
        String c = third.getText().toString();
        String d = fourth.getText().toString();
        if(first.getText().toString().isEmpty() || second.getText().toString().isEmpty() || third.getText().toString().isEmpty() || fourth.getText().toString().isEmpty()){
            x1 = 0;
            y1 = 0;
            x2 = 0;
            y2 = 0;
        } else {
            x1 = Integer.parseInt(a);
            y1 = Integer.parseInt(b);
            x2 = Integer.parseInt(c);
            y2 = Integer.parseInt(d);
        }
        distance=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));

        String resultMessage = String.valueOf(distance);
        Bundle args=new Bundle();
        args.putString("result", resultMessage);
        DialogFragmentCustom dialogFragmentImp = new DialogFragmentCustom();
        dialogFragmentImp.setArguments(args);
        dialogFragmentImp.show(getSupportFragmentManager(),"Display Result");
        clearEditText();





    }
    public void clearEditText(){
        first.getText().clear();
        second.getText().clear();
        third.getText().clear();
        fourth.getText().clear();
        first.requestFocus();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}