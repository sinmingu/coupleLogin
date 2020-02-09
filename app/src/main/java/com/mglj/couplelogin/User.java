package com.mglj.couplelogin;

public class User {

    String userID;
    String userPassword;
    String userName;
    String userSex;
    String userRoom;

    public User(String userID, String userPassword, String userName, String userSex, String userRoom) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userSex = userSex;
        this.userRoom = userRoom;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserRoom(String userRoom) {
        this.userRoom = userRoom;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserRoom() {
        return userRoom;
    }
}
