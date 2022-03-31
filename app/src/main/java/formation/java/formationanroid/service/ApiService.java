package formation.java.formationanroid.service;

import android.os.AsyncTask;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ApiService {

    public Completable firstRequest() {
       return Completable.fromAction(() -> {
           //Request HTTP
       }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}


//Old way
class FirstTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {
        //requete http
        return null;
    }
}
