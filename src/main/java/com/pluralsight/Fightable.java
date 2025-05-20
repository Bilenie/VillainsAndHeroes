package com.pluralsight;

public interface Fightable {
    //Method by default are public so we don't need to say public
    //add methods for fight , isAlive,getStatus
    void fight(SuperPerson opponent);
    boolean isAlive();
    String getStatus();
}
