package id.co.imastudio.daengaji.Holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.imastudio.daengaji.R;

/**
 * Created by imastudio on 8/19/16.
 */
public class HolderItem extends RecyclerView.ViewHolder{
    public TextView tvJudul, tvWaktu;
    public CardView cardItemPlanet;
    public ImageView imgVIcon;
    public HolderItem(View itemView) {
        super(itemView);
        tvJudul = (TextView)itemView.findViewById(R.id.txtItemJudul);
        tvWaktu = (TextView)itemView.findViewById(R.id.txtItemWaktu);
        cardItemPlanet = (CardView)itemView.findViewById(R.id.cardItemPlanet);
        imgVIcon = (ImageView) itemView.findViewById(R.id.imgItemIcon);
    }
}
