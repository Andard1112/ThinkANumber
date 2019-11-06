package com.example.thinkanumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button plusz,minusz,kuld;
    TextView szam;
    ImageView sziv1,sziv2,sziv3,sziv4,sziv5;
    Random rand;
    private AlertDialog.Builder felugroAblaknyert,felugroablakvesztett;
    int a,b,elet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        b=rand.nextInt(10);
        felugroAblaknyert = new AlertDialog.Builder(MainActivity.this);
        felugroAblaknyert.create();
        felugroAblaknyert.setTitle("Gratulálok ön nyert! Szeretne új játékot kezdeni?");
        felugroAblaknyert.setCancelable(false);
        felugroAblaknyert.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        felugroAblaknyert.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            a = 0;
            b=rand.nextInt(10);
            sziv1.setImageResource(R.drawable.heart2);
                sziv2.setImageResource(R.drawable.heart2);
                sziv3.setImageResource(R.drawable.heart2);
                sziv4.setImageResource(R.drawable.heart2);
                sziv5.setImageResource(R.drawable.heart2);
                elet = 5;
                szam.setText(a+"");
            }
        });
        felugroablakvesztett = new AlertDialog.Builder(MainActivity.this);
        felugroablakvesztett.create();
        felugroablakvesztett.setTitle("Sajnos ön vesztett! Szeretne új játékot kezdeni?");
        felugroablakvesztett.setCancelable(false);
        felugroablakvesztett.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        felugroablakvesztett.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                a = 0;
                b=rand.nextInt(10);
                sziv1.setImageResource(R.drawable.heart2);
                sziv2.setImageResource(R.drawable.heart2);
                sziv3.setImageResource(R.drawable.heart2);
                sziv4.setImageResource(R.drawable.heart2);
                sziv5.setImageResource(R.drawable.heart2);
                elet = 5;
                szam.setText(a+"");
            }
        });
    plusz.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        if (a != 10){
            a++;
            szam.setText(a+"");
        }else{
            Toast.makeText(MainActivity.this, "Elértük a maximumot!", Toast.LENGTH_SHORT).show();
        }
        }
    });
    minusz.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (a != 0){
                a--;
                szam.setText(a+"");
            }else{
                Toast.makeText(MainActivity.this, "Elértük a minimumot!", Toast.LENGTH_SHORT).show();
            }
        }
    });
    kuld.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (a == b){
                felugroAblaknyert.show();
            }else{
                if (elet == 5){
                    sziv1.setImageResource(R.drawable.heart1);
                    elet--;
                }else
                if (elet ==4){
                    sziv2.setImageResource(R.drawable.heart1);
                    elet--;
                }else
                if (elet == 3){
                    sziv3.setImageResource(R.drawable.heart1);
                    elet--;
                }else
                if (elet == 2){
                    sziv4.setImageResource(R.drawable.heart1);
                    elet--;
                }else
                if (elet == 1){
                    sziv5.setImageResource(R.drawable.heart1);

                    felugroablakvesztett.show();
                }
            }
        }
    });
    }
public void init(){
plusz = findViewById(R.id.plusz);
minusz = findViewById(R.id.minusz);
kuld = findViewById(R.id.kuld);
szam = findViewById(R.id.szam);
sziv1 = findViewById(R.id.sziv1);
    sziv2 = findViewById(R.id.sziv2);
    sziv3 = findViewById(R.id.sziv3);
    sziv4 = findViewById(R.id.sziv4);
    sziv5 = findViewById(R.id.sziv5);
    rand =new Random();
a = 0;
b = 0;
elet = 5;
}
}
