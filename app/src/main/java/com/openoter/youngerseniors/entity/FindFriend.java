package com.openoter.youngerseniors.entity;

/**
 * Created by asus on 2016/10/28.
 */

public class FindFriend {

    /**
     * Id : 1
     * UserName : Jhon
     * StartedSchool : 2014
     * Sex : 男
     * Experience : 1
     * University : 重庆邮电大学
     * Major : 会计
     * Avatar :
     */

    private String Id;
    private String UserName;
    private String StartedSchool;
    private String Sex;
    private int Experience;
    private String University;
    private String Major;
    private String Avatar;

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

    public String getStartedSchool() {
        return StartedSchool;
    }

    public void setStartedSchool(String StartedSchool) {
        this.StartedSchool = StartedSchool;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int Experience) {
        this.Experience = Experience;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String University) {
        this.University = University;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }
}
