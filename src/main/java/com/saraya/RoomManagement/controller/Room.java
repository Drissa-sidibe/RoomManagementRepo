package com.saraya.RoomManagement.controller;

import javax.persistence.*;

@Entity
@Table
public class Room {

    @Id
    @SequenceGenerator(
            name = "room_Sequence",
            sequenceName= "room_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="room_Sequence"
    )
    private int doorNumber;
    private int numberOfBeads;
    private  long roomPhone;


    public Room() {
    }

    public Room(int doorNumber, int numberOfBeads, long roomPhone) {
        this.doorNumber = doorNumber;
        this.numberOfBeads = numberOfBeads;
        this.roomPhone =roomPhone;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public int getNumberOfBeads() {
        return numberOfBeads;
    }

    public void setNumberOfBeads(int numberOfBeads) {
        this.numberOfBeads = numberOfBeads;
    }

    public long getRoomPhone() {
        return roomPhone;
    }

    public void setRoomPhone(long roomPhone) {
        this.roomPhone = roomPhone;
    }

    @Override
    public String toString() {
        return "Room{" +
                "doorNumber=" + doorNumber +
                ", numberOfBeads=" + numberOfBeads +
                ", roomPhone=" + roomPhone +
                '}';
    }
}
