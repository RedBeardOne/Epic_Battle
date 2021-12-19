package the_game.character;

import the_game.funcions.IAttackCapable;
import the_game.funcions.Weapons;

public class Defender extends Warrior {

    private static int defaultHealthDefender = 60;
    private static int defaultDefence = 2;
    private static int defaultAttackDefender = 3;
    private int defence;

    public Defender() {
        super(defaultHealthDefender, defaultAttackDefender);
        defence = defaultDefence;
    }

    protected Defender(int health, int attack, int defence) {
        super(health, attack);
        this.defence = defence;
    }

    @Override
    public void getDamageFrom(IAttackCapable warrior) {
        setHealth(getHealth() - Math.max(0, warrior.getAttack() - getDefence()));
    }

    @Override
    public void equipWeapon(Weapons weapons) {
        setHealth(getHealth() + weapons.getHealth());
        setAttack(getAttack() + weapons.getAttack());
        setDefence(getDefence() + weapons.getDefence());
        setWeapon(" equipped with " + weapons.getClass().getSimpleName());
    }

    private int getDefence() {
        return defence;
    }

    private void setDefence(int defence) {
        this.defence = defence;
    }
}