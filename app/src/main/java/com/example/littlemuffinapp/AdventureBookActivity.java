package com.example.littlemuffinapp;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AdventureBookActivity extends AppCompatActivity {

    public int counterVar = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_book);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        int[] counter = new int[1];

        ImageButton bookArrow = (ImageButton) findViewById(R.id.mcBookArrow);
        ImageButton backArrow = (ImageButton) findViewById(R.id.mcBackArrow);

        TextView bookSize = (TextView) findViewById(R.id.bookSize);
        TextView bookCurrentPage = (TextView) findViewById(R.id.bookCurrentPage);
        TextView bookCurrentContent = (TextView) findViewById(R.id.bookCurrentContent);


        int arrayCapacity = 8;
        String arrayCapacityStr = "8";

        String[] bookText = new String[arrayCapacity];

        String phraseComparison = "Page 1";

        String lastPhraseComparison = "Page 2";
        bookText[0] = "Page 1";
        bookText[1] = "Page 2";
        bookText[2] = "Page 3";
        bookText[3] = "Page 4";
        bookText[4] = "Page 5";
        bookText[5] = "Page 6";
        bookText[6] = "Page 7";
        bookText[7] = "Page 8";


        bookSize.setText(arrayCapacityStr);
        bookCurrentContent.setText(bookText[0]);
        String pgNumCont = String.valueOf(counterVar);
        bookCurrentPage.setText(pgNumCont);
        backArrow.setVisibility(View.INVISIBLE);
        bookArrow.setVisibility(View.VISIBLE);

            bookArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counterVar++;
                    String currentString = bookText[counterVar-1];

                    if (lastPhraseComparison.equals(currentString)){
                        bookArrow.setVisibility(View.INVISIBLE);

                    } else {
                        bookArrow.setVisibility(View.VISIBLE);
                    }
                    if (counterVar <= arrayCapacity){
                        bookCurrentContent.setText(bookText[counterVar-1]);
                        String str = String.valueOf(counterVar);
                        bookCurrentPage.setText(str);
                        backArrow.setVisibility(View.VISIBLE);


                    }
                }

            });

            backArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counterVar--;
                    String currentString = bookText[counterVar-1];

                    if (phraseComparison.equals(currentString)){
                        backArrow.setVisibility(View.INVISIBLE);

                    } else {
                        backArrow.setVisibility(View.VISIBLE);
                    }


                    if (counterVar >= 1){
                    bookCurrentContent.setText(bookText[counterVar-1]);
                    String str = String.valueOf(counterVar);
                    bookCurrentPage.setText(str);
                    bookArrow.setVisibility(View.VISIBLE);

                    }



                }
            });


    }

}
