package id.kaf.qrcodescanner.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyService {

    @GET("apiAbsensiSeminar")
    Call<String> seminar(
            @Query("id") String idTiket
    );

    @GET("apiAbsensiTalkshow")
    Call<String> talkshow(
            @Query("id") String idTiket
    );

    @GET("apiAbsensiWorkshop")
    Call<String> workshop(
            @Query("id") String idTiket
    );

    @GET("apiSertifikatWorkshop")
    Call<String> sertifikat_workshop(
            @Query("id") String idTiket
    );

    @GET("apiSertifikatTalkshow")
    Call<String> sertifikat_talkshow(
            @Query("id") String idTiket
    );

    @GET("apiSertifikatSeminar")
    Call<String> sertifikat_seminar(
            @Query("id") String idTiket
    );

}
