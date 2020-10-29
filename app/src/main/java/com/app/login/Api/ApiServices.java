package com.app.login.Api;

import com.app.login.Models.LoginRequest;
import com.app.login.Models.LoginResponse;
import com.app.login.Models.Position;
import com.app.login.Models.UserStatusResponse;
import com.app.login.Models.Variable;
import com.app.login.Models.Velocity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServices {

    @POST("tokens")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @GET("token")
    Call<ResponseBody> getToken(@Header("Authorization") String token);

    @GET("users")
    Call<List<UserStatusResponse>> userStatus(@Header("Authorization") String token);
}
