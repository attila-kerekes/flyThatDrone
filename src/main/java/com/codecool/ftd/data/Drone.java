package com.codecool.ftd.data;

public class Drone {
    private Position position;

    public Drone(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
