package com.example.clientServer.API;

import com.example.clientServer.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ResponseModel> ardRetrieveData();

    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseModel> ardCreateData(
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("fakultas") String fakultas,
            @Field("prodi") String prodi,
            @Field("status") String status,
            @Field("nim") String nim,
            @Field("angkatan") String angkatan,
            @Field("semester") String semester
    );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseModel> ardDeleteData(
            @Field("id_mhs") int idMhs
    );

    @FormUrlEncoded
    @POST("get.php")
    Call<ResponseModel> ardGetData(
            @Field("id_mhs") int idMhs
    );

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseModel> ardUpdateData(
            @Field("id_mhs") int idMhs,
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("fakultas") String fakultas,
            @Field("prodi") String prodi,
            @Field("status") String status,
            @Field("nim") String nim,
            @Field("angkatan") String angkatan,
            @Field("semester") String semester
    );
}
