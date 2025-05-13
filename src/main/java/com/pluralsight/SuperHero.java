package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
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
        System.out.println(this.name + " has Arrived with a Power Level of " + powerLevel);
    }

    //annotation to update a method on the parent class
    @Override
    public void fight(SuperPerson opponent) {
        System.out.println("What!!! you got something to say!!!? said " + this.name);
        SupperApp.waitForEnter();

        //make the hero do a random amount of damage to the opponent.
        //the damage should be a random number plus the experiencePoints(powerLevel)
        //if the base damage (without the xp) was 0, don't do any damage and just say missed
        //else deal the damage and say about being on the winning side

        int damageAmount = new Random().nextInt(21);//damage amount is bn 0-21 not 0
        if (!inventory.isEmpty()) {
            //create a new list of just the keys from the HashMap (glove, hammer, etc....)
            List<String> items = new ArrayList<>(inventory.keySet());

            //get a random item name from the above list we just made and store it in randomeItem
            String randomItem = items.get(new Random().nextInt(items.size()));

            //get the point value for that item from the inventory HashMap
            //bonuse would be the int that represents the damage the item will do.
            damageAmount += inventory.get(randomItem);
            inventory.remove(randomItem);// => this will make the key,value be used only once
        }
        opponent.takeDamage(damageAmount + this.experiencePoints);

        //if(damageAmount == 0){
        // sout("Missed!!")}else{ //if(!damageAmount == 0){
        // int damageDone = damageAmount + this.experiencePoints;//store it in a variable to use
        //opponent.takeDamage(damageDone); // now the damage we take will be the damage above with xp.}}

        System.out.println(damageAmount == 0 ? "Missed!!! \n"  : "Winning side for this turn is \n" + this.name);
        if (damageAmount != 0) {
            int damageDone = damageAmount + this.experiencePoints;//store it in a variable to use
            opponent.takeDamage(damageDone); // now the damage we take will be the damage above with xp.}
        }
        logHit(opponent);
    }

    @Override
    public String getType() {
        return "SuperHero";
    }
}
