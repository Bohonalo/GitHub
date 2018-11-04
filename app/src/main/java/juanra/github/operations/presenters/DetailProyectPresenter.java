package juanra.github.operations.presenters;

import android.app.Activity;

import java.util.ArrayList;
import juanra.github.model.Details;
import juanra.github.model.Followers;
import juanra.github.operations.activities.IDetailProyect;
import juanra.github.operations.interactors.DetailProyectInteracto;
import juanra.github.operations.interactors.IDetailProyectInteracto;

public class DetailProyectPresenter implements IDetailProyectPresenter, DetailProyectInteracto.Onresult {

    private IDetailProyect view;
    private Activity activity;
    private IDetailProyectInteracto interactor;

    public DetailProyectPresenter(IDetailProyect view, Activity activity) {
        this.view = view;
        this.activity = activity;
        this.interactor = new DetailProyectInteracto(activity);
    }


    @Override
    public void inti() {
        view.initView();
        view.initValues();
    }

    @Override
    public void WriteDetail(Details details) {
        view.setname(details.getName());
        view.setImage(details.getAvatarUrl());
        view.setUsername(details.getUserName());
        view.setUrl(details.getUrl());
        view.setDescription(details.getDescription());
    }

    @Override
    public void callServiceFollowers(String name) {
        interactor.callServiceFollowers(this, name);
    }


    @Override
    public void OnSucess(ArrayList<Followers> followers) {
        view.writeFollowers(followers);
    }
}
