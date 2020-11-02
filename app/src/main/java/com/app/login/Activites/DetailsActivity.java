package com.app.login.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.login.Api.ApiClient;
import com.app.login.Api.ApiServices;
import com.app.login.Models.LoginResponse;
import com.app.login.Models.Variable;
import com.app.login.R;
import com.app.login.Models.UserStatusResponse;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Header;

public class DetailsActivity extends AppCompatActivity {

    ApiClient instance;
    private String token,username;
    LoginResponse loginResponse;
    UserStatusResponse userStatusResponse;
    Button Fetch_btn;
    TextView Position;
    TextView Utc;
    TextView Velocity;
    TextView Variables;
    TextView Username;
    TextView Id;
//    String fetchingvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Fetch_btn=findViewById(R.id.fetch_btn);
        Position=findViewById(R.id.position);
        Utc=findViewById(R.id.utc);
        Velocity=findViewById(R.id.velocity);
        Variables=findViewById(R.id.variables);
        Username=findViewById(R.id.username);
        Id=findViewById(R.id.id);

        Fetch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=getIntent();
//                if(intent.getExtras()!=null)
//                {
//                    loginResponse=(LoginResponse) intent.getSerializableExtra("data");
//                    Toast.makeText(DetailsActivity.this, "The message "+loginResponse, Toast.LENGTH_SHORT).show();
//                }
//                userStatusResponse();
                Call<List<UserStatusResponse>> call = ApiClient.getApiServices().userStatus(token);
                call.enqueue(new Callback<List<UserStatusResponse>>() {
                    @Override
                    public void onResponse(Call<List<UserStatusResponse>> call, Response<List<UserStatusResponse>> response) {
                        if(!response.isSuccessful()){
                            Position.setText("Code: "+response.code());
                            return;
                        }
                        List<UserStatusResponse> userStatusResponses=response.body();
                        for (UserStatusResponse userStatusResponse: userStatusResponses){
                            String content="";
                            content +="Position: "+userStatusResponse.getPosition()+"\n";
                            content +="Variables: "+userStatusResponse.getVariables()+"\n";
                            content +="Velocity: "+userStatusResponse.getVelocity()+"\n";
                            content +="UTC: "+userStatusResponse.getUtc()+"\n";
                            content +="Username: "+userStatusResponse.getUsername()+"\n";
                            content +="ID: "+userStatusResponse.getId()+"\n";
                            Position.setText(content);

                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserStatusResponse>> call, Throwable t) {

                        Toast.makeText(DetailsActivity.this, "Could not fetch any results"+t, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

//    private void userStatusResponse() {
//
//        Call<UserStatusResponse> userStatusResponseCall=ApiClient.getApiServices().userStatus(token);
//
//
//    }


//    private void userStatusResponse(final ApiClient token) {
////        Call<UserStatusResponse> userStatusResponseCall= ApiClient.getApiServices().userStatus();
////        userStatusResponseCall.enqueue(new Callback<UserStatusResponse>() {
//            @Override
//            public void onResponse(Call<UserStatusResponse> call, Response<UserStatusResponse> response) {
//
//                UserStatusResponse userStatusResponse = new UserStatusResponse(Position ,Utc, Velocity, Variables, Username, Id);
//
//                if (userStatusResponse == null) {
//                    Toast.makeText(DetailsActivity.this, "No Value have been fetched", Toast.LENGTH_SHORT).show();
//                } else {
////                    Position.setText("position-->   " + userStatusResponse.getPosition());
//                    Utc.setText("utc-->   " + userStatusResponse.getUtc());
//                    Velocity.setText("velocity-->   " + userStatusResponse.getVelocity());
//                    Variables.setText("variables-->   " + userStatusResponse.getVariables());
//                    Username.setText("username-->   " + userStatusResponse.getUsername());
//                    Id.setText("id-->   " + userStatusResponse.getId());
//                    Toast.makeText(DetailsActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
//                }
//                try {
//                    fetchingvalue="Response\n\n\n"+ new Gson().toJson(response.body());
//                    Position.setText(fetchingvalue);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//            @Override
//            public void onFailure(Call<UserStatusResponse> call, Throwable t) {
//
//                Toast.makeText(DetailsActivity.this, "Something is wrong try again."+t, Toast.LENGTH_SHORT).show();
//            }
//        });


    }
