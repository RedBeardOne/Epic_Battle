package the_game;

import the_game.character.*;
import the_game.funcions.Army;
import the_game.funcions.Battle;

public class Main {
    public static void main(String[] args) {
        Army army_1 = new Army()
                .addUnits(Lancer.class, 1)
            .addUnits(Lancer.class, 1);

        Army army_2 = new Army()

                .addUnits(Warrior.class, 1)
                .addUnits(Knight.class, 1)
                .addUnits(Knight.class, 1);

        System.out.println(Battle.fight(army_1, army_2));


    }
}
