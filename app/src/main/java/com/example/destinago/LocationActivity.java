package com.example.destinago;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class LocationActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        listView = findViewById(R.id.listView);

        // Get region strings (Europe, Asia, North America)
        String[] regions = getResources().getStringArray(R.array.tech_array);

        // Arrays for the locations based on region
        String[] europeLocations = getResources().getStringArray(R.array.europe_location);
        String[] asiaLocations = getResources().getStringArray(R.array.asia_location);
        String[] northAmericaLocations = getResources().getStringArray(R.array.north_america_location);

        // Image resources for the list items (using placeholder images)
        Integer[] imgId = {
                R.drawable.europe,
                R.drawable.asia,
                R.drawable.north_america
        };

        // Set the adapter for the list view, passing the regions and locations
        LocationAdapter adapter = new LocationAdapter(this, regions, europeLocations, asiaLocations, northAmericaLocations, imgId);
        listView.setAdapter(adapter);
    }
}
