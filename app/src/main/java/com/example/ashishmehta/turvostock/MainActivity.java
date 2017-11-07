package com.example.ashishmehta.turvostock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        dataModels = new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();

        dataModels.clear();
        dataModels.add(new DataModel("Apple", "APL", (int) Math.floor(Math.random() * 101)));
        dataModels.add(new DataModel("Reliance", "RIL", (int) Math.floor(Math.random() * 101)));
        dataModels.add(new DataModel("Axis Bank", "AXS", (int) Math.floor(Math.random() * 101)));
        dataModels.add(new DataModel("Bharti Airtel", "AIR", (int) Math.floor(Math.random() * 101)));
        dataModels.add(new DataModel("Maruti Suzuki", "MSZ", (int) Math.floor(Math.random() * 101)));

        adapter = new CustomAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel = dataModels.get(position);
                Bundle sendBundle = new Bundle();

                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_WEEK);

                sendBundle.putLong("DAY", day - 1);
                sendBundle.putLong("VALUE", dataModel.getValue());

                Intent i = new Intent(MainActivity.this, BarActivity.class);
                i.putExtras(sendBundle);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.notifyDataSetInvalidated();
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
}