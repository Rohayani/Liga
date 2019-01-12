package com.ani.liga;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LigaAdapter extends
        RecyclerView.Adapter<LigaAdapter.ViewHolder>{

    ArrayList<Liga> listliga;
    Context context;

    LigaAdapter(Context context){
        this. context = context ;
    }

    public ArrayList<Liga> getListliga() {
        return listliga ;
    }
    public void setListliga(ArrayList<Liga>listliga){

        this.listliga = listliga;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.liga_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        final Liga liga = listliga.get(i);
        viewHolder.tvidTeam.setText(getListliga().get(i).getIdTeam());
        Glide.with(context) .load(getListliga().get(i).getStrTeamBadge())
                .into(viewHolder.imgstrTeamBadge);
        viewHolder.btndetail.setText(getListliga().get(i).getStrTeam());
        viewHolder.btndetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Liga liga = listliga.get(i);
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra ("liga", (Parcelable) liga);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListliga().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       @BindView(R.id.tvidTeam)
       TextView tvidTeam;
       @BindView(R.id.btndetail)
       Button btndetail;
       @BindView(R.id.imgstrTeamBadge)
       ImageView imgstrTeamBadge;

        public ViewHolder(@NonNull View view){
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}