package id.co.imastudio.daengaji;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by imastudio on 8/19/16.
 */
public class DetailActivity extends AppCompatActivity{
    TextView txtJudul, txtWaktu, txtMassa, txtSurface, txtEquator, txtVolume, txtDeskripsi;
    ImageView imgHeader, imgIcon;
    Button btnWiki;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtJudul = (TextView)findViewById(R.id.txt_judul);
        txtWaktu = (TextView)findViewById(R.id.txt_waktu);
        txtMassa = (TextView)findViewById(R.id.txt_mass);
        txtSurface = (TextView)findViewById(R.id.txt_srfc);
        txtEquator = (TextView)findViewById(R.id.txt_equator);
        txtVolume = (TextView)findViewById(R.id.txt_volume);
        txtDeskripsi = (TextView)findViewById(R.id.txt_deskripsi);

        imgHeader = (ImageView) findViewById(R.id.img_header);
        imgIcon = (ImageView)findViewById(R.id.img_icon);

        btnWiki = (Button) findViewById(R.id.btn_wiki);


        txtJudul.setText(getIntent().getStringExtra("judul"));
        txtWaktu.setText(getIntent().getStringExtra("waktu"));
        txtMassa.setText(getIntent().getStringExtra("massa"));
        txtSurface.setText(getIntent().getStringExtra("surface"));
        txtEquator.setText(getIntent().getStringExtra("equator"));
        txtVolume.setText(getIntent().getStringExtra("volume"));
        txtDeskripsi.setText(getIntent().getStringExtra("deskripsi"));

        Glide.with(getApplicationContext()).
                load("http://dev.daeng.id/android/header/" +
                        getIntent().getStringExtra("header")).
                placeholder(R.mipmap.ic_launcher).
                into(imgHeader);

        Glide.with(this).
                load("http://dev.daeng.id/android/icon/" +
                        getIntent().getStringExtra("icon")).
                placeholder(R.mipmap.ic_launcher).
                into(imgIcon);

        btnWiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getIntent().getStringExtra("link")));
                startActivity(browserIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_menu, menu);

//        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemMenushare :
                /*Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("plain/text");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, getIntent().getStringExtra("judul"));
                shareIntent.putExtra(Intent.EXTRA_TEXT, getIntent().getStringExtra("deskripsi"));

                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Intent actionShare = new Intent(Intent.createChooser(shareIntent, "Action Share intent"));

                actionShare.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(actionShare);*/
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("image/png");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, getIntent().getStringExtra("judul"));
                shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("android:resource//id.co.imastudio.daengaji/mipmap/ic_refresh.png"));

                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Intent actionShare = new Intent(Intent.createChooser(shareIntent, "Action Share intent"));

                actionShare.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(actionShare);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}






