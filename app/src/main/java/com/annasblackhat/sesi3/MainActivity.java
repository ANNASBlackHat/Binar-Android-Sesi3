package com.annasblackhat.sesi3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recviewNews;
    private List<News> newsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager linearLayoutVertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_fall_down);

        recviewNews = findViewById(R.id.recview_news);
        recviewNews.setLayoutManager(linearLayoutVertical);
        recviewNews.setAdapter(new NewsAdapter(newsList));
        recviewNews.setLayoutAnimation(animation);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsList.add(new News(newsList.size()+" GO-JEK Dikabarkan siap ekspansi ke 4 negara asia tenggara pada 2018", "", "29-03-2018 11:58"));
                recviewNews.getAdapter().notifyItemInserted(newsList.size()-1);
                recviewNews.smoothScrollToPosition(newsList.size()-1);
            }
        });

        loadFromServer();
    }

    private void loadFromServer() {
        newsList.clear();
        newsList.add(new News("1 GO-JEK Dikabarkan siap ekspansi ke 4 negara asia tenggara pada 2018", "", "29-03-2018 11:58"));
        newsList.add(new News("2 GO-JEK Dikabarkan siap ekspansi ke 4 negara asia tenggara pada 2018", "", "29-03-2018 11:58"));
        newsList.add(new News("3 GO-JEK Dikabarkan siap ekspansi ke 4 negara asia tenggara pada 2018", "", "29-03-2018 11:58"));
        newsList.add(new News("4 GO-JEK Dikabarkan siap ekspansi ke 4 negara asia tenggara pada 2018", "", "29-03-2018 11:58"));
        newsList.add(new News("5 GO-JEK Dikabarkan siap ekspansi ke 4 negara asia tenggara pada 2018", "", "29-03-2018 11:58"));
        recviewNews.getAdapter().notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_fragment){
            startActivity(new Intent(this, MyFragmentActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
