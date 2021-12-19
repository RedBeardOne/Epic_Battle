package the_game.funcions;

public class Weapons {
    int health;
    int attack;
    int defence;
    int vampirism;
    int heal;

    public Weapons(int health, int attack, int defence, int vampirism, int heal) {
        this.health = health;
        this.attack = attack;
        this.defence = defence;
        this.vampirism = vampirism;
        this.heal = heal;
    }

    public static Builder builder() {
        return new Builder();
    }



        public static class Builder {
            int health = 0;
            int attack = 0;
            int defence = 0;
            int vampirism = 0;
            int heal = 0;
        public Builder health(int value) {
            health = value;
            return this;
        }

        public Builder attack(int value) {
            attack = value;
            return this;
        }

        public Builder defence(int value) {
            defence = value;
            return this;
        }

        public Builder vampirism(int value) {
            vampirism = value;
            return this;
        }

        public Builder heal(int value) {
            heal = value;
            return this;
        }

        public Weapons build() {
            return new Weapons(health, attack, defence, vampirism, heal);
        }
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getVampirism() {
        return vampirism;
    }

    public int getHeal() {
        return heal;
    }
}
