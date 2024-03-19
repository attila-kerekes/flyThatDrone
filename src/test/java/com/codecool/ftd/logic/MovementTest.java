package com.codecool.ftd.logic;

import com.codecool.ftd.data.Drone;
import com.codecool.ftd.data.Position;
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
import com.codecool.ftd.ui.factory.MovementFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class MovementTest {

    public static Stream<Arguments> parameters() {
        return Stream.of(
                // Sprint #1
                of(new Position(1, 0, 0), new Position(0, 0, 0), "FORWARD"),
                of(new Position(2, 0, 0), new Position(1, 0, 0), "FORWARD"),
                of(new Position(0, 0, 0), new Position(-1, 0, 0), "FORWARD"),

                of(new Position(-1, 0, 0), new Position(0, 0, 0), "BACKWARD"),
                of(new Position(-2, 0, 0), new Position(-1, 0, 0), "BACKWARD"),
                of(new Position(0, 0, 0), new Position(1, 0, 0), "BACKWARD"),

                of(new Position(0, -1, 0), new Position(0, 0, 0), "LEFT"),
                of(new Position(0, -2, 0), new Position(0, -1, 0), "LEFT"),
                of(new Position(0, 0, 0), new Position(0, 1, 0), "LEFT"),

                of(new Position(0, 1, 0), new Position(0, 0, 0), "RIGHT"),
                of(new Position(0, 2, 0), new Position(0, 1, 0), "RIGHT"),
                of(new Position(0, 0, 0), new Position(0, -1, 0), "RIGHT"),

                // Sprint #2
                of(new Position(1, -1, 0), new Position(0, 0, 0), "FORWARD-LEFT"),
                of(new Position(2, -2, 0), new Position(1, -1, 0), "FORWARD-LEFT"),
                of(new Position(0, 0, 0), new Position(-1, 1, 0), "FORWARD-LEFT"),

                of(new Position(1, 1, 0), new Position(0, 0, 0), "FORWARD-RIGHT"),
                of(new Position(2, 2, 0), new Position(1, 1, 0), "FORWARD-RIGHT"),
                of(new Position(0, 0, 0), new Position(-1, -1, 0), "FORWARD-RIGHT"),

                of(new Position(-1, -1, 0), new Position(0, 0, 0), "BACKWARD-LEFT"),
                of(new Position(-2, -2, 0), new Position(-1, -1, 0), "BACKWARD-LEFT"),
                of(new Position(0, 0, 0), new Position(1, 1, 0), "BACKWARD-LEFT"),

                of(new Position(-1, 1, 0), new Position(0, 0, 0), "BACKWARD-RIGHT"),
                of(new Position(-2, 2, 0), new Position(-1, 1, 0), "BACKWARD-RIGHT"),
                of(new Position(0, 0, 0), new Position(1, -1, 0), "BACKWARD-RIGHT"),

                // Sprint #3
                of(new Position(0, 0, 1), new Position(0, 0, 0), "UP"),
                of(new Position(0, 0, 2), new Position(0, 0, 1), "UP"),
                of(new Position(0, 0, 0), new Position(0, 0, -1), "UP"),

                of(new Position(0, 0, -1), new Position(0, 0, 0), "DOWN"),
                of(new Position(0, 0, -2), new Position(0, 0, -1), "DOWN"),
                of(new Position(0, 0, 0), new Position(0, 0, 1), "DOWN")
        );
    }


    @ParameterizedTest
    @MethodSource("parameters")
    void move(Position expected, Position current, String command) {

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

        Drone drone = new Drone(current);

        MovementEngine movementEngine = new MovementEngine();

        movementEngine.move(drone, command);

        Position result = drone.getPosition();

        assertEquals(expected, result);
    }

}
