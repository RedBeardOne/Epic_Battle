package the_game.funcions;

import the_game.character.Warrior;

import java.util.*;

public class Army {
    private final List<Warrior> units = new ArrayList<>();

    public Army addUnits(Class<? extends Warrior> unit, int count) {
        for (int i = 0; i < count; i++) {
            units.add(Warrior.of(unit.getSimpleName()));
        }
        for (int i = 0; i < units.size(); i++) {
            if (i == 0 && units.size() != 1) {
                units.get(i).setBehind(units.get(i + 1));
                units.get(i).setInFront(null);
            } else if (i > 0 && i < units.size() - 1) {
                units.get(i).setBehind(units.get(i + 1));
                units.get(i).setInFront(units.get(i - 1));
            } else if (i > 0 && i == units.size() - 1) {
                units.get(i).setBehind(null);
                units.get(i).setInFront(units.get(i - 1));
            }
        }
        return this;
    }

    public Optional<Warrior> getFirstWarrior() {
        return units.stream().filter(Warrior::isAlive).findFirst();
    }
}