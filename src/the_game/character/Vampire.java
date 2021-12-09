package the_game.character;

public class Vampire extends Warrior{
    private static final int defaultHealth = 40;
    private static final int defaultAttack = 4;
    private static final int vampirism = 50;

    @Override
    protected int getDefaultHealth() {
        return defaultHealth;
    }

    public Vampire() {
        super(defaultHealth);
    }


    @Override
    public int getAttack() {
        return defaultAttack;
    }

    @Override
    public void attack(Warrior warrior) {
        int healthDecrease = warrior.getHealth();
        warrior.getDamageFrom(this);
        healthDecrease = healthDecrease - warrior.getHealth();
        setHealth(Math.min((getHealth() + healthDecrease * vampirism / 100), getDefaultHealth()));
        var observe = getAttackObserve();
        if (observe != null) {
            observe.traceAttack(this);
        }
    }
}