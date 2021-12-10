package the_game.funcions;

import the_game.character.Warrior;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

    public static boolean straightFight(Army one, Army two) {
        Army.straightFormation(one);
        Army.straightFormation(two);
        straightFight(one.getUnits(), two.getUnits());
        return one.getUnits().size() > 0;
    }

    private static boolean straightFight(List<Warrior> firstArmy, List<Warrior> secondArmy) {
        if (firstArmy.isEmpty() || secondArmy.isEmpty()) {
            return true;
        }
        ListIterator<Warrior> iteratorOne = firstArmy.listIterator();
        ListIterator<Warrior> iteratorTwo = secondArmy.listIterator();

        while (iteratorOne.hasNext() && iteratorTwo.hasNext()) {
            var warriorOne = iteratorOne.next();
            var warriorTwo = iteratorTwo.next();
            var fight = fight(warriorOne, warriorTwo);
            if (!warriorOne.isAlive()) {
                iteratorOne.remove();
            } else if (!warriorTwo.isAlive()) {
                iteratorTwo.remove();
            } else {
                throw new IllegalArgumentException();
            }
        }
        return straightFight(firstArmy, secondArmy);
    }
}

