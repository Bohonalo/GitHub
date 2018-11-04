package juanra.github.operations.fragments;

import java.io.Serializable;
import java.util.ArrayList;

import juanra.github.model.Git;
import juanra.github.model.ListGit;

public interface IMainFragment extends Serializable {

    void initValues();
    void initLisener();
    void writeRc(ArrayList<ListGit> listGits, ArrayList<Git> list);
}
