package me.learning.robotmovement;

public enum  Command {
    MOVE("MOVE"),
    LEFT("LEFT"),
    RIGHT ("RIGHT"),
    STOP ("STOP"),
    REPORT("REPORT");

    private String value;
    Command(String value) {
        this.value = value;
    }
}
