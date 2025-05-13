package com.pluralsight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SuperPerson {
    //Protected properties can possibly be access by our children, grand children,etc...
    // and stay in the family
    protected String name;// children/subclass can access it
    protected int health;
    protected int experiencePoints;
    private Map<String, Integer> battleLog = new HashMap<>();


    //Generate constructor for the 2 properties then manual for exp
    public SuperPerson(String name, int health) {
        this.name = name;
        this.health = health;
        //default the exp to 0 we are not passing it in a parameter
        this.experiencePoints = 0;//manually add
    }

    // Method => for our superPerson to do
//update the log entry for our SuperPerson
    public void logHit(SuperPerson opponent) {
        String name = opponent.name;
        int count = battleLog.getOrDefault(name, 0);
        battleLog.put(name, count + 1);
    }

    //print the battle log for a SuperPerson
    public void printBattleLog() {
        System.out.println("Battle log for " + name + ":");
        for (Map.Entry<String, Integer> entry : battleLog.entrySet()) {
            System.out.println(" - Hit " + entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

    public boolean isAlive(){
        /*if(this.health>0){
            return true;
        }
        return false;*/
        //if the health is greater than zero, return true, otherwise return false;
        return this.health>0;
    }

    public void fight(SuperPerson opponent){
        //instead of 15 points do Random amount of damage
        int damageAmount = new Random().nextInt(21);//return number bn o & 21.

        //as a placeholder for now we print out who we are fighting
        System.out.println(this.name + " is fighting" + opponent.name );
        opponent.takeDamage(damageAmount + this.experiencePoints);// have adv if you hav exp.
        // opponent.takeDamage(15) everytime fight happen take 15 points off

    }

    public void takeDamage(int damageAmount){
        //minus from health everytime attack happen, but below 0
        //damage shouldn't be less than 0
        this.health -= damageAmount;
        if(this.health<0){
            this.health = 0;
        }
    }

    //track how they are doing
    public String getStatus(){

        //This track the name and health of the object we created(superPerson or Opponent).
        return this.name + " has " + this.health + " health left!" ;
    }
    //generate getter

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }
}
