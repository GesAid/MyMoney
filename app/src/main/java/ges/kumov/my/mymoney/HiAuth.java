package ges.kumov.my.mymoney;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by a.kumov on 8/14/15.
 */
public class HiAuth extends Tools{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiauth);
        shared = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        ImageView img= (ImageView) findViewById(R.id.main_tmg);
        List<String> allkeys = new ArrayList<String>(shared.getAll().keySet());
        Collections.sort(allkeys);
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
    }
    public void toGo(View view) {
        Intent mag = new Intent(HiAuth.this, MainActivity.class);
        startActivity(mag);



    }
}
