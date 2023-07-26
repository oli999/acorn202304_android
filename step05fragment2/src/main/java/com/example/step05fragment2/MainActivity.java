package com.example.step05fragment2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.step05fragment2.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

/*
    view binding 사용하는 방법

    1. build.gradle 파일에 설정(아래의 문자열을 추가)

    buildFeatures {
        viewBinding = true
    }

    2. build.gradle 파일의 우상단에 sync now 버튼을 눌러서 실제 반영되도록 한다.

    3. layout xml 문서의 이름을 확인해서 자동으로 만들어진 클래스명을 예측한다.

    예를들어  activity_main.xml  문서이면  ActivityMainBinding 클래스
    예를들어  activity_sub.xml 문서이면 ActivitySubBinding 클래스 ...
 */
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_main.xml 문서가 존재하기 때문에 ActivityMainBinding 클래스가 만들어진것이다.
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // 바인딩 객체의 getRoot() 메소드가 리턴해주는 View 객체로 화면을 구성한다.
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        //원래는 이런 모양이였다.
        //setContentView(R.layout.activity_main);
        //setSupportActionBar(findViewById(R.id.toolbar));

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}