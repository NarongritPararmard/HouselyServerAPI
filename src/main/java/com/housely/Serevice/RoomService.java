package com.housely.Serevice;

import com.housely.Model.Room.Room;
import com.housely.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public Room findById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }
}
