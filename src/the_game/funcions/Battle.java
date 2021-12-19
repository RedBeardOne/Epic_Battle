package the_game.funcions;

import the_game.character.Warrior;

import java.util.Iterator;

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
            army1.moveUnitsInBattle();
            var attacker = army1.getFirstWarrior();
            if (attacker.isEmpty()) {
                return false;
            }
            army2.moveUnitsInBattle();
            var defender = army2.getFirstWarrior();
            if (defender.isEmpty()) {
                return true;
            }

            fight(attacker.get(), defender.get());
        }
    }

    public static boolean straightFight(Army one, Army two) {
        Army.straightFormation(one);
        Army.straightFormation(two);
        straightFightAux(one, two);
        if (one.getFirstWarrior().isPresent()) {
            one.buildInColumn();
        } else two.buildInColumn();
        return one.getFirstWarrior().isPresent();
    }

    private static boolean straightFightAux(Army one, Army two) {
        Iterator<Warrior> firstArmy = one.iterator();
        Iterator<Warrior> secondArmy = two.iterator();
        if (!firstArmy.hasNext() || !secondArmy.hasNext()) {
            return firstArmy.hasNext(); ///
        }
        while (firstArmy.hasNext() && secondArmy.hasNext()) {
            var warriorOne = firstArmy.next();
            var warriorTwo = secondArmy.next();
            var fight = fight(warriorOne, warriorTwo);
            if (!warriorOne.isAlive()) {
                firstArmy.remove();
            } else if (!warriorTwo.isAlive()) {
                secondArmy.remove();
            } else {
                throw new IllegalArgumentException();
            }
        }
        return straightFightAux(one, two);
    }
}

