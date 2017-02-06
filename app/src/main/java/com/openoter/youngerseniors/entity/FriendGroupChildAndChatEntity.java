package com.openoter.youngerseniors.entity;

/**
 * 好友分组
 */

public class FriendGroupChildAndChatEntity {

    /**
     * UserId : 234
     * GroupId : 1
     * UserName : 好像真的
     * Avatar :
     * lastMsg :
     */

    private String UserId;
    private String GroupId;
    private String UserName;
    private String Avatar;
    private String lastMsg;
    private long lastSendTime;

    public long getLastSendTime() {
        return lastSendTime;
    }

    public void setLastSendTime(long lastSendTime) {
        this.lastSendTime = lastSendTime;
    }



    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String GroupId) {
        this.GroupId = GroupId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }
}
