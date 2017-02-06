package com.openoter.youngerseniors.entity;

/**
 * Created by asus on 2016/10/23.
 */

public class TopicLatestReleaseEntity {

    /**
     * Id : 1
     * UserName : Ni
     * MegContent : 第一次用面膜
     * ViewTimes : 20
     * CommentTime : 12
     * PublishTime : 12
     */

    private int Id;
    private String UserName;
    private String MegContent;
    private String ViewTimes;
    private String CommentTime;

    public String getPublishTime() {
        return PublishTime;
    }

    public void setPublishTime(String publishTime) {
        PublishTime = publishTime;
    }

    private String PublishTime;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getMegContent() {
        return MegContent;
    }

    public void setMegContent(String MegContent) {
        this.MegContent = MegContent;
    }

    public String getViewTimes() {
        return ViewTimes;
    }

    public void setViewTimes(String ViewTimes) {
        this.ViewTimes = ViewTimes;
    }

    public String getCommentTime() {
        return CommentTime;
    }

    public void setCommentTime(String CommentTime) {
        this.CommentTime = CommentTime;
    }
}
