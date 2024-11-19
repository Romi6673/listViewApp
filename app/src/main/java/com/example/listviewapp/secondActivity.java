package com.example.listviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class secondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    double a1Double;

    TextView x1tv;
    TextView dtv;
    TextView ntv;
    TextView Sntv;

    ListView lV;
    String arr[] = new String[20];
    ArrayAdapter<String> adp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Sntv=findViewById(R.id.Sntv);
        x1tv=findViewById(R.id.x1tv);
        dtv=findViewById(R.id.dtv);
        lV = findViewById(R.id.lV);

        lV.setOnItemClickListener (this);
        lV.setChoiceMode (ListView.CHOICE_MODE_SINGLE) ;
        ntv=findViewById(R.id.ntv);


        adp = new ArrayAdapter<String>(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        lV.setAdapter(adp);






        Intent pi=getIntent();
        a1Double=pi.getDoubleExtra("a1",0);
        double dDouble=pi.getDoubleExtra("d",0);
        boolean bo=pi.getBooleanExtra("type",false);
        x1tv.setText(a1Double+"");
        dtv.setText(dDouble+"");

        arr[0]=String.valueOf(a1Double);
        if (bo==true){  //אם הסדרה חשבונית
            for (int i=0;i<arr.length;i++){
                double an=a1Double+dDouble*((i+1)-1);
                arr[i]=displayNumber(an);
            }


        }else {//אם זו סדרה הנדסית
            for (int i=1;i<arr.length;i++){
                double an=a1Double*Math.pow(dDouble,(i+1)-1);
                arr[i]=String.valueOf(an);
            }
        }


    }

    public static String displayNumber(double value) {
        if (Math.abs(value) < 10000 && value % 1 == 0) {
            return Integer.toString((int) value);
        }
        if (Math.abs(value) >= 10000) {
            double base = value;
            int magnitude = 0;

            while (Math.abs(base) >= 10000) {
                base /= 10;
                magnitude++;
            }

            return String.format("%d * 10^%d", (int) base, magnitude);
        }
        int magnitude = 0;
        double base = value;

        if (Math.abs(value) >= 1) {
            while (Math.abs(base) >= 10) {
                base /= 10;
                magnitude++;
            }
        } else {
            while (Math.abs(base) < 1) {
                base *= 10;
                magnitude--;
            }
        }

        return String.format("%.3f * 10^%d", base, magnitude);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        double sum=0;
        for (int i=0;i<=position;i++){
            sum+=Double.parseDouble(arr[i]);
        }
        Sntv.setText(displayNumber(sum)+"");
        ntv.setText(position+1+"");

    }

    public void go(View view) {
        Intent gi=new Intent(this,MainActivity.class);
        startActivity(gi);
    }
}