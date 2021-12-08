package the_game;

import the_game.character.*;
import the_game.funcions.Army;
import the_game.funcions.Battle;

public class Main {
    public static void main(String[] args) {
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Lancer.class, 1);

        enemyArmy.addUnits(Warrior.class, 1);
        enemyArmy.addUnits(Knight.class, 1);


        System.out.println(Battle.fight(myArmy, enemyArmy));
    }
}
