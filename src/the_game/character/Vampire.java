package the_game.character;

import the_game.funcions.Weapons;

public class Vampire extends Warrior {
    private static final int defaultHealthVampire = 40;
    private static final int defaultAttackVampire = 4;
    private static final int defaultVampirism = 50;
    private int vampirism;

    public Vampire() {
        super(defaultHealthVampire, defaultAttackVampire);
        vampirism = defaultVampirism;
    }


    @Override
    public void attack(Warrior warrior) {
        int healthDecrease = warrior.getHealth();
        warrior.getDamageFrom(this);
        healthDecrease = healthDecrease - warrior.getHealth();
        setHealth(Math.min((getHealth() + healthDecrease * getVampirism() / 100), getDefaultHealth()));
        var observe = getAttackObserve();
        if (observe != null) {
            observe.traceAttack(this);
        }
    }

    @Override
    public void equipWeapon(Weapons weapons) {
        setHealth(getHealth() + weapons.getHealth());
        setAttack(getAttack() + weapons.getAttack());
        setVampirism(Math.max(0, Math.min(100, vampirism + weapons.getVampirism())));
        setWeapon(" equipped with " + weapons.getClass().getSimpleName());
    }

    private int getVampirism() {
        return vampirism;
    }

    private void setVampirism(int vampirism) {
        this.vampirism = vampirism;
    }
}