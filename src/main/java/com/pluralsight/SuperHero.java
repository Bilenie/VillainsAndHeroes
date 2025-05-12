package com.pluralsight;

import java.util.Random;

//create an identical person similar to superPerson class copy of each other
public class SuperHero extends SuperPerson {

    public SuperHero(String name, int health, int powerLevel) {//We pass a powerLevel to parameter
        super(name, health);
// this.name= "timmy";
// if the attribute access is protected we have access to it but if its private we won't be able to access
//override methods of SuperPerson class=> polymorphism
        // we did this just to be different
        this.experiencePoints = powerLevel;
        System.out.println(this.name + " has arrived with a power level of " + powerLevel);
    }
    //annotation to update a method on the parent class
    @Override
    public void fight(SuperPerson opponent) {
        System.out.println("what!!! you got something to say!!!? says" + this.name);

        //make the hero do a random amount of damage to the opponent.
        //the damage should be a random number plus the experiencePoints(powerLevel)
        //if the base damage (without the xp) was 0, don't do any damage and just say missed
        //else deal the damage and say about being on the winning side

        int damageAmount = new Random().nextInt(21);//damage amount is bn 0-21 not 0
        opponent.takeDamage(damageAmount + this.experiencePoints);

        //if(damageAmount == 0){
        // sout("Missed!!")}else{ //if(!damageAmount == 0){
        // int damageDone = damageAmount + this.experiencePoints;//store it in a variable to use
        //opponent.takeDamage(damageDone); // now the damage we take will be the damage above with xp.}}

        System.out.println(damageAmount == 0 ? " Missed!!! " : "Winning side is " +this.name);
        if (damageAmount != 0) {
            int damageDone = damageAmount + this.experiencePoints;//store it in a variable to use
            opponent.takeDamage(damageDone); // now the damage we take will be the damage above with xp.}
        }
    }
}
