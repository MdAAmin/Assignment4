package com.example.destinago;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> groupData;
    HashMap<String, List<String>> childData;
    int lastExpandedGroup = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);

        expandableListView = findViewById(R.id.expandableListView);

        prepareData(); // Method to prepare the group and child data

        // Create and set the custom adapter for the ExpandableListView
        DestinationAdapter adapter = new DestinationAdapter(this, groupData, childData);
        expandableListView.setAdapter(adapter);

        // Group click listener (to show the group name in a toast)
        expandableListView.setOnGroupClickListener((parent, v, groupPosition, id) -> {
            String groupText = groupData.get(groupPosition);
            Toast.makeText(getApplicationContext(), groupText, Toast.LENGTH_SHORT).show();
            return false; // Return false to allow the group to expand or collapse
        });

        // Group collapse listener (to show which group was collapsed)
        expandableListView.setOnGroupCollapseListener(groupPosition -> {
            String groupText = groupData.get(groupPosition);
            Toast.makeText(getApplicationContext(), groupText + " is Collapsed", Toast.LENGTH_SHORT).show();
        });

        // Child click listener (to show the child name in a toast)
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String childText = childData.get(groupData.get(groupPosition)).get(childPosition);
            Toast.makeText(getApplicationContext(), childText, Toast.LENGTH_SHORT).show();
            return false;
        });

        // Group expand listener (to collapse previously expanded group)
        expandableListView.setOnGroupExpandListener(groupPosition -> {
            if (lastExpandedGroup != -1 && lastExpandedGroup != groupPosition) {
                expandableListView.collapseGroup(lastExpandedGroup);
            }
            lastExpandedGroup = groupPosition;
        });
    }

    // Prepare data for groups (destinations) and children (places under each destination)
    private void prepareData() {
        // Example data
        String[] groupArray = getResources().getStringArray(R.array.destinations_array);

        // Define different child arrays for each group
        String[] europeArray = getResources().getStringArray(R.array.europe_array);
        String[] asiaArray = getResources().getStringArray(R.array.asia_array);
        String[] northAmericaArray = getResources().getStringArray(R.array.north_america_array);

        groupData = new ArrayList<>();
        childData = new HashMap<>();

        // Loop through groups and add corresponding children
        for (String group : groupArray) {
            groupData.add(group);

            List<String> childList = new ArrayList<>();

            // Add children for each group
            if (group.equals("Europe")) {
                for (String place : europeArray) {
                    childList.add(place);
                }
            } else if (group.equals("Asia")) {
                for (String place : asiaArray) {
                    childList.add(place);
                }
            } else if (group.equals("North America")) {
                for (String place : northAmericaArray) {
                    childList.add(place);
                }
            }

            // Put the child list under the group
            childData.put(group, childList);
        }
    }

}
