package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SuperVillan extends SuperPerson {

    public SuperVillan(String name, int health, int evilNees) {//We pass a powerLevel to parameter
        super(name, health);

        this.experiencePoints = evilNees;
        System.out.println("Muhaaa !!! " + this.name + " has arrived with a power level of " + evilNees);

    }

    @Override
    public void fight(SuperPerson opponent) {
        System.out.println("You haven't seen nothing yet!!! says " + this.name);

        int damageAmount = new Random().nextInt(21); // 0 to 20
        if (damageAmount > 0) {
            int totalDamage = damageAmount + this.experiencePoints;
            if (!inventory.isEmpty()) {
                //create a new list of just the keys from the HashMap (glove, hammer, etc....)
                List<String> items = new ArrayList<>(inventory.keySet());

                //get a random item name from the above list we just made and store it in random Item
                String randomItem = items.get(new Random().nextInt(items.size()));

                //get the point value for that item from the inventory HashMap
                //bonus would be the int that represents the damage the item will do.
                totalDamage += inventory.get(randomItem);
                inventory.remove(randomItem);// => this will make the key,value be used only once
            }
            opponent.takeDamage(totalDamage);
            System.out.println("Attack hits for " + totalDamage + " damage!");
            SupperApp.waitForEnter();

            if (!opponent.isAlive()) {
                System.out.println("Muhaaa " + opponent.name + " is defeated!");
                SupperApp.waitForEnter();
                System.out.println("Booya!!! GAME OVER!!!! Muhaaaaa!!!");
                //  End the game completely
            }
            System.out.println("feewwweeee!!! You live another day...");
            logHit(opponent);

        }


    }

  /*  @Override
    public String getType() {

        //return "SuperVillain";
        return this.getClass().getSimpleName();
    }*/
}
