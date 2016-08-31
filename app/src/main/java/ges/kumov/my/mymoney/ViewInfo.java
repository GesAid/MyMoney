package ges.kumov.my.mymoney;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by a.kumov on 8/12/15.
 */
public class ViewInfo extends Tools {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        shared = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        TextView totalview = (TextView) findViewById(R.id.textView2);

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
                    comment = shared.getString(key, "");
                    break;
                case 1:
                    date = shared.getLong(key, 0);
                    break;
                case 2:
                    sum = shared.getFloat(key, 0);
                    break;
                case 3:
                    tag = shared.getString(key, "");
                    total+=findTag(tag,sum);
                    break;
            }
            if (i == 3) toGo(sum, date, tag, comment);
            i++;
            if (i > 3) i = 0;
        }
        ImageView img = (ImageView) findViewById(R.id.img_stat);
        totalcount(img);
            totalview.setText(""+total);
    }


}
