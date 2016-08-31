package ges.kumov.my.mymoney;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
/**
 * Created by a.kumov on 8/13/15.
 */
public class Tools extends Activity {
    int t=0;
    int total;
    protected static final String APP_PREFERENCES = "mysettings";
    SharedPreferences shared;
    SharedPreferences.Editor editor;
    public void toGo(float sum, long date1, String tag, String comment) {
        SimpleDateFormat ref = new SimpleDateFormat("dd,MM,yy");
        String date = ref.format(date1);

        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(50, ViewGroup.LayoutParams.WRAP_CONTENT, 1);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        if (t%2==0){
            ll.setBackgroundColor(getResources().getColor(R.color.hren));
        }
        else
            ll.setBackgroundColor(getResources().getColor(R.color.white));
        t++;
        TextView otbivka = new TextView(this);
        otbivka.setText("  ");
        ll.addView(otbivka);

        TextView sumTV = new TextView(this);
        sumTV.setText(String.valueOf(sum));
        if (findTag(tag)==1) {
            sumTV.setTextColor(getResources().getColor(R.color.green));
            sumTV.setGravity(View.FOCUS_LEFT);
        }
        else {
            sumTV.setTextColor(getResources().getColor(R.color.red));
            sumTV.setGravity(View.FOCUS_RIGHT);
        }
        sumTV.setLayoutParams(llp);
        sumTV.setWidth(2);
        sumTV.setTextSize(15);
        ll.addView(sumTV);

        TextView dateTV = new TextView(this);
        dateTV.setText(String.valueOf(date));
        dateTV.setLayoutParams(llp);
        dateTV.setWidth(2);
        dateTV.setTextSize(15);
        ll.addView(dateTV);

        TextView tagTV = new TextView(this);
        tagTV.setText(String.valueOf(tag));
        tagTV.setLayoutParams(llp);
        tagTV.setWidth(2);
        tagTV.setTextSize(15);
        ll.addView(tagTV);

        TextView commentTV = new TextView(this);
        commentTV.setText(String.valueOf(comment));
        commentTV.setLayoutParams(llp);
        commentTV.setWidth(3);
        commentTV.setTextSize(15);
        ll.addView(commentTV);

        LinearLayout shg = (LinearLayout) findViewById(R.id.ll_input_info);
        shg.addView(ll);
    }
    public int findTag(String tag) {
        if (tag.equals(getResources().getString(R.string.zarplata)))
            return 1;
        else if (tag.equals(getResources().getString(R.string.avans)))
            return 1;
        else if (tag.equals(getResources().getString(R.string.podarok)))
            return 1;
        else if (tag.equals(getResources().getString(R.string.zaim)))
            return 1;
        else if (tag.equals(getResources().getString(R.string.prochee)))
            return 1;
        else if (tag.equals(getResources().getString(R.string.produkt)))
            return -1;
        else if (tag.equals(getResources().getString(R.string.veshi)))
            return -1;
        else if (tag.equals(getResources().getString(R.string.kredit)))
            return -1;
        else if (tag.equals(getResources().getString(R.string.ipoteka)))
            return -1;
        else if (tag.equals(getResources().getString(R.string.internet)))
            return -1;
        else if (tag.equals(getResources().getString(R.string.gkh)))
            return -1;
        else if (tag.equals(getResources().getString(R.string.dolg)))
            return -1;
        else if (tag.equals(getResources().getString(R.string.transport)))
            return -1;
        else if (tag.equals(getResources().getString(R.string.lekarstva)))
            return -1;
        else if (tag.equals(getResources().getString(R.string.prochee_mn)))
            return -1;
        return 1;
    }

    public float findTag(String tag,float sum) {
        if (tag.equals(getResources().getString(R.string.zarplata)))
            return sum;
        else if (tag.equals(getResources().getString(R.string.avans)))
            return sum;
        else if (tag.equals(getResources().getString(R.string.podarok)))
            return sum;
        else if (tag.equals(getResources().getString(R.string.zaim)))
            return sum;
        else if (tag.equals(getResources().getString(R.string.prochee)))
            return sum;
        else if (tag.equals(getResources().getString(R.string.produkt)))
            return -sum;
        else if (tag.equals(getResources().getString(R.string.veshi)))
            return -sum;
        else if (tag.equals(getResources().getString(R.string.kredit)))
            return -sum;
        else if (tag.equals(getResources().getString(R.string.ipoteka)))
            return -sum;
        else if (tag.equals(getResources().getString(R.string.internet)))
            return -sum;
        else if (tag.equals(getResources().getString(R.string.gkh)))
            return -sum;
        else if (tag.equals(getResources().getString(R.string.dolg)))
            return -sum;
        else if (tag.equals(getResources().getString(R.string.transport)))
            return -sum;
        else if (tag.equals(getResources().getString(R.string.lekarstva)))
            return -sum;
        else if (tag.equals(getResources().getString(R.string.prochee_mn)))
            return -sum;

        return 0;
    }
    public void closeProgram(View v) {
        finish();
    }

    public void totalcount(ImageView img){

        if (total<100 && total>=1 )
            img.setImageResource(R.drawable.nomaney);
        else if (total>100 && total<500)
            img.setImageResource(R.drawable.litle);
        else if (total>500 && total<2000)
            img.setImageResource(R.drawable.more);
        else if (total>2000 )
            img.setImageResource(R.drawable.tomach);
        else if (total<0 )
            img.setImageResource(R.drawable.figa);

    }
}
