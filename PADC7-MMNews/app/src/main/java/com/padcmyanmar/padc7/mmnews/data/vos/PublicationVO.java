package com.padcmyanmar.padc7.mmnews.data.vos;

import com.google.gson.annotations.SerializedName;

public class PublicationVO {

    @SerializedName("publication-id")
    private String publicationId;
    private String title;
    private String logo;

    public String getPublicationId() {
        return publicationId;
    }

    public String getTitle() {
        return title;
    }

    public String getLogo() {
        return logo;
    }
}
