package the_game.character;

public class Rookie extends Warrior{
    private static int defaultHealth = 60;
    private static int defaultAttack =  1;

    @Override
    protected int getDefaultHealth() {
        return defaultHealth;
    }

    public Rookie(){
        super(defaultHealth);
    }
    @Override
    public int getAttack() {
        return defaultAttack;
    }
}