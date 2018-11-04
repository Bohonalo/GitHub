package juanra.github.operations.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import juanra.github.R;
import juanra.github.adapter.Adapter;
import juanra.github.model.Details;
import juanra.github.model.Git;
import juanra.github.model.ListGit;
import juanra.github.operations.activities.DetailProyect;
import juanra.github.operations.presenters.IMainFragmentPresenter;
import juanra.github.operations.presenters.MainFragmentPresenter;
import juanra.github.utils.Constants;


public class MainFragment extends Fragment implements IMainFragment {

    @BindView(R.id.rcOption)
    RecyclerView rcOption;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    private LinearLayoutManager llm;
    private ArrayList<ListGit> list;
    private ArrayList<Git> git;
    private Adapter adapter;
    private IMainFragmentPresenter presenter;

    public static MainFragment newInstance() {
        MainFragment f = new MainFragment();
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_git, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //inject views
        ButterKnife.bind(this, view);

        presenter = new MainFragmentPresenter(this, getActivity());
        presenter.init();

    }

    @Override
    public void initValues() {
        list = new ArrayList<ListGit>();
        git = new ArrayList<Git>();
        presenter.callService();
        presenter.setColorFab(fab,  getResources());

    }

    @Override
    public void initLisener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.search();
            }
        });
    }

    @Override
    public void writeRc(ArrayList<ListGit> listGits, ArrayList<Git> list) {
        if (!(listGits == null)) {
            rcOption.setHasFixedSize(true);
            llm = new LinearLayoutManager(getContext());
            rcOption.setLayoutManager(llm);
            adapter = new Adapter(listGits, getContext());
            rcOption.setAdapter(adapter);
            onclick(list);
        }

    }

    private void onclick(final ArrayList<Git> list) {
        adapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rcOption.indexOfChild(v);

                Details details = new Details(list.get(rcOption.getChildAdapterPosition(v)).getName(),
                        list.get(rcOption.getChildAdapterPosition(v)).getOwner().getLogin(),
                        list.get(rcOption.getChildAdapterPosition(v)).getDescription(),
                        list.get(rcOption.getChildAdapterPosition(v)).getOwner().getAvatarUrl(),
                        list.get(rcOption.getChildAdapterPosition(v)).getUrl());

                Intent intent = new Intent(getContext(), DetailProyect.class);
                intent.putExtra(Constants.USERID_DETAIL, details);
                startActivity(intent);

            }
        });
    }

}
