package juanra.github.operations.presenters;

import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;

import juanra.github.utils.Client;

public interface IMainFragmentPresenter {

    void init();
    void callService();

    void setColorFab(FloatingActionButton fab, Resources resources);

    void search();
}
