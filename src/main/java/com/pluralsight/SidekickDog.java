package com.pluralsight;

public class SidekickDog implements Fightable {

    //assigned properties to this class

    private String name;
    private int health;
    private int barkPower;

    //Generate constructor

    public SidekickDog(String name, int health, int barkPower) {
        this.name = name;
        this.health = health;
        this.barkPower = barkPower;
    }

    //Implement the interface method it force us to do the method.

    @Override
    public boolean isAlive() {
        return health > 1;
    }

    @Override
    public String getStatus() {
        return this.name + "(SidekickDog) has " + this.health + " health left!";

    }

    @Override
    public void fight(SuperPerson opponent) {
        System.out.println("The Sidekick Dog Howell over the moon trying fighting you !!!");
        opponent.takeDamage(5);

    }

    //Generate getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBarkPower() {
        return barkPower;
    }

    public void setBarkPower(int barkPower) {
        this.barkPower = barkPower;
    }
}
