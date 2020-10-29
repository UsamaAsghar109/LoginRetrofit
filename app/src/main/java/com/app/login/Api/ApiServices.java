package com.app.login.Api;

import com.app.login.Models.LoginRequest;
import com.app.login.Models.LoginResponse;
import com.app.login.Models.Position;
import com.app.login.Models.UserStatusResponse;
import com.app.login.Models.Variable;
import com.app.login.Models.Velocity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("tokens")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @GET("token")
    Call<ResponseBody> getToken(@Header("Authorization") String token);

    @GET("/applications/403/users")
    Call<UserStatusResponse> userStatus(@Header("Authorization") String token,
                                        );

}

//    Header("Authorization") ApiClient authorization