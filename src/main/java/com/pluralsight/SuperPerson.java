package com.pluralsight;

import java.util.HashMap;
import java.util.Random;

public abstract class SuperPerson {
    //Protected properties can possibly be access by our children, grand children,etc...
    // and stay in the family
    protected String name;// children/subclass can access it
    protected int health;
    protected int experiencePoints;
    protected HashMap<String, Integer> battleLog = new HashMap<>();
    protected HashMap<String, Integer> inventory = new HashMap<>();



    //Generate constructor for the 2 properties then manual for exp
    public SuperPerson(String name, int health) {
        this.name = name;
        this.health = health;
        //default the exp to 0 we are not passing it in a parameter
        this.experiencePoints = 0;//manually add

    }

    // Method => for our superPerson to do

    public boolean isAlive() {
        /*if(this.health>0){
            return true;
        }
        return false;*/
        //if the health is greater than zero, return true, otherwise return false;
        return this.health > 0;
    }

   public abstract void fight(SuperPerson opponent);// => Abstract method

    public void takeDamage(int damageAmount) {
        //minus from health everytime attack happen, but below 0
        //damage shouldn't be less than 0
        this.health -= damageAmount;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    //track how they are doing
    public String getStatus() {
        //This track the name and health of the object we created(superPerson or Opponent).
        return this.name + " has " + this.health + " health left!";
    }

    //update the log entry for our SuperPerson
    public void logHit(SuperPerson opponent) {
        String name = opponent.name;
        int count = battleLog.getOrDefault(name, 0);
        battleLog.put(name, count + 1);
    }

    //print the battle log for a SuperPerson
    public void printBattleLog() {
        System.out.println("Battle log for " + name + ":");
        for (HashMap.Entry<String, Integer> entry : battleLog.entrySet()) {
            System.out.println(" - Hit " + entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

    public void addPowerUp( String item , int value){
        inventory.put(item , value);
    }
   public int getPowerBonus( String item) {
//        //initialize the bonus damage from something

//        //return 0 if the hashmap inventory doesn't contain the name
//        //then get the name from the inventory and store it in a variable
//
//    }
   }
}
