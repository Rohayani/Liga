package com.ani.liga;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rvCategory)
    RecyclerView rvCategory;
    LigaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new LigaAdapter(this);
        String url = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League";
        DemoAsync demoAsync = new DemoAsync();
        demoAsync.execute(url);
    }

    private class DemoAsync extends AsyncTask<String, Void, ArrayList<Liga>> {


        @Override
        protected ArrayList<Liga> doInBackground(String... strings) {
            String uri = strings[0];
            final ArrayList<Liga> ligas = new ArrayList<>();
            SyncHttpClient client = new SyncHttpClient();
            client.setSSLSocketFactory(MySSLSocketFactory.getFixedSocketFactory());
            client.get(uri, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    try {
                        String hasil = new String(responseBody);
                        JSONObject jsontim = new JSONObject(hasil);
                        JSONArray jsonArray = jsontim.getJSONArray("teams");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject timObj = jsonArray.getJSONObject(i);
                            Liga liga = new Liga(timObj);
                            ligas.add(liga);
                            Log.d("TAG", "onSuccess: "+liga.getIdTeam());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    Log.d("Tag", "OnFailure: " + statusCode );
                }
            });
            return ligas;
        }
        @Override
        protected void onPostExecute (final ArrayList<Liga>liga){
            super.onPostExecute(liga);
            rvCategory.setLayoutManager(new LinearLayoutManager(com.ani.liga.MainActivity.this));
            adapter.setListliga(liga);
            rvCategory.setAdapter(adapter);
            ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                    Intent intent = new Intent(MainActivity.this,Detail.class);
                    Liga liga1 = new Liga();
                    liga1.setStrTeamLogo(liga.get(position).strTeamLogo);
                    liga1.setIdLeague(liga.get(position).idLeague);
                    liga1.setStrLeague(liga.get(position).strLeague);
                    liga1.setIntFormedYear(liga.get(position).intFormedYear);

                            intent.putExtra("Detail",liga1);
                    startActivity(intent);
                }
            });
        }
    }
}
