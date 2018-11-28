package com.example.karen.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean cont;
    int idCount;
    String clickS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cont = true;
        idCount = 0;
        clickS = "";

        View view = new View(this);

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int deviceHeight = displayMetrics.heightPixels;
        int deviceWidth = displayMetrics.widthPixels;

        LinearLayout littles = new LinearLayout(this);
        littles.setOrientation(LinearLayout.VERTICAL);
        littles.setMinimumHeight(deviceHeight);
        setContentView(littles);


        for(int i = 0;i < 3;i++){
            LinearLayout btns = new LinearLayout(this);
            btns.setOrientation(LinearLayout.HORIZONTAL);
            littles.addView(btns);

            for(int j = 0;j < 3;j++){
                final Button btn = new Button(this);
                idCount++;
                btn.setMinimumHeight(deviceHeight*2/7);
                btn.setMinimumWidth(deviceWidth*2/6);
                btn.setId(idCount);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       if(cont){

                           btn.setText("X");
                           clickS = clickS + btn.getId() + "x" + ",";
                           cont = false;
                           btn.setEnabled(false);

                       }else{
                           btn.setText("O");
                           btn.setEnabled(false);
                           clickS = clickS + btn.getId() + "o" + ",";
                           cont = true;

                       }

                       winOrnot();

                    }
                });

                btns.addView(btn);
            }
            }



            }
    public void winOrnot(){
        if(
                clickS.indexOf("1x") > -1 && clickS.indexOf("2x") > -1 && clickS.indexOf("3x") > -1 ||
                        clickS.indexOf("1x") > -1 && clickS.indexOf("2x") > -1 && clickS.indexOf("3x") > -1 ||
                        clickS.indexOf("4x") > -1 && clickS.indexOf("5x") > -1 && clickS.indexOf("6x") > -1 ||
                        clickS.indexOf("7x") > -1 && clickS.indexOf("8x") > -1 && clickS.indexOf("9x") > -1 ||
                        clickS.indexOf("1x") > -1 && clickS.indexOf("4x") > -1 && clickS.indexOf("7x") > -1 ||
                        clickS.indexOf("2x") > -1 && clickS.indexOf("5x") > -1 && clickS.indexOf("8x") > -1 ||
                        clickS.indexOf("3x") > -1 && clickS.indexOf("6x") > -1 && clickS.indexOf("9x") > -1 ||
                        clickS.indexOf("1x") > -1 && clickS.indexOf("5x") > -1 && clickS.indexOf("9x") > -1 ||
                        clickS.indexOf("3x") > -1 && clickS.indexOf("5x") > -1 && clickS.indexOf("7x") > -1
                ){
            Toast.makeText(MainActivity.this,"X is win",Toast.LENGTH_SHORT).show();
        }else if(
                clickS.indexOf("1o") > -1 && clickS.indexOf("2o") > -1 && clickS.indexOf("3o") > -1 ||
                        clickS.indexOf("1o") > -1 && clickS.indexOf("2o") > -1 && clickS.indexOf("3o") > -1 ||
                        clickS.indexOf("4o") > -1 && clickS.indexOf("5o") > -1 && clickS.indexOf("6o") > -1 ||
                        clickS.indexOf("7o") > -1 && clickS.indexOf("8o") > -1 && clickS.indexOf("9o") > -1 ||
                        clickS.indexOf("1o") > -1 && clickS.indexOf("4o") > -1 && clickS.indexOf("7o") > -1 ||
                        clickS.indexOf("2o") > -1 && clickS.indexOf("5o") > -1 && clickS.indexOf("8o") > -1 ||
                        clickS.indexOf("3o") > -1 && clickS.indexOf("6o") > -1 && clickS.indexOf("9o") > -1 ||
                        clickS.indexOf("1o") > -1 && clickS.indexOf("5o") > -1 && clickS.indexOf("9o") > -1 ||
                        clickS.indexOf("3o") > -1 && clickS.indexOf("5o") > -1 && clickS.indexOf("7o") > -1
                ){
            Toast.makeText(MainActivity.this,"O is win",Toast.LENGTH_SHORT).show();
        }
    }

}
