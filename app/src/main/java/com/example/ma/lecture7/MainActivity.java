package com.example.ma.lecture7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ViewPager pager;
    TabLayout tabs;
    DrawerLayout drawer;
    NavigationView nv;
    ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pager=(ViewPager) findViewById(R.id.pager);
        drawer=(DrawerLayout) findViewById(R.id.drawerlayout);
        nv=(NavigationView) findViewById(R.id.nav_drawer);
        tabs=(TabLayout) findViewById(R.id.tabs);
        setup_viewpager();
        tabs.setupWithViewPager(pager);
        drawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawer,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawer.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.login){
                    startActivity(new Intent(MainActivity.this,Login_Activity.class));
                }
                if(item.getItemId()==R.id.signup){
                    startActivity(new Intent(MainActivity.this,Signup.class));
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is pres
        // ent.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id==R.id.shoppingcart){
            Intent i=new Intent(MainActivity.this,shoping_cart.class);
            startActivity(i);
        }

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
    class viewpageradapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> fragmentArrayList =new ArrayList<>();
        ArrayList<String> titles=new ArrayList<>();
        public viewpageradapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }
        public void add_items_to_list(Fragment f,String s){
            fragmentArrayList.add(f);
            titles.add(s);
        }
        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
    public void setup_viewpager(){
        viewpageradapter adapter =new viewpageradapter(getSupportFragmentManager());
        adapter.add_items_to_list(new Mainpage(),"All");
        adapter.add_items_to_list(new Catorgeries(),"Catorgeries");
        adapter.add_items_to_list(new Wishlist(),"Wishlist");
        adapter.add_items_to_list(new Computers(),"Computers");
        pager.setAdapter(adapter);
    }

}
