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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomForBot;
    boolean isWin;
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
    Button[] emptyButtons;
    int btnCount;
    boolean StartBotStep;
    String[] playerSteps;
    int playerStepsCount;
    int playerStepsCountForBot;
    int emptyButtonsCount;
    int buttonIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonIndex = -1;
        emptyButtonsCount = 0;
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
        playerStepsCountForBot = 0;







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
                        btn.setTag("nonEmpty");
                        //btn.setBackgroundResource(R.mipmap.minigal);
                        clickForWin = clickForWin + btn.getId() + "x" + ",";
                        clickForBot = clickForBot + playerSteps[playerStepsCount] + btn.getId() + "x";
                        cont = false;
                        btn.setEnabled(false);
                        winOrnot();
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
            isWin = true;

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
            isWin = true;

        }



    }

    public void botStep(){
        if(
                clickForBot.indexOf("5o") > -1 && clickForBot.indexOf("2o") > -1 && clickForBot.indexOf("s18x") == -1 && clickForBot.indexOf("s28x") == -1&&clickForBot.indexOf("s38x") == -1
                ){
            buttonS[8].setText("O");
            buttonS[8].setEnabled(false);
            buttonS[8].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[8].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[8].getId() + "o";
            return;
        }else if(
                clickForBot.indexOf("5o") > -1 && clickForBot.indexOf("4o") > -1 && clickForBot.indexOf("s16x") == -1 && clickForBot.indexOf("s26x") == -1&&clickForBot.indexOf("s36x") == -1
                ){
            buttonS[6].setText("O");
            buttonS[6].setEnabled(false);
            buttonS[6].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[6].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[6].getId() + "o";
            return;
        }else if(
                clickForBot.indexOf("5o") > -1 && clickForBot.indexOf("1o") > -1 && clickForBot.indexOf("s19x") == -1 && clickForBot.indexOf("s29x") == -1&&clickForBot.indexOf("s39x") == -1
                ){
            buttonS[9].setText("O");
            buttonS[9].setEnabled(false);
            buttonS[9].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[9].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[9].getId() + "o";
            return;
        }else if(
                clickForBot.indexOf("5o") > -1 && clickForBot.indexOf("9o") > -1 && clickForBot.indexOf("s11x") == -1 && clickForBot.indexOf("s21x") == -1&&clickForBot.indexOf("s31x") == -1
                ){
            buttonS[1].setText("O");
            buttonS[1].setEnabled(false);
            buttonS[1].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[1].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[1].getId() + "o";
            return;
        }else if(
                clickForBot.indexOf("5o") > -1 && clickForBot.indexOf("6o") > -1 && clickForBot.indexOf("s14x") == -1 && clickForBot.indexOf("s24x") == -1&&clickForBot.indexOf("s34x") == -1
                ){
            buttonS[4].setText("O");
            buttonS[4].setEnabled(false);
            buttonS[4].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[4].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[4].getId() + "o";
            return;
        }else if(
                clickForBot.indexOf("5o") > -1 && clickForBot.indexOf("8o") > -1 && clickForBot.indexOf("s12x") == -1 && clickForBot.indexOf("s22x") == -1&&clickForBot.indexOf("s32x") == -1
                ){
            buttonS[2].setText("O");
            buttonS[2].setEnabled(false);
            clickForWin = clickForWin + buttonS[2].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[2].getId() + "o";
            return;
        }else if(
                clickForBot.indexOf("5o") > -1 && clickForBot.indexOf("3o") > -1 && clickForBot.indexOf("s17x") == -1 && clickForBot.indexOf("s27x") == -1 && clickForBot.indexOf("s37x") == -1)
        {
            buttonS[7].setText("O");
            buttonS[7].setEnabled(false);
            buttonS[7].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[7].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[7].getId() + "o";
            return;
        }else if(
                clickForBot.indexOf("5o") > -1 && clickForBot.indexOf("7o") > -1 && clickForBot.indexOf("s13x") == -1 && clickForBot.indexOf("s23x") == -1&&clickForBot.indexOf("s33x") == -1
                ){
            buttonS[3].setText("O");
            buttonS[3].setEnabled(false);
            buttonS[3].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[3].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[3].getId() + "o";
            return;
        }if(isWin != true && playerStepsCountForBot > 1 && playerStepsCountForBot < 5) {
//            for (int i = 1; i < buttonS.length; i++) {
//                if (buttonS[i].getTag() != "nonEmpty") {
//                    buttonS[i].setText("O");
//                    buttonS[i].setEnabled(false);
//                    buttonS[i].setTag("nonEmpty");
//                    clickForWin = clickForWin + buttonS[i].getId() + "o" + ",";
//                    playerStepsCountForBot++;
//                    clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[i].getId() + "o";
//                    break;
//
//                }
//            }
            for (int i = 1; i < buttonS.length; i++) {
                if (buttonS[i].getTag() != "nonEmpty") {
                    emptyButtonsCount++;
                }
            }
            Log.e("hey","empty buttons count" + emptyButtonsCount);
            emptyButtons = new Button[emptyButtonsCount];
            for (int i = 1; i < buttonS.length; i++) {
                if (buttonS[i].getTag() != "nonEmpty") {
                    buttonIndex++;
                    emptyButtons[buttonIndex] = buttonS[i];
                }
            }Log.e("hey1","empty buttons" + emptyButtons.length + "dddd" + buttonIndex);
            randomForBot = (int)(Math.random()*emptyButtonsCount);
            emptyButtons[randomForBot].setText("O");
            emptyButtons[randomForBot].setTag("nonEmpty");
            emptyButtons[randomForBot].setEnabled(false);
            clickForWin = clickForWin + emptyButtons[randomForBot].getId() + "o" + ",";
            clickForBot = clickForBot + playerSteps[playerStepsCount] + emptyButtons[randomForBot].getId() + "o";
            playerStepsCountForBot++;
            emptyButtonsCount = 0;
            buttonIndex = -1;

        }else
        if( clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s23x") > -1||
                clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s27x") > -1||
                clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s22x") > -1||
                clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s29x") > -1||
                clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s27x") > -1
                ){
            buttonS[8].setText("O");
            buttonS[8].setEnabled(false);
            buttonS[8].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[8].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[8].getId() + "o";

            return;
        }else
        if(clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s24x") > -1||
                clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s29x") > -1||
                clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s23x") > -1
                ){
            buttonS[6].setText("O");
            buttonS[6].setEnabled(false);
            buttonS[6].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[6].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[6].getId() + "o";
            return;
        }else
        if(clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s21x") > -1||
                clickForBot.indexOf("s16x") > -1 && clickForBot.indexOf("s23x") > -1||
                clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s22x") > -1||
                clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s26x") > -1||
                clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s28x") > -1||
                clickForBot.indexOf("s18x") > -1 && clickForBot.indexOf("s27x") > -1||
                clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s26x") > -1||
                clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s29x") > -1||
                clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s28x") > -1
                ){
            buttonS[9].setText("O");
            buttonS[9].setEnabled(false);
            buttonS[9].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[9].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[9].getId() + "o";
            return;
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
                        clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s22x") > -1
                ){
            buttonS[1].setText("O");
            buttonS[1].setEnabled(false);
            buttonS[1].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[1].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[1].getId() + "o";
            return;

        }
        else if(
                clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s26x") > -1||
                        clickForBot.indexOf("s17x") > -1 && clickForBot.indexOf("s21x") > -1||
                        clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s27x") > -1||
                        clickForBot.indexOf("s12x") > -1 && clickForBot.indexOf("s27x") > -1

                ){
            buttonS[4].setText("O");
            buttonS[4].setEnabled(false);
            buttonS[4].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[4].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[4].getId() + "o";
            return;
        }else if(clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s21x") > -1||
                clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s29x") > -1||
                clickForBot.indexOf("s15x") > -1 && clickForBot.indexOf("s28x") > -1||
                clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s23x") > -1
                ){
            buttonS[2].setText("O");
            buttonS[2].setEnabled(false);
            buttonS[2].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[2].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[2].getId() + "o";
            return;
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
                        clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s24x") > -1)
        {
            buttonS[7].setText("O");
            buttonS[7].setEnabled(false);
            buttonS[7].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[7].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[7].getId() + "o";
            return;
        }else if(
                clickForBot.indexOf("s16x") > -1&& clickForBot.indexOf("s29x") > -1||
                        clickForBot.indexOf("s18x") > -1 && clickForBot.indexOf("s21x") > -1||
                        clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s22x") > -1||
                        clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s24x") > -1||
                        clickForBot.indexOf("s19x") > -1 && clickForBot.indexOf("s26x") > -1||
                        clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s26x") > -1||
                        clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s22x") > -1||
                        clickForBot.indexOf("s12x") > -1 && clickForBot.indexOf("s26x") > -1||
                        clickForBot.indexOf("s16x") > -1 && clickForBot.indexOf("s22x") > -1
                ){
            buttonS[3].setText("O");
            buttonS[3].setEnabled(false);
            buttonS[3].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[3].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[3].getId() + "o";
            return;
        }else if(clickForBot.indexOf("s11x") > -1 && clickForBot.indexOf("s23x") > -1 || clickForBot.indexOf("s13x") > -1 && clickForBot.indexOf("s21x") > -1){
            buttonS[2].setText("O");
            buttonS[2].setEnabled(false);
            buttonS[2].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[2].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[2].getId() + "o";
            return;
        }else if(clickForBot.indexOf("s15x") > -1 || clickForBot.indexOf("s12x") > -1 && clickForBot.indexOf("s21x") > -1 || clickForBot.indexOf("s12x") > -1 && clickForBot.indexOf("s29x") > -1|| clickForBot.indexOf("s12x") > -1 && clickForBot.indexOf("s21x") > -1){
            buttonS[3].setText("O");
            buttonS[3].setEnabled(false);
            buttonS[3].setTag("nonEmpty");
            clickForWin = clickForWin + buttonS[3].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[3].getId() + "o";
            return;
        }else if(clickForBot.indexOf("s11x") > -1 || clickForBot.indexOf("s13x") > -1 || clickForBot.indexOf("s17x") > -1 || clickForBot.indexOf("s19x") > -1||
                clickForBot.indexOf("s12x") > -1 || clickForBot.indexOf("s16x") > -1 || clickForBot.indexOf("s14x") > -1 || clickForBot.indexOf("s18x") > -1){
            buttonS[5].setText("O");
            buttonS[5].setEnabled(false);
            clickForWin = clickForWin + buttonS[5].getId() + "o" + ",";
            playerStepsCountForBot++;
            clickForBot = clickForBot + playerSteps[playerStepsCount] + buttonS[5].getId() + "o";
            buttonS[5].setTag("nonEmpty");
            return;
        }









    }

}


