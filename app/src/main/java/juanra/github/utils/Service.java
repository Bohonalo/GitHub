package juanra.github.utils;

import java.util.ArrayList;

import juanra.github.model.Followers;
import juanra.github.model.Git;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {

    @GET("repositories")
    Call<ArrayList<Git>> listGit();

    @GET("users/{username}/repos")
    Call<ArrayList<Git>> listGitName(@Path("username") String name);

    @GET("users/{user}/followers")
    Call<ArrayList<Followers>> loadFollowers(@Path("user") String user);

}
