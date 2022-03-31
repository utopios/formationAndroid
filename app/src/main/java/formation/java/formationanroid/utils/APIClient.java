package formation.java.formationanroid.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;

    private static final String baseUrl = "http://localhost:3000";

    public static Retrofit getClient() {
        //La création d'un objet pour les connexions http (OkHttp)
        OkHttpClient httpClient = new OkHttpClient.Builder().build();

        //La création d'un objet retrofit pour utiliser les apis.
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        return retrofit;
    }
}
