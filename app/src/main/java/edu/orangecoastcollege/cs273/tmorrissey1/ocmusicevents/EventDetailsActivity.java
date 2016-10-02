package edu.orangecoastcollege.cs273.tmorrissey1.ocmusicevents;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


/**
 * Controller between EventListActivity and activity_event_details.
 * Gets intent from EventListActivity and passes data to activity_event_details
 * @author Travis Morrissey
 */
public class EventDetailsActivity extends AppCompatActivity {

    private Context context = (Context) this;

    /**
     * Perform initialization of all fragments and loaders.
     * @param savedInstanceState last saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        TextView eventTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView eventDetailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);
        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);

        Intent detailsIntent = getIntent();
        String title = detailsIntent.getStringExtra("Title");
        String details = detailsIntent.getStringExtra("Details");
        String imageFileName = title.replace(" ", "") + ".jpeg";

        eventTitleTextView.setText(title);
        eventDetailsTextView.setText(details);

        AssetManager am = context.getAssets();

        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        }
        catch (IOException e) {
            Log.e("OC Music Events", "Cannot load image: " + imageFileName + e);

        }
    }
}
