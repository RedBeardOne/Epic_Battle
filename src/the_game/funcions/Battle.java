package the_game.funcions;

import the_game.character.Warrior;

public class Battle {
    public static boolean fight(Warrior warriorOne, Warrior warriorTwo) {
        while (warriorOne.isAlive() && warriorTwo.isAlive()) {
           warriorOne.attack(warriorTwo);
            if (warriorTwo.isAlive()) {
                warriorTwo.attack(warriorOne);
            }
        }
        return warriorOne.isAlive();
    }


    public static boolean fight(Army army1, Army army2) {
        while (true) {
            var attacker = army1.getFirstWarrior();
            if (attacker.isEmpty()) {
                return false;
            }
            var defender = army2.getFirstWarrior();
            if (defender.isEmpty()) {
                return true;
            }

            fight(attacker.get(), defender.get());
        }
    }
}
