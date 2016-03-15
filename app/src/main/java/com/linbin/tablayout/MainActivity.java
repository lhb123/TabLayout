package com.linbin.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.linbin.tablayout.Fragment.TabFragment;
import com.linbin.tablayout.adpter.TabFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("linbin");
        setSupportActionBar(toolbar);

        tabs = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        List<String> tabList = new ArrayList<>();
        tabList.add("tab1");
        tabList.add("tab2");
        tabList.add("tab3");

        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.addTab(tabs.newTab().setText(tabList.get(0)));
        tabs.addTab(tabs.newTab().setText(tabList.get(1)));
        tabs.addTab(tabs.newTab().setText(tabList.get(2)));

        List<Fragment> fragmentList = new ArrayList<>();
        for(int i = 0; i < tabList.size(); i++){
            Fragment fragment = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("content","hello world" + i);
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }

        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), fragmentList, tabList);
        viewPager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
        tabs.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
        tabs.setTabsFromPagerAdapter(fragmentAdapter);//给Tabs设置适配器
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
}
