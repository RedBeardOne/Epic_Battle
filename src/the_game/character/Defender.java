package the_game.character;

import the_game.funcions.IAttackCapable;

public class Defender extends Warrior {

    private static int health = 60;
    private static int defence = 2;
    private static int attack = 3;

    public Defender() {
        super(health);
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void getDamageFrom(IAttackCapable warrior) {
        setHealth(getHealth() - Math.max(0, warrior.getAttack() - defence));
    }
}