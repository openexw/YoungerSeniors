package com.openoter.youngerseniors.entity;

/**
 * 好友分组
 */

public class FriendGroupEntity {

    /**
     * GroupId : 1
     * GroupName : 好像真的
     * FriendOnline : 3
     * FriendTotal : 20
     */

    private String GroupId;
    private String GroupName;
    private int FriendOnline;
    private int FriendTotal;

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String GroupId) {
        this.GroupId = GroupId;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    public int getFriendOnline() {
        return FriendOnline;
    }

    public void setFriendOnline(int FriendOnline) {
        this.FriendOnline = FriendOnline;
    }

    public int getFriendTotal() {
        return FriendTotal;
    }

    public void setFriendTotal(int FriendTotal) {
        this.FriendTotal = FriendTotal;
    }
}
