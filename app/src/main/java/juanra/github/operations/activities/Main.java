package juanra.github.operations.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import juanra.github.R;
import juanra.github.operations.fragments.MainFragment;
import juanra.github.operations.presenters.MainActivityPresenter;

public class Main extends AppCompatActivity implements IMain{

    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);
        presenter.init();
    }

    @Override
    public void initViews() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.rlContent, MainFragment.newInstance(), null)
                .commit();
    }
}
