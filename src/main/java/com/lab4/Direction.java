package com.lab4;

import java.util.*;

public enum Direction {
    UP, UP_RIGHT, RIGHT, RIGHT_DOWN, DOWN, LEFT_DOWN, LEFT, UP_LEFT;


    private static final Map<String, Direction[]> reverseDirectionsMass;
    static {
        Direction[] up = new Direction[]{DOWN, LEFT_DOWN, RIGHT_DOWN};
        Direction[] up_right = new Direction[]{LEFT, LEFT_DOWN, DOWN};
        Direction[] right = new Direction[]{UP_LEFT, LEFT, LEFT_DOWN,};
        Direction[] right_down = new Direction[]{UP, UP_LEFT, LEFT,};
        Direction[] down = new Direction[]{UP_RIGHT, UP, UP_LEFT};
        Direction[] left_down = new Direction[]{UP_RIGHT, UP, RIGHT};
        Direction[] left = new Direction[]{UP_RIGHT, RIGHT, RIGHT_DOWN};
        Direction[] up_left = new Direction[]{RIGHT, RIGHT_DOWN, DOWN};
        reverseDirectionsMass = new HashMap<>();
        reverseDirectionsMass.put("up", up);
        reverseDirectionsMass.put("up_right", up_right);
        reverseDirectionsMass.put("right", right);
        reverseDirectionsMass.put("right_down", right_down);
        reverseDirectionsMass.put("down", down);
        reverseDirectionsMass.put("left_down", left_down);
        reverseDirectionsMass.put("left", left);
        reverseDirectionsMass.put("up_left", up_left);

    }

    private static Direction[] getReverseMass(Direction direction){
        String name = direction.name().toLowerCase();
        return reverseDirectionsMass.get(name);
    }

    private static Direction getRandomFromMass(Direction[] directions){
        return directions[new Random().nextInt(directions.length)];
    }

    public static int getXModifier(Direction direction){
        switch (direction){
            case UP:
                return 0;
            case DOWN:
                return 0;
            case LEFT:
                return -1;
            case RIGHT:
                return 1;
            case UP_LEFT:
                return -1;
            case UP_RIGHT:
                return 1;
            case LEFT_DOWN:
                return -1;
            case RIGHT_DOWN:
                return 1;
        }
        return 0;
    }

    public static int getYModifier(Direction direction){
        switch (direction){
            case UP:
                return -1;
            case DOWN:
                return 1;
            case LEFT:
                return 0;
            case RIGHT:
                return 0;
            case UP_LEFT:
                return -1;
            case UP_RIGHT:
                return -1;
            case LEFT_DOWN:
                return 1;
            case RIGHT_DOWN:
                return 1;
        }
        return 0;
    }

    public static Direction getReverseRandomDirection(Direction current){
        return getRandomFromMass(Objects.requireNonNull(getReverseMass(current)));
    }
}
