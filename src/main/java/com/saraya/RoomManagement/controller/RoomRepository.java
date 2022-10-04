package com.saraya.RoomManagement.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    //We are trying to get a room by the roomPhone.
   Optional<Room> findRoomByRoomPhone(Long roomPhone);

}
