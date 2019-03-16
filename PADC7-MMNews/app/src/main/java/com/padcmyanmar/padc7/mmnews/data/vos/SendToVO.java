package com.padcmyanmar.padc7.mmnews.data.vos;

public class SendToVO {

    private String sendToId;
    private String send_date;
    private ActedUserVO actedUser;
    private ActedUserVO receivedUser;

    public String getSendToId() {
        return sendToId;
    }

    public String getSend_date() {
        return send_date;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public ActedUserVO getReceivedUser() {
        return receivedUser;
    }
}
