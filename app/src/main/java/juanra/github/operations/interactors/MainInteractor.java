package juanra.github.operations.interactors;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import java.util.ArrayList;
import juanra.github.model.Git;
import juanra.github.utils.Client;
import juanra.github.utils.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainInteractor implements IMainInteractor {

    private Activity activity;

    public MainInteractor(FragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public void callService(final IMainInteractor.Onresult listener) {
        try{
            Retrofit retrofit = Client.getClient();
            Service apiService =
                    retrofit.create(Service.class);
            Call<ArrayList<Git>> call = apiService.listGit();

            call.enqueue(new Callback<ArrayList<Git>>() {
                @Override
                public void onResponse(Call<ArrayList<Git>> call, Response<ArrayList<Git>> response) {
                    if(response.isSuccessful()) {
                        ArrayList<Git> list = response.body();
                        listener.OnSucess(list);
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Git>> call, Throwable t) {
                    Toast.makeText(activity, "Error Fetching Data!" + t.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }

            });

        }catch (Exception e){
            Toast.makeText(activity, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void callServicesearch(final Onresult listener, String s) {
        try{
            Retrofit retrofit = Client.getClient();
            Service apiService =
                    retrofit.create(Service.class);
            Call<ArrayList<Git>> call = apiService.listGitName(s);

            call.enqueue(new Callback<ArrayList<Git>>() {
                @Override
                public void onResponse(Call<ArrayList<Git>> call, Response<ArrayList<Git>> response) {
                    if(response.isSuccessful()){
                        ArrayList<Git> list = response.body();
                        listener.OnSucess(list);
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Git>> call, Throwable t) {
                    Toast.makeText(activity, "Error Fetching Data!" + t.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }

            });

        }catch (Exception e){
            Toast.makeText(activity, e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
