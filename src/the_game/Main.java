package the_game;

import the_game.character.Defender;
import the_game.character.Lancer;
import the_game.character.Vampire;
import the_game.character.Warrior;
import the_game.funcions.Army;
import the_game.funcions.Battle;

public class Main {
    public static void main(String[] args) {
        Army army_1 = new Army()
                .addUnits(Lancer.class, 5)
                .addUnits(Vampire.class, 3)
                .addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 2);
        Army army_2 = new Army()
                .addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 4)
                .addUnits(Vampire.class, 6)
                .addUnits(Lancer.class, 5);

        System.out.println(Battle.fight(army_1, army_2));
    }
}
