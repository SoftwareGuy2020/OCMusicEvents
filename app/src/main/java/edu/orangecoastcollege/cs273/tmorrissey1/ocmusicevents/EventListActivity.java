package edu.orangecoastcollege.cs273.tmorrissey1.ocmusicevents;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the adapter which binds the listView with the data in MusicView.java
        // Since the data is in an array , we use an ArrayAdapter

        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));

        //setContentView(R.layout.activity_event_list);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        String title = MusicEvent.titles[position];
        String details = MusicEvent.details[position];


    }
}
