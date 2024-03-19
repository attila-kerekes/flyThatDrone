package com.codecool.ftd;

import com.codecool.ftd.data.Drone;
import com.codecool.ftd.data.Position;
import com.codecool.ftd.logic.MovementEngine;
import com.codecool.ftd.logic.air_movements.DownMovement;
import com.codecool.ftd.logic.air_movements.UpMovement;
import com.codecool.ftd.logic.basic_ground_movements.BackwardMovement;
import com.codecool.ftd.logic.basic_ground_movements.ForwardMovement;
import com.codecool.ftd.logic.basic_ground_movements.LeftMovement;
import com.codecool.ftd.logic.basic_ground_movements.RightMovement;
import com.codecool.ftd.logic.horizontal_movements.BackwardLeftMovement;
import com.codecool.ftd.logic.horizontal_movements.BackwardRightMovement;
import com.codecool.ftd.logic.horizontal_movements.ForwardLeftMovement;
import com.codecool.ftd.logic.horizontal_movements.ForwardRightMovement;
import com.codecool.ftd.ui.FlyThatDroneUi;
import com.codecool.ftd.ui.factory.MovementFactory;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Position startingPosition = new Position(0, 0, 0);
        Drone drone = new Drone(startingPosition);
        MovementEngine movementEngine = new MovementEngine();
        Scanner scanner = new Scanner(System.in);
        FlyThatDroneUi flyThatDroneUi = new FlyThatDroneUi(drone, movementEngine, scanner);

        MovementFactory.setMovement("FORWARD", new ForwardMovement());
        MovementFactory.setMovement("BACKWARD", new BackwardMovement());
        MovementFactory.setMovement("LEFT", new LeftMovement());
        MovementFactory.setMovement("RIGHT", new RightMovement());

        MovementFactory.setMovement("FORWARD-LEFT", new ForwardLeftMovement());
        MovementFactory.setMovement("FORWARD-RIGHT", new ForwardRightMovement());
        MovementFactory.setMovement("BACKWARD-LEFT", new BackwardLeftMovement());
        MovementFactory.setMovement("BACKWARD-RIGHT", new BackwardRightMovement());

        MovementFactory.setMovement("UP", new UpMovement());
        MovementFactory.setMovement("DOWN", new DownMovement());

        flyThatDroneUi.start();
    }
}
