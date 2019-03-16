package com.padcmyanmar.padc7.mmnews.data.vos;

public class CommentVO {

    private String commentId;
    private String comment;
    private String commentDate;
    private ActedUserVO actedUser;

    public String getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }
}
