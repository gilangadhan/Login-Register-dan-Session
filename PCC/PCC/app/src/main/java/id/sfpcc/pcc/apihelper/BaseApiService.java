/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.sfpcc.pcc.apihelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Gilang Ramadhan on 11/06/2017.
 */

public interface BaseApiService {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> login (@Field("email_user") String email_user,
                              @Field("pass_user") String pass_user);

    @FormUrlEncoded
    @POST("signup.php")
    Call<ResponseBody> register (@Field("nama_user") String nama_user,
                                 @Field("email_user") String email_user,
                                 @Field("pass_user") String pass_user,
                                 @Field("no_user") String no_user,
                                 @Field("alamat_user") String alamat_user,
                                 @Field("jabatan_user") String jabatan_user);
}
