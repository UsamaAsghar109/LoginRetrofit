package com.app.login.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.app.login.Models.BusesViewModel;
import com.app.login.R;

public class BusesFetchedDetails extends AppCompatActivity {

    TextView TagID,ApplicationID,Name,Description,MatchAllTags,StatusFilter,Id;
    BusesViewModel busesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses_fetched_details);
        TagID=findViewById(R.id.tagID);
        ApplicationID=findViewById(R.id.applicationId);
        Name=findViewById(R.id.name);
        Description=findViewById(R.id.description);
        MatchAllTags=findViewById(R.id.matchAllTags);
        StatusFilter=findViewById(R.id.statusFilter);
        Id=findViewById(R.id.id);

        Intent intent=getIntent();
        if(intent.getExtras()!=null)
        {
            busesViewModel=(BusesViewModel) intent.getSerializableExtra("data");
            int[] tagID=busesViewModel.getTagIDs();
            int applicationID=busesViewModel.getApplicationID();
            String name=busesViewModel.getName();
            String description=busesViewModel.getDescription();
            String matchAllTags=busesViewModel.getMatchAllTags();
            String statusFilter=busesViewModel.getStatusFilter();
            int id=busesViewModel.getId();

//            TagID.setText(tagID);
            ApplicationID.setText(applicationID);
            Name.setText(name);
            Description.setText(description);
            MatchAllTags.setText(matchAllTags);
            StatusFilter.setText(statusFilter);
            Id.setText(id);

        }
    }
}