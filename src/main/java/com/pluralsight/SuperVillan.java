package com.pluralsight;

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

        int damageAmount = new Random().nextInt(21); // 0 to 9
        if (damageAmount > 0) {
            int totalDamage = damageAmount + this.experiencePoints;
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

}
