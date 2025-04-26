package com.vaishnavi.practice.spring.boot.service;

import com.vaishnavi.practice.spring.boot.model.Room;
import com.vaishnavi.practice.spring.boot.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, Room roomDetails) {
        Optional<Room> roomData = roomRepository.findById(id);

        if (roomData.isPresent()) {
            Room room = roomData.get();
            room.setRoomNumber(roomDetails.getRoomNumber());
            room.setType(roomDetails.getType());
            room.setOccupied(roomDetails.getOccupied());
            return roomRepository.save(room);
        } else {
            return null;
        }
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public void deleteAllRooms() {
        roomRepository.deleteAll();
    }

    public List<Room> findByType(String type) {
        return roomRepository.findByType(type);
    }
}



