package com.tencent.opensdk_github;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.tencent.mylibs.TencentImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "在主线程执行代码", Toast.LENGTH_LONG).show();
            }
        });

        final TencentImpl tencentImpl = new TencentImpl(this, "com.tencent.opensdk_github.fileprovider");

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tencentImpl.login(MainActivity.this, "all");
            }
        });

        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("uin", "7148517");
                bundle.putString("title", "title");
                tencentImpl.share(MainActivity.this, bundle);
            }
        });
    }
}