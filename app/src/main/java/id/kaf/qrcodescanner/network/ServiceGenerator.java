package id.kaf.qrcodescanner.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Helper class untuk mendapatkan retrofit service
 *
 * @author hendrawd on 7/31/17
 */

public class ServiceGenerator {

//    private static final String BASE_URL = "http://hidok.co.id:8081/HiDok/Api/";
    private static final String BASE_URL = "https://www.invofest.com/";

    private static OkHttpClient.Builder sHttpClient =
            new OkHttpClient.Builder()
                    .addInterceptor(new ApiKeyAdderInterceptor());

    private static Retrofit.Builder sBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(sHttpClient.build());

    public static <T> T createService(Class<T> serviceClass) {
        return sBuilder.build().create(serviceClass);
    }
}
