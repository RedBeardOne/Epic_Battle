package the_game.funcions;

import the_game.character.Warrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Army {
    private final List<Warrior> units = new ArrayList<>();

  public   Army addUnits(Class<? extends Warrior>unit, int count) {
        for (int i = 0; i < count; i++) {
            units.add(Warrior.of(unit.getSimpleName()));
            if (i > 0) {
                units.get(i - 1).setBehind(units.get(i));
            }
        }
        return this;
    }

    public Optional<Warrior> getFirstWarrior() {
        return units.stream().filter(Warrior::isAlive).findFirst();
    }
}