package com.annasblackhat.sesi3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MyFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);

        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "this data from activity. Code :  xhsf34";
                Bundle bundle = new Bundle();
                bundle.putString("data", data);

                FirstFragment firstFragment = new FirstFragment();
                firstFragment.setArguments(bundle);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.layout_root, firstFragment)
                        .commit();
            }
        });
    }
}
