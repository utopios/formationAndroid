package formation.java.formationanroid.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;

    //Dans le cadre de test avec une api tourne sur une machine local(pensez à utiliser l'adrese ip de cette machine)
    private static  String baseUrl = "http://192.168.1.17:3000/";

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
