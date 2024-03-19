package com.codecool.ftd.logic.air_movements;

import com.codecool.ftd.data.Drone;
import com.codecool.ftd.data.Position;
import com.codecool.ftd.logic.Movement;

public class UpMovement implements Movement {
    @Override
    public void move(Drone drone) {
        Position currentPosition = drone.getPosition();
        drone.setPosition(new Position(currentPosition.x(), currentPosition.y(), currentPosition.z() + 1));
        System.out.println("Drone moved Up. New position: " + drone.getPosition());
    }
}
