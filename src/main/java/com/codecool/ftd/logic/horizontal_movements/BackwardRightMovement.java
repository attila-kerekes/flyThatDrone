package com.codecool.ftd.logic.horizontal_movements;

import com.codecool.ftd.data.Drone;
import com.codecool.ftd.data.Position;
import com.codecool.ftd.logic.Movement;

public class BackwardRightMovement implements Movement {
    @Override
    public void move(Drone drone) {
        Position currentPosition = drone.getPosition();
        drone.setPosition(new Position(currentPosition.x() - 1, currentPosition.y() + 1, currentPosition.z()));
        System.out.println("Drone moved Backward-Right. New position: " + drone.getPosition());
    }
}
