package me.pietrocapriata.pietrofatti;

import android.app.Activity;
import android.graphics.Color;
import android.location.GpsStatus;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;


public class IGrandiLuoghiComuni extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igrandi_luoghi_comuni);
        TextView testodamettere = (TextView) findViewById(R.id.testo1);
        String testoda="testo";
           testodamettere.setText(testoda);

        Button bottone1 = (Button) findViewById(R.id.bottoneprincipale);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout sfondo = (RelativeLayout) findViewById(R.id.layout2);
                sfondo.setBackgroundColor(Color.RED);
            }
        };

        bottone1.setOnClickListener(listener);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.igrandi_luoghi_comuni, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
