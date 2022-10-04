package com.saraya.RoomManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getRooms(){
        return roomService.retrieveRoom();
    }

    @RequestMapping
    public void addNewRoom( @RequestBody Room room){
        roomService.addRooms(room);
    }
    @DeleteMapping(path = "{doorNumber}")
    public void deleteRoom(@PathVariable("doorNumber") int doorNumber){
        roomService.deleteRoom(doorNumber);
    }

    @PutMapping(path = "{doorNumber}")
    public void updateRoom(
            @PathVariable("doorNumber") int doorNumber,
            @PathVariable(required = false) int numberOfBeads,
            @PathVariable (required = false) Long roomPhone){
        roomService.updateRoom(doorNumber);
    }
}
