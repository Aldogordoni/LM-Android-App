package com.example.littlemuffinapp;

import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifImageView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GifGeneratorActivity extends AppCompatActivity {

    public int prevVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_generator);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        GifImageView catGif = (GifImageView) findViewById(R.id.gifImageViewCat);

        Button button = (Button) findViewById(R.id.buttonGif);

        int[] linkArray = new int[50];

        linkArray[0] = R.drawable.g1;
        linkArray[1] = R.drawable.g2;
        linkArray[2] = R.drawable.g3;
        linkArray[3] = R.drawable.g4;
        linkArray[4] = R.drawable.g5;
        linkArray[5] = R.drawable.g6;
        linkArray[6] = R.drawable.g7;
        linkArray[7] = R.drawable.g8;
        linkArray[8] = R.drawable.g9;
        linkArray[9] = R.drawable.g10;
        linkArray[10] = R.drawable.g11;
        linkArray[11] = R.drawable.g12;
        linkArray[12] = R.drawable.g13;
        linkArray[13] = R.drawable.g14;
        linkArray[14] = R.drawable.g15;
        linkArray[15] = R.drawable.g16;
        linkArray[16] = R.drawable.g17;
        linkArray[17] = R.drawable.g18;
        linkArray[18] = R.drawable.g19;
        linkArray[19] = R.drawable.g20;
        linkArray[20] = R.drawable.g21;
        linkArray[21] = R.drawable.g22;
        linkArray[22] = R.drawable.g23;
        linkArray[23] = R.drawable.g24;
        linkArray[24] = R.drawable.g25;
        linkArray[25] = R.drawable.g26;
        linkArray[26] = R.drawable.g27;
        linkArray[27] = R.drawable.g28;
        linkArray[28] = R.drawable.g29;
        linkArray[29] = R.drawable.g30;
        linkArray[30] = R.drawable.g31;
        linkArray[31] = R.drawable.g32;
        linkArray[32] = R.drawable.g33;
        linkArray[33] = R.drawable.g34;
        linkArray[34] = R.drawable.g35;
        linkArray[35] = R.drawable.g36;
        linkArray[36] = R.drawable.g37;
        linkArray[37] = R.drawable.g38;
        linkArray[38] = R.drawable.g39;
        linkArray[39] = R.drawable.g40;
        linkArray[40] = R.drawable.g41;
        linkArray[41] = R.drawable.g42;
        linkArray[42] = R.drawable.g43;
        linkArray[43] = R.drawable.g44;
        linkArray[44] = R.drawable.g45;
        linkArray[45] = R.drawable.g46;
        linkArray[46] = R.drawable.g47;
        linkArray[47] = R.drawable.g48;
        linkArray[48] = R.drawable.g49;
        linkArray[49] = R.drawable.g50;

        int max = 50;
        int min = 1;

        int x = (int) (Math.random() * 10000000) % max + min;

        prevVal = x;

        catGif.setImageResource(linkArray[x-1]);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int max = 50;
                int min = 1;

                int x = (int) (Math.random() * 10000000) % max + min;

                while (x == prevVal){
                    x = (int) (Math.random() * 10000000) % max + min;
                }
                prevVal = x;
                catGif.setImageResource(linkArray[x - 1]);
            }
        });
    }
}