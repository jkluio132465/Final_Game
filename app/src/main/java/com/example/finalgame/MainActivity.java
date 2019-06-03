package com.example.finalgame;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    int [] num = {2,2,2,
            2,2,2,
            2,2,2};
    int steps =0;
    int gridnum = 3;
    GridView gridView ;
    GrridAdapter set;
    TextView steptxt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        steptxt = findViewById(R.id.steps);

        set = new GrridAdapter(num,this);

        gridView= findViewById(R.id.grid);
        gridView.setAdapter(set);
        gridView.setNumColumns(gridnum);
        gridView.setOnItemLongClickListener(this);
        gridView.setOnItemClickListener(this);


    }
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        steps+=1;
        num[position]=2;
        steptxt.setText(""+steps);
        set.notifyDataSetChanged();
        wincheck();
        return true;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        steps+=1;
        steptxt.setText(""+steps);
        switch (position){

            case 0:case 3: case 6:
                numch(position+1);
                numch(position+3);
                numch(position-3);
                break;
            case 1: case 4: case 7:
                numch(position-1);
                numch(position+1);
                numch(position+3);
                numch(position-3);
                break;

            case 2: case 5: case 8:
                numch(position-1);
                numch(position+3);
                numch(position-3);
                break;
        }

        wincheck();
    }

    private void wincheck() {
        int sum=0;
        int best=0;
        TextView besttxt=findViewById(R.id.best);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        for(int i=0;i<num.length;i++)
            sum+=num[i];

        if(sum==16*9){
            Toast.makeText(this,"win",Toast.LENGTH_SHORT).show();
            if (steps<best){
                best=steps;
                besttxt.setText(""+best);
            }else if(best==0){
                best=steps;
                besttxt.setText(""+best);
            }
            steps=0;
            steptxt.setText(""+steps);
            for(int i=0;i<num.length;i++)
                num[i]=0;
        }
    }

    private void numch(int position) {
        if (position >=0 && position<=8) {
            if (num[position]==16)
                num[position]=2;
            else
                num[position] *= 2;
        }
//        Toast.makeText(this,""+num[position],Toast.LENGTH_SHORT).show();
        set.notifyDataSetChanged();
    }
}
