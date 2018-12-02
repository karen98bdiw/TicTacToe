package com.example.karen.tictactoe;

import android.media.MediaPlayer;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.karen.tictactoe.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    boolean cont;
    int idCount;
    String clickForWin;
    String clickForBot;
    int[] kImgs;
    int[] sImgs;
    int shaker;
    Random random;
    int shakerInt;
    int sClick,kClick;
    Button[] buttonS;
    int btnCount;
    boolean StartBotStep;
    String[] playerSteps;
    int playerStepsCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        random = new Random();
        cont = true;
        idCount = 0;
        clickForWin = "";
        clickForBot = "";
        sClick = 0;
        kClick = 0;
        buttonS = new Button[10];
        btnCount = 1;
        playerSteps = new String[]{"s1","s2","s3","s4","s5"};
        playerStepsCount = -1;


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
//                        if(cont){
//                            btn.setText("X");
//                            //btn.setBackgroundResource(R.mipmap.minigal);
//                            clickS = clickS + btn.getId() + "x" + ",";
//                            cont = false;
//                            btn.setEnabled(false);
////                            if(v1.isPlaying() == true)
////
////                                v1.pause();
////
////                            else
////
////                                v1.start();
//
//                        }else{
//                            btn.setText("O");
//                            //btn.setBackgroundResource(R.mipmap.minish);
//                            btn.setEnabled(false);
//                            clickS = clickS + btn.getId() + "o" + ",";
//                            cont = true;
////                            if(v2.isPlaying() == true)
////
////                                v2.pause();
////
////                            else
////
////                                v2.start();
//
//                        }
                        btn.setText("X");
                        playerStepsCount++;
                        //btn.setBackgroundResource(R.mipmap.minigal);
                        clickForWin = clickForWin + btn.getId() + "x" + ",";
                        clickForBot = clickForBot + playerSteps[playerStepsCount] + btn.getId() + "x";
                        cont = false;
                        btn.setEnabled(false);
                        botStep();

                        winOrnot();

                    }
                });
                buttonS[btnCount] = btn;
                btnCount++;
                btns.addView(btn);

            }
        }



    }


    public void winOrnot(){
        if(
                clickForWin.indexOf("1x") > -1 && clickForWin.indexOf("2x") > -1 && clickForWin.indexOf("3x") > -1 ||
                        clickForWin.indexOf("1x") > -1 && clickForWin.indexOf("2x") > -1 && clickForWin.indexOf("3x") > -1 ||
                        clickForWin.indexOf("4x") > -1 && clickForWin.indexOf("5x") > -1 && clickForWin.indexOf("6x") > -1 ||
                        clickForWin.indexOf("7x") > -1 && clickForWin.indexOf("8x") > -1 && clickForWin.indexOf("9x") > -1 ||
                        clickForWin.indexOf("1x") > -1 && clickForWin.indexOf("4x") > -1 && clickForWin.indexOf("7x") > -1 ||
                        clickForWin.indexOf("2x") > -1 && clickForWin.indexOf("5x") > -1 && clickForWin.indexOf("8x") > -1 ||
                        clickForWin.indexOf("3x") > -1 && clickForWin.indexOf("6x") > -1 && clickForWin.indexOf("9x") > -1 ||
                        clickForWin.indexOf("1x") > -1 && clickForWin.indexOf("5x") > -1 && clickForWin.indexOf("9x") > -1 ||
                        clickForWin.indexOf("3x") > -1 && clickForWin.indexOf("5x") > -1 && clickForWin.indexOf("7x") > -1
                ){
            Toast.makeText(MainActivity.this,"first is win",Toast.LENGTH_SHORT).show();
        }else if(
                clickForWin.indexOf("1o") > -1 && clickForWin.indexOf("2o") > -1 && clickForWin.indexOf("3o") > -1 ||
                        clickForWin.indexOf("1o") > -1 && clickForWin.indexOf("2o") > -1 && clickForWin.indexOf("3o") > -1 ||
                        clickForWin.indexOf("4o") > -1 && clickForWin.indexOf("5o") > -1 && clickForWin.indexOf("6o") > -1 ||
                        clickForWin.indexOf("7o") > -1 && clickForWin.indexOf("8o") > -1 && clickForWin.indexOf("9o") > -1 ||
                        clickForWin.indexOf("1o") > -1 && clickForWin.indexOf("4o") > -1 && clickForWin.indexOf("7o") > -1 ||
                        clickForWin.indexOf("2o") > -1 && clickForWin.indexOf("5o") > -1 && clickForWin.indexOf("8o") > -1 ||
                        clickForWin.indexOf("3o") > -1 && clickForWin.indexOf("6o") > -1 && clickForWin.indexOf("9o") > -1 ||
                        clickForWin.indexOf("1o") > -1 && clickForWin.indexOf("5o") > -1 && clickForWin.indexOf("9o") > -1 ||
                        clickForWin.indexOf("3o") > -1 && clickForWin.indexOf("5o") > -1 && clickForWin.indexOf("7o") > -1
                ){
            Toast.makeText(MainActivity.this,"second is win",Toast.LENGTH_SHORT).show();
        }



    }

    public void botStep(){

        if(clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s22x") > -1||
                clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s29x") > -1||
                clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s27x") > -1
                ){
            buttonS[8].setText("O");
            buttonS[8].setEnabled(false);
            clickForWin = clickForWin + buttonS[8].getId() + "o" + ",";
        }else
        if(clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s24x") > -1||
                clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s29x") > -1||
                clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s23x") > -1){
            buttonS[6].setText("O");
            buttonS[6].setEnabled(false);
            clickForWin = clickForWin + buttonS[6].getId() + "o" + ",";
        }else
        if(clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s21x") > -1||
                clickForBot.indexOf("s16x") > -1 && clickForBot.indexOf("s23x") > -1||
                clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s22x") > -1||
                clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s23x") > -1||
                clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s26x") > -1||
                clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s28x") > -1||
                clickForBot.indexOf("s18x") > -1 && clickForBot.indexOf("s27x") > -1||
                clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s26x") > -1||
                clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s29x") > -1||
                clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s28x") > -1||
                clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s27x") > -1){
            buttonS[9].setText("O");
            buttonS[9].setEnabled(false);
            clickForWin = clickForWin + buttonS[9].getId() + "o" + ",";
        }else if(
                clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s27x") > -1||
                        clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s29x") > -1||
                        clickForBot.indexOf("s16x") > -1 && clickForBot.indexOf("s22x") > -1||
                        clickForBot.indexOf("s16x") > -1 && clickForBot.indexOf("s24x") > -1||
                        clickForBot.indexOf("s16x") > -1 && clickForBot.indexOf("s27x") > -1||
                        clickForBot.indexOf("s16x") > -1 && clickForBot.indexOf("s28x") > -1||
                        clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s24x") > -1||
                        clickForBot.indexOf("s14x") > -1 && clickForBot.indexOf("s27x") > -1||
                        clickForBot.indexOf("s18x") > -1 && clickForBot.indexOf("s22x") > -1||
                        clickForBot.indexOf("s18x") > -1 && clickForBot.indexOf("s23x") > -1||
                        clickForBot.indexOf("s18x") > -1 && clickForBot.indexOf("s24x") > -1||
                        clickForBot.indexOf("s18x") > -1 && clickForBot.indexOf("s26x") > -1||
                        clickForBot.indexOf("s12x") > -1 && clickForBot.indexOf("s23x") > -1||
                        clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s22x") > -1){
            buttonS[1].setText("O");
            buttonS[1].setEnabled(false);
            clickForWin = clickForWin + buttonS[1].getId() + "o" + ",";
        }
        else if(
                clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s26x") > -1||
                        clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s21x") > -1||
                        clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s27x") > -1||
                        clickForBot.indexOf("s12x") > -1 && clickForBot.indexOf("s27x") > -1
                ){
            buttonS[4].setText("O");
            buttonS[4].setEnabled(false);
            clickForWin = clickForWin + buttonS[4].getId() + "o" + ",";
        }else if(clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s28x") > -1||
                clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s23x") > -1){
            buttonS[2].setText("O");
            buttonS[2].setEnabled(false);
            clickForWin = clickForWin + buttonS[2].getId() + "o" + ",";
        }else if(
                clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s23x") > -1||
                        clickForBot.indexOf("s16x") > -1 && clickForBot.indexOf("s21x") > -1||
                        clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s28x") > -1||
                        clickForBot.indexOf("s14x") > -1 && clickForBot.indexOf("s21x") > -1||
                        clickForBot.indexOf("s14x") > -1 && clickForBot.indexOf("s22x") > -1||
                        clickForBot.indexOf("s14x") > -1 && clickForBot.indexOf("s23x") > -1||
                        clickForBot.indexOf("s14x") > -1 && clickForBot.indexOf("s26x") > -1||
                        clickForBot.indexOf("s14x") > -1 && clickForBot.indexOf("s29x") > -1||
                        clickForBot.indexOf("s14x") > -1 && clickForBot.indexOf("s28x") > -1||
                        clickForBot.indexOf("s14x") > -1 && clickForBot.indexOf("s27x") > -1||
                        clickForBot.indexOf("s16x") > -1 && clickForBot.indexOf("s21x") > -1||
                        clickForBot.indexOf("s18x") > -1 && clickForBot.indexOf("s29x") > -1||
                        clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s28x") > -1||
                        clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s28x") > -1||
                        clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s24x") > -1||
                        clickForBot.indexOf("s12x") > -1 && clickForBot.indexOf("s24x") > -1||
                        clickForBot.indexOf("s12x") > -1 && clickForBot.indexOf("s28x") > -1||
                        clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s24x") > -1){
            buttonS[7].setText("O");
            buttonS[7].setEnabled(false);
            clickForWin = clickForWin + buttonS[7].getId() + "o" + ",";
        }else if(
                clickForBot.indexOf("s16x") > -1&& clickForBot.indexOf("s29x") > -1||
                        clickForBot.indexOf("s18x") > -1 && clickForBot.indexOf("s21x") > -1||
                        clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s21x") > -1||
                        clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s22x") > -1||
                        clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s24x") > -1||
                        clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s26x") > -1||
                        clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s29x") > -1||
                        clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s26x") > -1||
                        clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s22x") > -1){
            buttonS[3].setText("O");
            buttonS[3].setEnabled(false);
            clickForWin = clickForWin + buttonS[3].getId() + "o" + ",";
        }else if(clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s23x") > -1 || clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s21x") > -1){
            buttonS[2].setText("O");
            buttonS[2].setEnabled(false);
            clickForWin = clickForWin + buttonS[2].getId() + "o" + ",";
        }else if(clickForBot.indexOf("s15x") > -1 || clickForBot.indexOf("s12x") > -1 && clickForBot.indexOf("s21x") > -1 || clickForBot.indexOf("s12x") > -1 && clickForBot.indexOf("s29x") > -1|| clickForBot.indexOf("s12x") > -1 && clickForBot.indexOf("s21x") > -1){
            buttonS[3].setText("O");
            buttonS[3].setEnabled(false);
            clickForWin = clickForWin + buttonS[2].getId() + "o" + ",";
        }else if(clickForBot.indexOf("s11x") > -1 || clickForBot.indexOf("s13x") > -1 || clickForBot.indexOf("s17x") > -1 || clickForBot.indexOf("s19x") > -1||
                clickForBot.indexOf("s12x") > -1 || clickForBot.indexOf("s16x") > -1 || clickForBot.indexOf("s14x") > -1 || clickForBot.indexOf("s18x") > -1){
            buttonS[5].setText("O");
            buttonS[5].setEnabled(false);
            clickForWin = clickForWin + buttonS[5].getId() + "o" + ",";
        }


    }

}


