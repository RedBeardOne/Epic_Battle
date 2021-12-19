package the_game.character;

import the_game.funcions.IAttackObserver;
import the_game.funcions.Weapons;

public class Healer extends Warrior implements IAttackObserver {

    private static final int defaultHealth = 60;
    private static final int defaultAttack = 0;
    private static final int defaultHeal = 2;
    private int heal;

    public Healer() {
        super(defaultHealth, defaultAttack);
        this.heal = defaultHeal;
    }


    @Override
    public void setInFront(Warrior inFront) {
        super.setInFront(inFront);
        if (inFront != null) {
            inFront.setAttackObserve(this);
        }
    }

    @Override
    public void equipWeapon(Weapons weapons) {
        setHealth(getHealth() + weapons.getHealth());
        setAttack(getAttack() + weapons.getAttack());
        setHealth(getHeal() + weapons.getHeal());
        setWeapon(" equipped with " + weapons.getClass().getSimpleName());
    }

    @Override
    public void traceAttack(Warrior warrior) {
        this.healing();
    }

    private void healing() {
        var warriorInFront = getInFront();
        int health = warriorInFront == null ? 0 : warriorInFront.getDefaultHealth();
        if (warriorInFront!=null && warriorInFront.isAlive() ) {
            warriorInFront.setHealth(Math.min(health, warriorInFront.getHealth() + getHeal()));
        } else if (warriorInFront!=null && !warriorInFront.isAlive()) {
            warriorInFront.setAttackObserve(null);
        }
    }

    private int getHeal() {
        return heal;
    }

    private void setHeal(int heal) {
        this.heal = heal;
    }


}
