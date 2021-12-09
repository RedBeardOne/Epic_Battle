package the_game.character;

import the_game.funcions.IAttackCapable;
import the_game.funcions.IAttackObserver;

public class Warrior implements IAttackCapable {
    private static int defaultHealth = 50;
    private static int attack = 5;
    private int health;
    private Warrior inFront;
    private Warrior behind;
    private IAttackObserver attackObserve;




    protected Warrior(int health) {
        this.health = health;
    }

    protected int getDefaultHealth() {
        return defaultHealth;
    }

    public Warrior() {
        this.health = defaultHealth;
    }

    public static Warrior of(String clazz) {
        return switch (clazz) {
            case "Warrior" -> new Warrior();
            case "Rookie" -> new Rookie();
            case "Knight" -> new Knight();
            case "Defender" -> new Defender();
            case "Vampire" -> new Vampire();
            case "Lancer" -> new Lancer();
            case "Healer" -> new Healer();

            default -> throw new IllegalArgumentException("Unknown Warrior type: " + clazz);
        };
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public void getDamageFrom(IAttackCapable warrior) {
        setHealth(getHealth() - warrior.getAttack());
    }

    public void attack(Warrior warrior) {
        warrior.getDamageFrom(this);
        var observe = getAttackObserve();
        if (observe != null) {
            observe.traceAttack(this);
        }
    }

    public Warrior getBehind() {
        return behind;
    }

    public void setBehind(Warrior behind) {
        this.behind = behind;
    }

    public Warrior getInFront() {
        return inFront;
    }

    public void setInFront(Warrior inFront) {
        this.inFront = inFront;
    }

    protected IAttackObserver getAttackObserve() {
        return attackObserve;
    }

    protected void setAttackObserve(IAttackObserver attackObserve) {
        this.attackObserve = attackObserve;
    }

}