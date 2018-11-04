package juanra.github.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import juanra.github.R;
import juanra.github.model.Followers;

public class AdapterFollowers extends RecyclerView.Adapter<AdapterFollowers.ViewHolder> implements View.OnClickListener {
    private ArrayList<Followers> list;
    private View.OnClickListener listener;
    private Context context;

    public AdapterFollowers(ArrayList<Followers> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterFollowers.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.followers,viewGroup,false);
        v.setOnClickListener(this);
        AdapterFollowers.ViewHolder viewHolder = new AdapterFollowers.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFollowers.ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).getLogin());

        Picasso.with(context)
                .load(list.get(i).getAvatarUrl())
                .placeholder(R.drawable.loading)
                .into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }else{
            return 0;
        }
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;

        @BindView(R.id.name)
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //inject views
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener=listener;
    }
}
