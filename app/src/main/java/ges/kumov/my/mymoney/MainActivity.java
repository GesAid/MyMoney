package ges.kumov.my.mymoney;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MainActivity extends Tools {
    EditText sum;
    EditText comment;

    TextView totalTV;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        shared = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = shared.edit();
        sum = (EditText) findViewById(R.id.et_input_sum);
        comment = (EditText) findViewById(R.id.et_input_comment);
        totalTV = (TextView) findViewById(R.id.tv_total_num);
        List<String> allkeys = new ArrayList<String>(shared.getAll().keySet());
        Collections.sort(allkeys);
        img =(ImageView) findViewById(R.id.imag_input);
        int i = 0;
        float sum = 0;
        long date = 0;
        String tag = "";
        String comment = "";
        for (String key : allkeys) {
            switch (i) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    sum = shared.getFloat(key, 0);
                    break;
                case 3:
                    tag = shared.getString(key, "");
                    total += findTag(tag, sum);
                    break;
            }
            i++;
            if (i > 3) i = 0;
        }

        totalcount(img);
        totalTV.setText("" + total);
    }


    public void viewInfo(View view) {
        Intent go = new Intent(MainActivity.this, ViewInfo.class);
        startActivity(go);
    }



    public void addSum(View view) {

        String tag = view.getTag().toString();
        if (sum.getText().toString().equals(""))
            sum.setText("0");
        total += findTag(tag, Float.parseFloat(sum.getText().toString()));

        long date = new Date().getTime();
        editor.putLong(date + "_date", date);
        editor.putFloat(date + "_sum", Float.parseFloat(sum.getText().toString()));
        editor.putString(date + "_tag", tag);
        editor.putString(date + "_comment", comment.getText().toString());
        editor.apply();
        comment.setText("");
        sum.setText("");
        totalcount(img);
        totalTV.setText("" + total);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
