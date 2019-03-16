package com.padcmyanmar.padc7.mmnews.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsVO {

    @SerializedName("news-id")
    private String newsId;

    @SerializedName("brief")
    private String brief;

    @SerializedName("details")
    private String detials;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("posted-date")
    private String posted_date;

    @SerializedName("publication")
    private PublicationVO publication;

    @SerializedName("favorites")
    private List<FavouriteVO> favourites;

    @SerializedName("comments")
    private List<CommentVO> comments;

    @SerializedName("sent-tos")
    private List<SendToVO> sendTos;

    public String getNewsId() {
        return newsId;
    }

    public String getBrief() {
        return brief;
    }

    public String getDetials() {
        return detials;
    }

    public List<String> getImages() {
        return images;
    }

    public String getPosted_date() {
        return posted_date;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public List<FavouriteVO> getFavourites() {
        return favourites;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public List<SendToVO> getSendTos() {
        return sendTos;
    }
}
