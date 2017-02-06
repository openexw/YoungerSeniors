package com.openoter.youngerseniors.entity;

/**
 * Created by asus on 2016/10/25.
 */

public class TopicRewardEntity {

    /**
     * Id : 1
     * UserName : Jhon
     * PublishTime : 20分钟前
     * IsMine : 1
     * HelpFriendCount : 10
     * MaiDouNum : 7
     * MsgContent : 这种鹿一辈子只能下地一次
     * ViewTimes : 10
     * CommentTimes : 2
     */

    private String Id;
    private String UserName;
    private String PublishTime;
    private int IsMine;
    private String HelpFriendCount;
    private String MaiDouNum;
    private String MsgContent;
    private String ViewTimes;
    private String CommentTimes;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPublishTime() {
        return PublishTime;
    }

    public void setPublishTime(String PublishTime) {
        this.PublishTime = PublishTime;
    }

    public int getIsMine() {
        return IsMine;
    }

    public void setIsMine(int IsMine) {
        this.IsMine = IsMine;
    }

    public String getHelpFriendCount() {
        return HelpFriendCount;
    }

    public void setHelpFriendCount(String HelpFriendCount) {
        this.HelpFriendCount = HelpFriendCount;
    }

    public String getMaiDouNum() {
        return MaiDouNum;
    }

    public void setMaiDouNum(String MaiDouNum) {
        this.MaiDouNum = MaiDouNum;
    }

    public String getMsgContent() {
        return MsgContent;
    }

    public void setMsgContent(String MsgContent) {
        this.MsgContent = MsgContent;
    }

    public String getViewTimes() {
        return ViewTimes;
    }

    public void setViewTimes(String ViewTimes) {
        this.ViewTimes = ViewTimes;
    }

    public String getCommentTimes() {
        return CommentTimes;
    }

    public void setCommentTimes(String CommentTimes) {
        this.CommentTimes = CommentTimes;
    }
}
