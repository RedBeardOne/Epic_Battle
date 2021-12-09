package the_game.character;

import the_game.funcions.IAttackObserver;

public class Healer extends Warrior implements IAttackObserver {

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

    @Override
    public void setInFront(Warrior inFront) {
        super.setInFront(inFront);
        if (inFront != null) {
            inFront.setAttackObserve(this);
        }
    }

    @Override
    public void trackAttack(Warrior warrior) {
        this.healing();
    }

    private void healing() {
        var warriorInFront = getInFront();
        if (warriorInFront == null) {
            // no warriors in front
        } else if (warriorInFront.isAlive()) {
           warriorInFront.setHealth(Math.min(warriorInFront.getDefaultHealth(), warriorInFront.getHealth() + 2));
        } else if (!warriorInFront.isAlive()) {
            warriorInFront.setAttackObserve(null);
        }
    }
}
