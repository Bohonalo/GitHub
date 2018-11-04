package juanra.github.operations.activities;

import java.util.ArrayList;

import juanra.github.model.Followers;

public interface IDetailProyect {

    void initView();
    void initValues();
    void setImage(String avatarUr);
    void setname(String name);
    void setUsername(String userName);
    void setUrl(String url);
    void setDescription(String description);

    void writeFollowers(ArrayList<Followers> followers);
}
