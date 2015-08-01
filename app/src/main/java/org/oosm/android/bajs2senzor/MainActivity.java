package org.oosm.android.bajs2senzor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    public TextView t1, t2;
    RelativeLayout.LayoutParams rlp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Creating a new RelativeLayout
        RelativeLayout mainLayout = createMainLayout();
        t1 = this.createTextView(RelativeLayout.ALIGN_PARENT_LEFT);
        t2 = this.createTextView(RelativeLayout.ALIGN_PARENT_RIGHT);
        // Adding the TextView to the RelativeLayout as a child
        mainLayout.addView(t1);
        mainLayout.addView(t2);

        // Setting the RelativeLayout as our content view
        setContentView(mainLayout, rlp);
    }
    @Override
    public void onPause() {
        super.onPause();
    }
    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method firs
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private RelativeLayout createMainLayout()
    {
        RelativeLayout relativeLayout = new RelativeLayout(this);

        // Defining the RelativeLayout layout parameters.
        // In this case I want to fill its parent
        rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT);

        return relativeLayout;
    }

    private TextView createTextView(int alignment)
    {
        // Creating a new TextView
        TextView t = new TextView(this);
        t.setText("Test");

        // Defining the layout parameters of the TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(alignment);

        // Setting the parameters on the TextView
        t.setLayoutParams(lp);
        return t;
    }
}