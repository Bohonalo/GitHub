package juanra.github.operations.interactors;


import android.view.View;

import java.util.ArrayList;
import juanra.github.model.Git;

public interface IMainInteractor {

    interface Onresult{
        void OnSucess(ArrayList<Git> list);
    }

    void callService(IMainInteractor.Onresult listener);
    void callServicesearch(IMainInteractor.Onresult listener, String s);
}
