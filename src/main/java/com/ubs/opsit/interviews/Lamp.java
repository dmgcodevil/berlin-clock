package com.ubs.opsit.interviews;

import java.util.function.IntFunction;

/**
 * Represents sate and color of a lamp.
 * <p>
 * Created by dmgcodevil on 4/13/2015.
 */
public enum Lamp {

    YELLOW("Y"),
    RED("R"),
    OFF("O");

    private String shortcut;

    Lamp(String shortcut) {
        this.shortcut = shortcut;
    }

    public static IntFunction<String> off() {
        return val -> OFF.getShortcut();
    }

    public static IntFunction<String> red() {
        return val -> RED.getShortcut();
    }

    public static IntFunction<String> yellow() {
        return val -> YELLOW.getShortcut();
    }

    public String getShortcut() {
        return shortcut;
    }
}
