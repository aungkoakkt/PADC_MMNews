package com.padcmyanmar.padc7.mmnews.data.models;

import com.padcmyanmar.padc7.mmnews.data.vos.CommentVO;
import com.padcmyanmar.padc7.mmnews.data.vos.FavouriteVO;
import com.padcmyanmar.padc7.mmnews.data.vos.NewsVO;
import com.padcmyanmar.padc7.mmnews.data.vos.SendToVO;

import java.util.List;

public interface NewsModel {

    void addCommentNews(NewsVO news,CommentVO comment);

    void favouriteNews(NewsVO news,FavouriteVO favourite);

    void sendNewsTo(NewsVO news, SendToVO sendToVO);

    //Get News
    List<NewsVO> getNews(NewsDelegate newsDelegate,boolean isForce);

    interface NewsDelegate{

        void onNewsFetchFromNetwork(List<NewsVO> newsList);

        void onErrorOnNewsFetch(String message);
    }
}
