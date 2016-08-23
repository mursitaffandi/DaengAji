package id.co.imastudio.daengaji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import id.co.imastudio.daengaji.Adapter.AdapterItem;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rclListItem;
    private LinearLayoutManager linearLayoutManager;
    private ItemObject itemObject;
    private AdapterItem mainAdapterItem;
    private SearchView srcMainData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rclListItem = (RecyclerView) findViewById(R.id.rclMain);

        linearLayoutManager = new LinearLayoutManager(this);
        rclListItem.setLayoutManager(linearLayoutManager);

        RequestDataServer("http://dev.daeng.id/android/data.php");
    }

    private void RequestDataServer(String urlRequest) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest strRequest = new StringRequest(Request.Method.GET, urlRequest/*url server here*/, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                itemObject = gson.fromJson(response, ItemObject.class);
                mainAdapterItem = new AdapterItem(getApplicationContext(), itemObject.listplanet);
                rclListItem.setAdapter(mainAdapterItem);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Fail send request to server", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(strRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        srcMainData = (SearchView) menu.findItem(R.id.itemMenuSearch).getActionView();
        srcMainData.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                RequestDataServer("http://dev.daeng.id/android/search.php?cari=" + newText);
                return true;
            }
        });
//        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemMenuRefresh:
                RequestDataServer("http://dev.daeng.id/android/data.php");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
