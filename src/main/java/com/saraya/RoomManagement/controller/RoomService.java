package com.saraya.RoomManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository=roomRepository;
    }
    public List<Room> retrieveRoom(){
        return roomRepository.findAll();
    }
//    public List<Room> getRooms(){
//        return List.of(
//                new Room(
//                        1,
//                        5
//                )
//        );
   // }
    @PostMapping()
    public void addRooms(@RequestBody Room room) {
        Optional<Room> roomByRoomPhoneOptional = roomRepository.findRoomByRoomPhone(room.getRoomPhone());

        if(roomByRoomPhoneOptional.isPresent())
        {
        throw new IllegalStateException("This contact already exists");
        }
        roomRepository.save(room);
        System.out.println(room);
    }

    public void deleteRoom(int doorNumber) {
        boolean exists = roomRepository.existsById(doorNumber);
        if(!exists){
            throw new IllegalStateException("This door Number "+ "does not exist");
        }
        roomRepository.deleteById(doorNumber);
    }

    @Transactional
    public void updateRoom(int doorNumber) {
        roomRepository.findById(doorNumber)
                .orElseThrow(()-> new IllegalStateException(
                "That door number" + doorNumber+ "does not exist")
        );
    }
}
