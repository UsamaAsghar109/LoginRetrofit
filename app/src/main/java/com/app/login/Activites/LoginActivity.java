package com.app.login.Activites;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.login.Api.ApiClient;
import com.app.login.Models.LoginRequest;
import com.app.login.Models.LoginResponse;
import com.app.login.Models.UserStatusResponse;
import com.app.login.R;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextView textView;
    private String token;
    EditText usernameEd, passwordEd;
    Button login, myToken;
    LoginResponse loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEd = findViewById(R.id.usernameEd);
        passwordEd = findViewById(R.id.passwordEd);
        textView=findViewById(R.id.check_data);
        myToken = findViewById(R.id.myToken);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(usernameEd.getText().toString()) || TextUtils.isEmpty(passwordEd.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
//                    textView.setText(usernameEd.getText().toString());

                    LoginRequest loginRequest = new LoginRequest(usernameEd, passwordEd);
                    loginRequest.setPassword(passwordEd.getText().toString());
                    loginRequest.setUsername(usernameEd.getText().toString());
                    loginUser(loginRequest);
                }
            }
        });

//        myToken.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(LoginActivity.this, "Token Button Clicked", Toast.LENGTH_SHORT).show();
////                getToken();
//
//            }
//        });

        myToken.setOnClickListener(new View.OnClickListener() {
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
                        if (!response.isSuccessful()) {
                            textView.setText("Code: " + response.code());
                            return;
                        }
                        List<UserStatusResponse> userStatusResponses = response.body();
                        for (UserStatusResponse userStatusResponse : userStatusResponses) {
                            String content = "";
                            content += "Position: " + userStatusResponse.getPosition() + "\n";
                            content += "Variables: " + userStatusResponse.getVariables() + "\n";
                            content += "Velocity: " + userStatusResponse.getVelocity() + "\n";
                            content += "UTC: " + userStatusResponse.getUtc() + "\n";
                            content += "Username: " + userStatusResponse.getUsername() + "\n";
                            content += "ID: " + userStatusResponse.getId() + "\n";
                            textView.setText(content);

                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserStatusResponse>> call, Throwable t) {

                        Toast.makeText(LoginActivity.this, "Could not fetch any results" + t, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void loginUser(final LoginRequest loginRequest) {
        Call<LoginResponse> loginResponseCall = ApiClient.getApiServices().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (response.isSuccessful()) {
//                    String message=loginResponse.getToken();
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    token = response.body().getToken();
//                    Toast.makeText(LoginActivity.this, token, Toast.LENGTH_SHORT).show();
                    Toast.makeText(LoginActivity.this, "Token" + loginResponse.getToken(), Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(LoginActivity.this, DetailsActivity.class).putExtra("data", token));

                } else {
                    Toast.makeText(LoginActivity.this, "Login is not correct", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Toast.makeText(LoginActivity.this, "Error try again------>" + t, Toast.LENGTH_SHORT).show();
            }
        });

    }

//    private void getToken() {
//        Call<ResponseBody> call = ApiClient.getApiServices().getToken(token);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()) {
//                    try {
//                        Toast.makeText(LoginActivity.this, response.body().string(), Toast.LENGTH_SHORT).show();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//                Toast.makeText(LoginActivity.this, "Token is not correct Error try again------>" + t, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }


}