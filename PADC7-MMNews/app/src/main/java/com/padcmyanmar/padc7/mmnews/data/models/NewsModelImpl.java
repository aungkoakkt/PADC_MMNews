package com.padcmyanmar.padc7.mmnews.data.models;

import android.support.annotation.Nullable;

import com.padcmyanmar.padc7.mmnews.data.vos.CommentVO;
import com.padcmyanmar.padc7.mmnews.data.vos.FavouriteVO;
import com.padcmyanmar.padc7.mmnews.data.vos.NewsVO;
import com.padcmyanmar.padc7.mmnews.data.vos.SendToVO;
import com.padcmyanmar.padc7.mmnews.network.HttpUrlConnectionDataAgent;
import com.padcmyanmar.padc7.mmnews.network.NewsDataAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsModelImpl extends BaseModel implements NewsModel {

    private static NewsModelImpl objInstance = null;

    public static final String ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private Map<String, NewsVO> mNews;

    private NewsDataAgent mDataAgent;

    private NewsModelImpl() {
        mNews = new HashMap<>();
        mDataAgent= HttpUrlConnectionDataAgent.getInstance();
    }

    public static NewsModelImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new NewsModelImpl();
        }
        return objInstance;
    }

    @Override
    public void addCommentNews(NewsVO news, CommentVO comment) {

    }

    @Override
    public void favouriteNews(NewsVO news, FavouriteVO favourite) {

    }

    @Override
    public void sendNewsTo(NewsVO news, SendToVO sendToVO) {

    }

    @Override
    public @Nullable List<NewsVO> getNews(final NewsDelegate newsDelegate,boolean isForce) {

        if (mNews.isEmpty() || isForce){
            mDataAgent.loadNews(1,
                    ACCESS_TOKEN,
                    new HttpUrlConnectionDataAgent.GetNewsTask.NewsResponseDelegate() {
                @Override
                public void onSuccess(List<NewsVO> newsList) {
                    for (NewsVO news:newsList){
                        mNews.put(news.getNewsId(),news);
                    }

                    newsDelegate.onNewsFetchFromNetwork(new ArrayList<>(mNews.values()));

                }

                @Override
                public void onFail(String message) {

                    newsDelegate.onErrorOnNewsFetch(message);
                }
            });
        }else {
            return new ArrayList<>(mNews.values());
        }
        return null;
    }
}
