package com.mglj.couplelogin;

public class Room {

    String roomNum;
    String roomName;
    String roomPass;
    String room_makeID;
    String room_intoID;
    String roomDate;

    public Room(String roomNum, String roomName, String roomPass, String room_makeID, String room_intoID, String roomDate) {
        this.roomNum = roomNum;
        this.roomName = roomName;
        this.roomPass = roomPass;
        this.room_makeID = room_makeID;
        this.room_intoID = room_intoID;
        this.roomDate = roomDate;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomPass(String roomPass) {
        this.roomPass = roomPass;
    }

    public void setRoom_makeID(String room_makeID) {
        this.room_makeID = room_makeID;
    }

    public void setRoom_intoID(String room_intoID) {
        this.room_intoID = room_intoID;
    }

    public void setRoomDate(String roomDate) {
        this.roomDate = roomDate;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomPass() {
        return roomPass;
    }

    public String getRoom_makeID() {
        return room_makeID;
    }

    public String getRoom_intoID() {
        return room_intoID;
    }

    public String getRoomDate() {
        return roomDate;
    }
}
