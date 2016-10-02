package edu.orangecoastcollege.cs273.tmorrissey1.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Controller for OC Music Events.
 * @author Travis Morrissey
 */
public class EventListActivity extends ListActivity {

    /**
     * Perform initialization of all fragments and loaders.
     * @param savedInstanceState last saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the adapter which binds the listView with the data in MusicView.java
        // Since the data is in an array , we use an ArrayAdapter

        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));

        //setContentView(R.layout.activity_event_list);
    }

    /**
     * When item in ListView is clicked, gets title and details from MusicEvent class
     * and passes the data via an Intent to EventDetailsActivity class
     * @param l the ListView that registered the click event
     * @param v the View that was clicked within ListView
     * @param position the position of the View in the list
     * @param id the row id of the item that was clicked
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        String title = MusicEvent.titles[position];
        String details = MusicEvent.details[position];
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("Title", title);
        detailsIntent.putExtra("Details", details);

        startActivity(detailsIntent);

    }
}
