package the_game.character;

import the_game.funcions.IAttackCapable;

public class Defender extends Warrior {

    private static int defaultHealth = 60;
    private static int defence = 2;
    private static int defaultAttack = 3;

    @Override
    protected int getDefaultHealth() {
        return defaultHealth;
    }

    public Defender() {
        super(defaultHealth);
    }

    @Override
    public int getAttack() {
        return defaultAttack;
    }

    @Override
    public void getDamageFrom(IAttackCapable warrior) {
        setHealth(getHealth() - Math.max(0, warrior.getAttack() - defence));
    }
}