package the_game.character;

import the_game.funcions.IAttackObserver;

public class Healer extends Warrior implements IAttackObserver {

    private static final int defaultHealth = 60;
    private static final int defaultAttack = 0;
    private static final int heal = 2;

    @Override
    protected int getDefaultHealth() {
        return defaultHealth;
    }

    public Healer() {
        super(defaultHealth);
    }

    @Override
    public int getAttack() {
        return defaultAttack;
    }

    @Override
    public void setInFront(Warrior inFront) {
        super.setInFront(inFront);
        if (inFront != null) {
            inFront.setAttackObserve(this);
        }
    }

    @Override
    public void traceAttack(Warrior warrior) {
        this.healing();
    }

    private void healing() {
        var warriorInFront = getInFront();
        var health = warriorInFront.getDefaultHealth();
        if (warriorInFront == null) {
        } else if (warriorInFront.isAlive()) {
           warriorInFront.setHealth(Math.min(health, warriorInFront.getHealth() + heal));
        } else if (!warriorInFront.isAlive()) {
            warriorInFront.setAttackObserve(null);
        }
    }
}
