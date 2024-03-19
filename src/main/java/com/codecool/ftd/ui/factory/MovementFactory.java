package com.codecool.ftd.ui.factory;

import com.codecool.ftd.logic.Movement;
import com.codecool.ftd.logic.basic_ground_movements.BackwardMovement;
import com.codecool.ftd.logic.basic_ground_movements.ForwardMovement;
import com.codecool.ftd.logic.basic_ground_movements.LeftMovement;
import com.codecool.ftd.logic.basic_ground_movements.RightMovement;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MovementFactory {
    private static final Map<String, Movement> movements = new HashMap<>();

    public static void setMovement(String command, Movement movement) {
        movements.put(command, movement);
    }

    public static Movement getMovement(String command) {
        return movements.get(command.toUpperCase());
    }

    public static Set<String> getRegisteredCommands() {
        return movements.keySet();
    }
}
