package com.padcmyanmar.padc7.mmnews.network;

public interface NewsDataAgent {

    String ATTRACTION_BASE_URL = "http://padcmyanmar.com/padc-3/mm-news/apis/v1/";
    String API_GET_ATTRACTION_LIST = "getMMNews.php";

    String PARAM_ACCESS_TOKEN = "access_token";

    String PARAM_PAGE_NUMBER = "page";


    void loadNews(int page, String accessToken, HttpUrlConnectionDataAgent.GetNewsTask.NewsResponseDelegate newsResponseDelegate);

    void login(String phoneNumber, String password);

    void register(String phoneNumber, String name, String password);
}
