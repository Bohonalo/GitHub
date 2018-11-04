package juanra.github.operations.presenters;

import android.app.Activity;

import juanra.github.model.Details;

public interface IDetailProyectPresenter {

    void inti();
    void WriteDetail(Details details);

    void callServiceFollowers(String name);
}
