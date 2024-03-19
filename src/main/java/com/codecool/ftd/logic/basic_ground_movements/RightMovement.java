package com.codecool.ftd.logic.basic_ground_movements;

import com.codecool.ftd.data.Drone;
import com.codecool.ftd.data.Position;
import com.codecool.ftd.logic.Movement;

public class RightMovement implements Movement {
    @Override
    public void move(Drone drone) {
        Position currentPosition = drone.getPosition();
        drone.setPosition(new Position(currentPosition.x(), currentPosition.y() + 1, currentPosition.z()));
        System.out.println("Drone moved Right. New position: " + drone.getPosition());
    }
}
