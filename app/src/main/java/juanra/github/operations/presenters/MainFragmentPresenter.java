package juanra.github.operations.presenters;


import android.app.Activity;
import android.app.Dialog;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import juanra.github.R;
import juanra.github.model.Git;
import juanra.github.model.ListGit;
import juanra.github.operations.fragments.IMainFragment;
import juanra.github.operations.interactors.IMainInteractor;
import juanra.github.operations.interactors.MainInteractor;

public class MainFragmentPresenter implements IMainFragmentPresenter, MainInteractor.Onresult {

    private IMainFragment view;
    private IMainInteractor interactor;
    private Activity activity;
    private Dialog dialog;

    public MainFragmentPresenter(IMainFragment view, FragmentActivity activity) {
        this.view = view;
        this.interactor = new MainInteractor(activity);
        this.activity = activity;
    }

    @Override
    public void init() {
        view.initValues();
        view.initLisener();
    }


    @Override
    public void callService() {
        interactor.callService(this);
    }

    @Override
    public void setColorFab(FloatingActionButton fab, Resources resources) {
        setFloatingActionButtonColors(fab,
                resources.getColor(R.color.colorPrimary),
                resources.getColor(R.color.blue_dark));
    }

    @Override
    public void search() {
        dialog = new Dialog(activity);
        dialog.setContentView(R.layout.search);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        final EditText nameProyect = dialog.findViewById(R.id.nameProyect);
        Button search = dialog.findViewById(R.id.search);
        final Button cancel = dialog.findViewById(R.id.cancel);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameProyect.getText().toString().isEmpty()){
                    Toast.makeText(activity, activity.getString(R.string.messaje_error_none_caractere),
                            Toast.LENGTH_LONG).show();
                    return;
                }else{
                    interactor.callServicesearch(MainFragmentPresenter.this,
                            nameProyect.getText().toString());
                    dialog.dismiss();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    @Override
    public void OnSucess(ArrayList<Git> list) {
        ArrayList<ListGit> listGits = new ArrayList<ListGit>();
        for (int i=0; i<list.size(); i++){
            ListGit l = new ListGit(list.get(i).getId().toString(),list.get(i).getName(),
                    list.get(i).getOwner().getLogin(),list.get(i).getDescription(),
                    list.get(i).getOwner().getAvatarUrl());
            listGits.add(l);
        }
        view.writeRc(listGits, list);
    }

    private void setFloatingActionButtonColors(FloatingActionButton fab, int primaryColor, int rippleColor) {
        int[][] states = {
                {android.R.attr.state_enabled},
                {android.R.attr.state_pressed},
        };

        int[] colors = {
                primaryColor,
                rippleColor,
        };

        ColorStateList colorStateList = new ColorStateList(states, colors);
        fab.setBackgroundTintList(colorStateList);
    }


}
