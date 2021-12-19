package the_game;

import the_game.character.*;
import the_game.funcions.*;

public class Main {
    public static void main(String[] args) {
        Weapons sword = new Sword();
        Weapons shield = new Shield();
        Army myArmy = new Army();
        Warrior warrior = new Warrior();
        warrior.equipWeapon(sword);
        myArmy.addUnits(warrior);
        myArmy.addUnits(Warrior.class, 1)
                .addUnits(Lancer.class, 3)
                .addUnits(Defender.class, 1)
                .addUnits(Warlord.class, 1);

        Army enemyArmy = new Army();
        Warrior warlord = new Warlord();
        warlord.equipWeapon(shield);
        enemyArmy.addUnits(warlord)
                .addUnits(Warlord.class, 4)
                .addUnits(Vampire.class, 1)
                .addUnits(Rookie.class, 1)
                .addUnits(Knight.class, 1);
        var result = Battle.fight(myArmy, enemyArmy);
    }
}
