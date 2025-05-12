package com.pluralsight;

import java.util.Scanner;

public class SupperApp {
    public static void main(String[] args) {


        // Create a hero object with a name, health, and powerLevel
        SuperHero superJoy = new SuperHero("Joys", 100, 100);

        // Create a villain object with a name, health, and evilness
        SuperVillan superEvil = new SuperVillan("Demon", 100, 100);

        // Display an introduction message
        System.out.println(" Welcome to this Realm of WarZone!!!");
        // Show the starting status of both characters
        superJoy.getStatus();
        superEvil.getStatus();

        // Loop while both the hero and villain are still alive
        while (true) {
            if (superJoy.isAlive() && superEvil.isAlive()) {
                System.out.println("Let the Game begin!!!");
            }
            waitForEnter();
            // Indicate the hero's turn
            System.out.println("Game starts with " + superJoy.name);

            // Have the hero fight the villain
            superJoy.fight(superEvil);

            // Show the villain's updated status
            superEvil.getStatus();

            // If the villain is no longer alive, break the loop
            if (!superEvil.isAlive()) {
                break;
            }
            // Indicate the villain's turn
            System.out.println("Game starts with " + superEvil.name);
            waitForEnter();

            // Have the villain fight the hero
            superEvil.fight(superJoy);

            // Show the hero's updated status
            superJoy.getStatus();

            // End of loop
        }
        // Display a message that the battle is over
        System.out.println("Game Over!!!");

        // If the hero is still alive
        if (superJoy.isAlive() && !superEvil.isAlive()) {
            System.out.println("The Winner is " + superJoy.name);// Announce the hero as the winner
        } else {
            System.out.println("The Winner is " + superEvil.name);// Otherwise => Announce the villain as the winner
        }

    }
    //Method waits until user presses Enter gives control to user.
    public static void waitForEnter () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}

 /*
  //instantiate object = > 2 people to make them fight
   SuperPerson trueHero = new SuperPerson("God",100);
   SuperPerson wanBeButNothing = new SuperPerson("Devil",10);
   SuperHero superSpirit = new SuperHero( "HolySpirit",100,100);
   SuperVillan superEvil= new SuperVillan( "Demons",100,10);

  System.out.println(superSpirit.getStatus());
        System.out.println(superEvil.getStatus());

        //object.getStatus() on both=> to see how they are doing
        System.out.println(trueHero.getStatus());
        System.out.println( wanBeButNothing.getStatus());

        //object take damages one 15 , other 20
        trueHero.takeDamage(0);
        wanBeButNothing.takeDamage(100);
        superEvil.takeDamage(100);

//then ask how they are doing
        System.out.println(trueHero.getStatus());
        System.out.println( wanBeButNothing.getStatus());
        System.out.println(superEvil.getStatus());

        //then make them fight object.fight(opponent) and the other way.
        // opponent become whatever we pass ,depending on who is fighting who

        trueHero.fight(wanBeButNothing);
        wanBeButNothing.fight(trueHero);

        superEvil.fight(wanBeButNothing);
        superSpirit.fight(wanBeButNothing);

//then ask how they are doing*
        System.out.println( wanBeButNothing.getStatus());
        System.out.println(superEvil.getStatus());*/