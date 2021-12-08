package the_game.character;

public class Healer extends Warrior {

    private static final int defaultHealth = 60;
    private static final int defaultAttack = 0;
    private static final int heal = 2;

    public Healer() {
        super(defaultHealth);
    }

    @Override
    public int getAttack() {
        return defaultAttack;
    }

    public void healing(Warrior warrior) {
        if (warrior.isAlive()) {
            setHealth(Math.min(warrior.getDefaultHealth(), warrior.getHealth() + 2));
        }
    }
}
