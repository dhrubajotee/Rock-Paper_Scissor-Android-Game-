package com.example.dhrubajotee.rockpaperscissor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock,b_paper,b_scissors;
    ImageView iv_cpu,iv_player;

    String playerChoice,cpuChoice,result;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_player = (ImageView) findViewById(R.id.iv_player);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);

         r = new Random();

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    playerChoice = "rock";
                iv_player.setImageResource(R.drawable.rock);
                    calculate();
            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    playerChoice = "paper";
                iv_player.setImageResource(R.drawable.paper);
                    calculate();
            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   playerChoice = "scissors";
                iv_player.setImageResource(R.drawable.scissors);
                   calculate();
            }
        });


    }

    public void calculate(){

         int cpu = r.nextInt(3);
        if(cpu == 0) {
            cpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        }
        else if(cpu == 1) {
            cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }
        else if(cpu == 2) {
            cpuChoice = "scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }

        if(playerChoice.equals("rock") && cpuChoice.equals("paper") ){
                result = "You Lose!";
        }

       else if(playerChoice.equals("rock") && cpuChoice.equals("scissors") ){
            result = "You Win!";
        }

        else if(playerChoice.equals("paper") && cpuChoice.equals("rock") ){
            result = "You Win!";
        }

        else if(playerChoice.equals("paper") && cpuChoice.equals("scissors") ){
            result = "You Lose!";
        }
        else if(playerChoice.equals("scissors") && cpuChoice.equals("rock")){
            result = "You Lose!";
        }

        else if(playerChoice.equals("scissors") && cpuChoice.equals("paper")){
            result = "You Lose!";
        }
        else if(playerChoice.equals("rock") && cpuChoice.equals("rock") ){
            result = "Draw!";
        }
        else if(playerChoice.equals("paper") && cpuChoice.equals("paper") ){
            result = "Draw!";
        }
        else if(playerChoice.equals("scissors") && cpuChoice.equals("scissors") ){
            result = "Draw!";
        }


        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();

        }

}
