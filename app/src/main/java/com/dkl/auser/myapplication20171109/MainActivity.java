package com.dkl.auser.myapplication20171109;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
String names[] = {"bob","boa","bon","baz"};
MyAdapater adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.listView);
 adapter = new MyAdapater(MainActivity.this,names);
        lv.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("show");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        StringBuilder sb = new StringBuilder();
    int i;
        for(i=0;i<names.length;i++){
    if(adapter.b[i])
    {
        sb.append(names[i]+",");

    }
        }
        Toast.makeText(MainActivity.this,sb.toString(),Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);

    }

}
