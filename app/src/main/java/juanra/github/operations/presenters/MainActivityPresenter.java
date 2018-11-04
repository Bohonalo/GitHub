package juanra.github.operations.presenters;

import juanra.github.operations.activities.IMain;

public class MainActivityPresenter implements IMainActivityPresenter {

    private IMain iMain;

    public MainActivityPresenter(IMain iMain) {
        this.iMain = iMain;
    }

    @Override
    public void init() {
        iMain.initViews();
    }
}
