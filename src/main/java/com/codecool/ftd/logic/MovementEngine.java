package com.codecool.ftd.logic;

import com.codecool.ftd.data.Drone;
import com.codecool.ftd.ui.factory.MovementFactory;

import java.util.ArrayList;
import java.util.List;

public class MovementEngine {

    public void move(Drone drone, String command) {
        Movement movement = MovementFactory.getMovement(command);
        if (movement != null) {
            movement.move(drone);
        } else {
            System.out.println("Invalid command.");
        }
    }

    public List<String> getCommands() {
        List<String> availableCommands = new ArrayList<>(MovementFactory.getRegisteredCommands());
        if (availableCommands.isEmpty()) {
            availableCommands.add("No available commands yet.");
        }
        return availableCommands;
    }
}
