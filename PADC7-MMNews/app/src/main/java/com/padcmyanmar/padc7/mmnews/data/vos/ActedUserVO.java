package com.padcmyanmar.padc7.mmnews.data.vos;

import com.google.gson.annotations.SerializedName;

public class ActedUserVO {

    @SerializedName("")
    private String userId;
    private String userName;
    private String profileImage;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getProfileImage() {
        return profileImage;
    }
}
