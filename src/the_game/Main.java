package the_game;

import the_game.character.*;
import the_game.funcions.Army;
import the_game.funcions.Battle;

public class Main {
    public static void main(String[] args) {
        Army myArmy = new Army();
        Army enemyArmy = new Army();

        myArmy.addUnits(Warrior.class, 1);
        myArmy.addUnits(Lancer.class, 1);
        myArmy.addUnits(Healer.class, 1);
        myArmy.addUnits(Warrior.class, 1);


        enemyArmy.addUnits(Lancer.class, 4);
        enemyArmy.addUnits(Healer.class, 1);
        enemyArmy.addUnits(Defender.class, 2);
        enemyArmy.addUnits(Vampire.class, 3);
        enemyArmy.addUnits(Healer.class, 1);


        System.out.println(Battle.fight(myArmy, enemyArmy));
    }
}
