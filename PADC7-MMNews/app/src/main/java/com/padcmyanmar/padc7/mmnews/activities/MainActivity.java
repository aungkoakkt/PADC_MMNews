package com.padcmyanmar.padc7.mmnews.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.padcmyanmar.padc7.mmnews.R;
import com.padcmyanmar.padc7.mmnews.adapters.NewsAdapter;
import com.padcmyanmar.padc7.mmnews.data.models.NewsModel;
import com.padcmyanmar.padc7.mmnews.data.models.NewsModelImpl;
import com.padcmyanmar.padc7.mmnews.data.vos.NewsVO;
import com.padcmyanmar.padc7.mmnews.delegates.NewsItemDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements NewsItemDelegate {

    private BottomSheetBehavior<NestedScrollView> mBottomSheetBehavior;

    @BindView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view) NavigationView mNavigationView;
    @BindView(R.id.toolbar) Toolbar mToolbar;

    private NewsModel mNewsModel;
    private  NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.title_latest_news);

        setSupportActionBar(mToolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_lastest_news:
                        Toast.makeText(getApplicationContext(), getString(R.string.title_latest_news), Toast.LENGTH_SHORT).show();
                        mToolbar.setTitle(R.string.title_latest_news);
                        break;
                    case R.id.menu_news_just_for_you:
                        Toast.makeText(getApplicationContext(), getString(R.string.title_news_just_for_you), Toast.LENGTH_SHORT).show();
                        mToolbar.setTitle(R.string.title_news_just_for_you);
                        break;
                    case R.id.menu_favorite_news:
                        Toast.makeText(getApplicationContext(), getString(R.string.title_favorite_news), Toast.LENGTH_SHORT).show();
                        mToolbar.setTitle(R.string.title_favorite_news);
                        break;
                }
                for (int index = 0; index < mNavigationView.getMenu().size(); index++) {
                    mNavigationView.getMenu().getItem(index).setChecked(false);
                }
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        RecyclerView rvNews = findViewById(R.id.rv_news);
        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        newsAdapter = new NewsAdapter(this);
        rvNews.setAdapter(newsAdapter);

        NestedScrollView nsvBottomSheet = findViewById(R.id.nsv_bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(nsvBottomSheet);

        mBottomSheetBehavior.setPeekHeight(0);

        mNewsModel= NewsModelImpl.getObjInstance();

        bindNews(false);
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
    public void onTapNewsItem() {
        Intent intent = NewsDetailsActivity.newIntent(getApplicationContext());
        startActivity(intent);
    }

    @OnClick(R.id.fab)
    public void onTapFab() {

        if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }

    private void bindNews(boolean isForce){

        List<NewsVO> newsList=mNewsModel.getNews(new NewsModel.NewsDelegate() {

            @Override
            public void onNewsFetchFromNetwork(List<NewsVO> newsList) {
                newsAdapter.setNewData(newsList);
            }

            @Override
            public void onErrorOnNewsFetch(String message) {
                Toast.makeText(MainActivity.this, "Error News Fetch", Toast.LENGTH_SHORT).show();
            }
        },isForce);

        if (newsList!=null){
            newsAdapter.setNewData(newsList);
        }
    }

}
