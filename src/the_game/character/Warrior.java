package the_game.character;

import the_game.funcions.IAttackCapable;
import the_game.funcions.IAttackObserver;
import the_game.funcions.Weapons;

public class Warrior implements IAttackCapable {
    private static int defaultHealthWarrior = 50;
    public static int defaultAttackWarrior = 5;
    private int health;
    private int attack;
    private Warrior inFront;
    private Warrior behind;
    private String weapon;
    private IAttackObserver attackObserve;
    private int healthDef;


    public Warrior() {
       this(defaultHealthWarrior, defaultAttackWarrior);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
        this.healthDef = health;
    }

    protected int getDefaultHealth() {
        return healthDef;
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
            case "Warlord" ->new Warlord();

            default -> throw new IllegalArgumentException("Unknown Warrior type: " + clazz);
        };
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected void setAttack(int attack) {
        this.attack = attack;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
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


    public void equipWeapon(Weapons weapons) {
        setHealth(this.health + weapons.getHealth());
        setAttack(this.attack + weapons.getAttack());
        setWeapon(" equipped with " +weapons.getClass().getSimpleName());
    }
}
