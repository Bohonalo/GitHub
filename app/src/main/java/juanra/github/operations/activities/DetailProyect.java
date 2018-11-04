package juanra.github.operations.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import juanra.github.R;
import juanra.github.adapter.AdapterFollowers;
import juanra.github.model.Details;
import juanra.github.model.Followers;
import juanra.github.operations.presenters.DetailProyectPresenter;
import juanra.github.operations.presenters.IDetailProyectPresenter;
import juanra.github.utils.Constants;


public class DetailProyect extends AppCompatActivity implements IDetailProyect{

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.userName)
    TextView userNname;
    @BindView(R.id.url)
    TextView url;
    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.rcOption)
    RecyclerView rcOption;

    private Details details;
    private AdapterFollowers adapter;
    private LinearLayoutManager llm;
    private IDetailProyectPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layaout_proyect_detail);

        presenter = new DetailProyectPresenter(this, this);
        presenter.inti();


    }


    @Override
    public void initView() {
        //inject views
        ButterKnife.bind(this);
    }

    @Override
    public void initValues() {
        details = (Details) getIntent().getSerializableExtra(Constants.USERID_DETAIL);
        presenter.WriteDetail(details);
        presenter.callServiceFollowers(details.getUserName());

    }

    @Override
    public void setImage(String avatarUrl) {
        Picasso.with(getApplicationContext())
                .load(avatarUrl)
                .placeholder(R.drawable.loading)
                .into(image);

    }

    @Override
    public void setname(String name) {
        this.name.setText(name);
    }

    @Override
    public void setUsername(String userName) {
        this.userNname.setText(userName);
    }

    @Override
    public void setUrl(String url) {
        this.url.setText(url);
    }

    @Override
    public void setDescription(String description) {
        this.description.setText(description);
    }

    @Override
    public void writeFollowers(ArrayList<Followers> followers) {
        if (!(followers == null)) {
            rcOption.setHasFixedSize(true);
            llm = new LinearLayoutManager(this);
            rcOption.setLayoutManager(llm);
            adapter = new AdapterFollowers(followers, this);
            rcOption.setAdapter(adapter);
        }
    }
}
