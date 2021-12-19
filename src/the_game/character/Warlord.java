package the_game.character;

public class Warlord extends Defender {
    private static int defaultHealthWarlord = 100;
    private static int defaultAttackWarlord = 4;
    private static int defaultDefenceWarlord = 2;
    int parametersToEqual = 1;




    public Warlord() {
        super(defaultHealthWarlord, defaultAttackWarlord, defaultDefenceWarlord);
    }

    protected Warlord(int health, int attack, int defence) {
        super(health, attack, defence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass().getName() == o.getClass().getName()) return true;
        return false;
    }
    @Override
    public int hashCode() {
        return parametersToEqual;
    }
}
