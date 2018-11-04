package juanra.github.operations.interactors;

import java.util.ArrayList;

import juanra.github.model.Followers;

public interface IDetailProyectInteracto {

    interface Onresult{
        void OnSucess(ArrayList<Followers> followers);
    }

    void callServiceFollowers(Onresult listener, String name);
}
