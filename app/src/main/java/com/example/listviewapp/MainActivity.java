package com.example.listviewapp;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.icu.util.MeasureUnit.Complexity.SINGLE;
import static android.media.MediaCodec.MetricsConstants.MODE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import android.content.Intent;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;

import android.widget.Switch;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    Switch switch1;
    Button nextBtn;
    EditText a1EditText ;
    EditText dEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        nextBtn=findViewById(R.id.nextBtn);
        a1EditText=findViewById(R.id.a1EditText);
        dEditText=findViewById(R.id.dEditText);
        switch1=findViewById(R.id.switch1);
    }




    public void go(View view) {

        boolean bo=false;
        String a1= a1EditText.getText().toString();

        String d= dEditText.getText().toString();

        if (a1.isEmpty() || d.isEmpty()) {
            Toast.makeText(this, "יש להזין ערכים עבור a1 ו-d", Toast.LENGTH_LONG).show();
            return;
        }

        double a1Num, dNum;

        try {
            a1Num = Double.parseDouble(a1);
            dNum = Double.parseDouble(d);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "יש להזין מספרים בלבד ", Toast.LENGTH_LONG).show();
            return;
        }


        if (switch1.isChecked()){ // אם זו סדרה חשבונית
            bo=true;
        }
        Intent si = new Intent(this,secondActivity.class);
        si.putExtra("a1",a1Num);
        si.putExtra("d",dNum);
        si.putExtra("type",bo);
        startActivity(si);
    }
}

