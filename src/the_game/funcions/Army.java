package the_game.funcions;

import the_game.character.*;

import java.security.PublicKey;
import java.util.*;
import java.util.function.Predicate;

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
        moveUnits();
        return this;
    }

    public Army addUnits(Warrior unit) {
        units.add(unit);
        this.buildInColumn();
        moveUnits();
        return this;

    }

    public Optional<Warrior> getFirstWarrior() {
        return units.stream().filter(Warrior::isAlive).findFirst();
    }


    public static Army straightFormation(Army army) {
        Iterator<Warrior> iterator = army.units.iterator();
        while (iterator.hasNext()) {
            Warrior warrior = iterator.next();
            warrior.setInFront(null);
            warrior.setBehind(null);
        }
        return army;
    }

    public void buildInColumn() {
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
    }

    public static void buryTheDead(List<Warrior> units) {
        Iterator<Warrior> iterator = units.iterator();
        while (iterator.hasNext()) {
            Warrior warrior = iterator.next();
            if (!warrior.isAlive()) {
                iterator.remove();
            }
        }
    }

    public Iterator<Warrior> iterator() {
        return getUnits().iterator();
    }

    private List<Warrior> getUnits() {
        return units;
    }

    private void moveUnits() {
        if (units.stream().anyMatch(Warlord.class::isInstance)) {
            units.sort(new Comparator<Warrior>() {
                @Override
                public int compare(Warrior o1, Warrior o2) {
                    if (o1 instanceof Warlord) {
                        return 1;
                    } else return -1;
                }
            });

            units.sort(new Comparator<Warrior>() {
                @Override
                public int compare(Warrior o1, Warrior o2) {
                    if (o1 instanceof Healer) {
                        return -1;
                    } else return 1;
                }
            });
            LinkedHashSet<Warrior> setArmy = new LinkedHashSet<>();
            setArmy.addAll(units);
            units.clear();
            units.addAll(setArmy);
        }
    }

    public void moveUnitsInBattle() {
        buryTheDead(units);
        LinkedHashSet<Warrior> temporary = new LinkedHashSet<>();
        Optional<Warrior> firstLancer = getFirstLancer();
        Optional<Warrior> anyOther = getAllOther();
        if (firstLancer.isPresent()) {
            temporary.add(firstLancer.get());
        } else if (anyOther.isPresent()) {
            temporary.add(anyOther.get());
        }
            temporary.addAll(units);
            units.clear();
            units.addAll(temporary);
            buildInColumn();

    }

    private Optional<Warrior> getFirstLancer() {
        return units.stream()
                .filter(p -> p instanceof Lancer)
                .findFirst();
    }

    private Optional<Warrior> getAllOther() {
        return units.stream().filter(p -> !(p instanceof Healer) && !(p instanceof Warlord)).findFirst();
    }

}