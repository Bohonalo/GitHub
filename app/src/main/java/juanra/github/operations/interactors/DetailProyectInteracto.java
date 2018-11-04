package juanra.github.operations.interactors;

import android.app.Activity;
import android.widget.Toast;

import java.util.ArrayList;

import juanra.github.model.Followers;
import juanra.github.utils.Client;
import juanra.github.utils.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailProyectInteracto implements IDetailProyectInteracto{

    private Activity activity;

    public DetailProyectInteracto(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void callServiceFollowers(final Onresult listener, String name) {
        try{
            Retrofit retrofit = Client.getClient();
            Service apiService =
                    retrofit.create(Service.class);
            Call<ArrayList<Followers>> call = apiService.loadFollowers(name);

            call.enqueue(new Callback<ArrayList<Followers>>() {
                @Override
                public void onResponse(Call<ArrayList<Followers>> call, Response<ArrayList<Followers>> response) {
                    if(response.isSuccessful()){
                        ArrayList<Followers> follower = response.body();
                        listener.OnSucess(follower);
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Followers>> call, Throwable t) {
                    Toast.makeText(activity, "Error Fetching Data!" + t.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }

            });

        }catch (Exception e){
            Toast.makeText(activity, e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
