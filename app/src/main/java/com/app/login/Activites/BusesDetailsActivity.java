package com.app.login.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.login.Activites.Adapter.RecyclerViewAdapter;
import com.app.login.Api.ApiClient;
import com.app.login.Models.BusesViewModel;
import com.app.login.Models.LoginResponse;
import com.app.login.R;
import com.app.login.Models.UserStatusResponse;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusesDetailsActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickedItem{

    private String token, username;
    UserStatusResponse userStatusResponse;
    LoginResponse loginResponse;
    Button All_Buses, All_Shuttle, Buses_Route_1, Buses_Route_2, Buses_Route_3, Buses_Route_4, Buses_Route_5, Buses_Route_6, Buses_Route_7, Buses_Route_8;
    TextView All_Buses_Text, All_Shuttle_Text, Buses_Route_1_Text, Buses_Route_2_Text, Buses_Route_3_Text, Buses_Route_4_Text, Buses_Route_5_Text, Buses_Route_6_Text, Buses_Route_7_Text, Buses_Route_8_Text;
    Button Fetch_Views, Route;
    TextView Fetch_Views_Text;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    //    String fetchingvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buses_details);
        Fetch_Views = findViewById(R.id.fetch_views);
        recyclerView=findViewById(R.id.recycler_view_fetch);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerViewAdapter=new RecyclerViewAdapter(this::ClickedView);

        Fetch_Views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<List<BusesViewModel>> call = ApiClient.getApiServices().busesViews(ApiClient.AUTH);
                call.enqueue(new Callback<List<BusesViewModel>>() {
                    @Override
                    public void onResponse(Call<List<BusesViewModel>> call, Response<List<BusesViewModel>> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(BusesDetailsActivity.this, "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        List<BusesViewModel> busesViewModels = response.body();
                        for (BusesViewModel busesViewModel : busesViewModels) {
                            String content = "";
                            content += "TagID" + busesViewModel.getTagIDs() + "\n";
                            content += "applicationId: " + busesViewModel.getApplicationID() + "\n";
                            content += "name: " + busesViewModel.getName() + "\n";
                            content += "description: " + busesViewModel.getDescription() + "\n";
                            content += "matchAllTags: " + busesViewModel.getMatchAllTags() + "\n";
                            content += "statusFilter: " + busesViewModel.getStatusFilter() + "\n";
                            content += "id: " + busesViewModel.getId() + "\n";
                            content += "           " + "\n\n\n";

                            recyclerViewAdapter.setData(busesViewModels);
                            recyclerView.setAdapter(recyclerViewAdapter);

                        }
                        Toast.makeText(BusesDetailsActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<List<BusesViewModel>> call, Throwable t) {
                        Toast.makeText(BusesDetailsActivity.this, "Could not fetch any results" + t, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    @Override
    public void ClickedView(BusesViewModel busesViewModel) {
        Log.e("Clicked User",busesViewModel.toString());
        startActivity(new Intent(BusesDetailsActivity.this,BusesFetchedDetails.class).putExtra("data",busesViewModel));

    }

}
