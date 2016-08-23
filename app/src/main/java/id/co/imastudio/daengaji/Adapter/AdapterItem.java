package id.co.imastudio.daengaji.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

import id.co.imastudio.daengaji.DetailActivity;
import id.co.imastudio.daengaji.Holder.HolderItem;
import id.co.imastudio.daengaji.ItemObject;
import id.co.imastudio.daengaji.R;

/**
 * Created by imastudio on 8/19/16.
 */
public class AdapterItem extends RecyclerView.Adapter<HolderItem> {
    Context context;
    List<ItemObject.Children> listitemObjects;

    public AdapterItem(Context context, List<ItemObject.Children> listitemObjects) {
        this.context = context;
        this.listitemObjects = listitemObjects;
    }

    @Override
    public HolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, null);
        HolderItem holderItem = new HolderItem(view);
        return holderItem;
    }

    @Override
    public void onBindViewHolder(HolderItem holder, final int position) {
        holder.tvWaktu.setText(listitemObjects.get(position).strdate_created);
        holder.tvJudul.setText(listitemObjects.get(position).strplanet_name);
        Glide.with(context).
                load("http://dev.daeng.id/android/icon/" +
                        listitemObjects.get(position).strplanet_icon).
        placeholder(R.mipmap.ic_launcher).
        into(holder.imgVIcon);
        holder.cardItemPlanet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailActivity.class);
                i.putExtra("judul" , listitemObjects.get(position).strplanet_name);
                i.putExtra("waktu" , listitemObjects.get(position).strdate_created);
                i.putExtra("massa" , listitemObjects.get(position).strmass);
                i.putExtra("surface" , listitemObjects.get(position).strsurface_area);
                i.putExtra("equator" , listitemObjects.get(position).strequator);
                i.putExtra("volume" , listitemObjects.get(position).strvolume);
                i.putExtra("deskripsi" , listitemObjects.get(position).strdescription);

                i.putExtra("header" , listitemObjects.get(position).strheader_img);
                i.putExtra("icon" , listitemObjects.get(position).strplanet_icon);

                i.putExtra("link" , listitemObjects.get(position).strwiki_site);

                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listitemObjects.size();
    }
}
