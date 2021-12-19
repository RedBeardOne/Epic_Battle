package the_game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import the_game.character.*;
import the_game.funcions.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @DisplayName(" Testing warrior vs knight ")
    @Test
    void battleTestOne() {
        //arrange
        var carl = new Warrior();
        var jim = new Knight();

        //act
        Battle figth = new Battle();
        var result = figth.fight(carl, jim);

        //assert
        assertFalse(result);
    }

    @DisplayName(" Testing knight vs warrior")
    @Test
    void battleTestTwo() {
        //arrange
        var Petro = new Knight();
        var slewin = new Warrior();

        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(Petro, slewin);

        //assert
        assertTrue(resultSecond);
    }

    @DisplayName(" Testing warrior vs warriors ")
    @Test
    void battleTestThree() {
        //arrange
        var bob = new Warrior();
        var mars = new Warrior();

        //act
        Battle figth = new Battle();
        var result = figth.fight(bob, mars);

        //assert
        assertTrue(bob.isAlive());

    }

    @DisplayName(" Testing Zeus vs GodKiller")
    @Test
    void battleTestFour() {
        //arrange
        var zeus = new Knight();
        var godkiller = new Warrior();

        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(zeus, godkiller);

        //assert
        assertTrue(zeus.isAlive());
    }

    @DisplayName(" Testing husband vs wife ")
    @Test
    void battleTestFive() {
        //arrange
        var husband = new Warrior();
        var wife = new Warrior();

        //act
        Battle figth = new Battle();
        var result = figth.fight(husband, wife);

        //assert
        assertFalse(wife.isAlive());
    }

    @DisplayName(" Testing knight vs dragon ")
    @Test
    void battleTestSix() {
        //arrange
        var dragon = new Warrior();
        var knigth = new Knight();

        //act
        Battle figth = new Battle();
        var result = figth.fight(dragon, knigth);

        //assert
        assertTrue(knigth.isAlive());
    }

    @DisplayName(" Testing units ")
    @Test
    void battleTestSeven() {
        //arrange
        var unitOne = new Warrior();
        var unitTwo = new Knight();
        var unitThree = new Warrior();

        //act
        Battle figth = new Battle();
        var result = figth.fight(unitOne, unitTwo);
        var finalBattle = figth.fight(unitTwo, unitThree);

        //assert
        assertFalse(finalBattle);
    }

    @DisplayName(" Testing warrior vs two warriors ")
    @Test
    void battleTestArmyOneGit() {
        //arrange
        Army myArmy = new Army();
        myArmy.addUnits(Warrior.class, 1);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 2);


        //act

        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertFalse(result);
    }

    @DisplayName(" Testing two warriors vs three warriors ")
    @Test
    void battleTestArmyGit() {
        //arrange
        Army myArmy = new Army();
        myArmy.addUnits(Warrior.class, 2);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 3);

        //act
        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertFalse(result);
    }

    @DisplayName(" Testing 5 warriors vs 7 warriors ")
    @Test
    void battleTestArmyThreeGit() {
        //arrange
        Army myArmy = new Army();
        myArmy.addUnits(Warrior.class, 5);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 7);

        //act

        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertFalse(result);
    }

    @DisplayName(" Testing 20 warriors vs 21 warriors ")
    @Test
    void battleTestArmyFourGit() {
        //arrange
        Army myArmy = new Army();
        myArmy.addUnits(Warrior.class, 20);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 21);

        //act
        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertTrue(result);
    }

    @DisplayName(" Testing 10 warriors vs 11 warriors ")
    @Test
    void battleTestArmyFiveGit() {
        //arrange
        Army myArmy = new Army();
        myArmy.addUnits(Warrior.class, 10);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 11);

        //act

        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertTrue(result);
    }

    @DisplayName(" Testing 11 warriors vs 7 warriors ")
    @Test
    void battleTestArmySixGit() {
        //arrange
        Army myArmy = new Army();
        myArmy.addUnits(Warrior.class, 11);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 7);

        //act

        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertTrue(result);
    }

    @DisplayName(" Testing my Army vs enemy army ")
    @Test
    void battleTestArmyOneCheckio() {
        //arrange
        Army myArmy = new Army();
        myArmy.addUnits(Knight.class, 3);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 3);

        //act
        Battle figth = new Battle();
        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertTrue(result);
    }

    @DisplayName(" Testing 20 Warriors & 5 Knights vs 30 Warriors ")
    @Test
    void battleTestArmyTwoCheckio() {
        //arrange
        Army myArmy = new Army();
        myArmy.addUnits(Warrior.class, 20);
        myArmy.addUnits(Knight.class, 5);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 30);

        //act

        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertFalse(result);
    }

    @DisplayName(" Testing with param")
    @ParameterizedTest
    @CsvSource({"Warrior, Warrior, true",
            "Warrior, Knight, false",
            "Warrior, Defender, false",
            "Knight, Defender, true"})
    void battleTestParam(String firstWarrior, String secondWarrior, boolean expected) {
        //arrange
        var first = Warrior.of(firstWarrior);
        var second = Warrior.of(secondWarrior);

        //act
        Battle figth = new Battle();
        var resalt = figth.fight(first, second);

        //assert
        assertEquals(expected, resalt);
    }

    @DisplayName("Added defender. Testing  army of 14 with 4")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestArmyDefender(boolean expected) {
        //arrange
        Army myArmy = new Army();
        myArmy.addUnits(Warrior.class, 5);
        myArmy.addUnits(Defender.class, 4);
        myArmy.addUnits(Defender.class, 5);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 4);

        //act

        var resalt = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, resalt);
    }

    @DisplayName("Added defender. Testing  army of 29 with 21")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestArmyDefenderBig(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Defender.class, 5);
        myArmy.addUnits(Warrior.class, 20);
        enemyArmy.addUnits(Warrior.class, 21);
        myArmy.addUnits(Defender.class, 4);

        //act

        var resalt = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, resalt);
    }

    @DisplayName("Added defender. Testing  army of 25 with 5")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestArmyDefenderBattle(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Warrior.class, 10);
        myArmy.addUnits(Defender.class, 5);
        enemyArmy.addUnits(Warrior.class, 5);
        myArmy.addUnits(Defender.class, 10);

        //act

        var resalt = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, resalt);
    }

    @DisplayName("Added defender. Testing  army of 4 with 5")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestArmyDefenderSmallArmy(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Defender.class, 2);
        myArmy.addUnits(Warrior.class, 1);
        myArmy.addUnits(Defender.class, 1);
        enemyArmy.addUnits(Warrior.class, 5);

        //act
        var resalt = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, resalt);
    }

    @DisplayName(" Testing with param Defender vs Rookie")
    @ParameterizedTest
    @CsvSource({"Defender, Rookie, 60"})
    void battleTestRookie(String firstWarrior, String secondWarrior, int expected) {
        //arrange
        var first = Warrior.of(firstWarrior);
        var second = Warrior.of(secondWarrior);

        //act
        Battle figth = new Battle();
        var result = figth.fight(first, second);
        var health = first.getHealth();

        //assert
        assertEquals(expected, health);
    }

    @DisplayName(" Vampire testing with param battle 11, 18 units vs 18")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestVampires(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Defender.class, 5);
        myArmy.addUnits(Vampire.class, 6);
        myArmy.addUnits(Warrior.class, 7);

        enemyArmy.addUnits(Warrior.class, 6);
        enemyArmy.addUnits(Defender.class, 6);
        enemyArmy.addUnits(Vampire.class, 6);

        //act

        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName(" Vampire testing with param battle 12, 9 units vs 11")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestVampiresSmall(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Defender.class, 2);
        myArmy.addUnits(Vampire.class, 3);
        myArmy.addUnits(Warrior.class, 4);

        enemyArmy.addUnits(Warrior.class, 4);
        enemyArmy.addUnits(Defender.class, 4);
        enemyArmy.addUnits(Vampire.class, 3);

        //act

        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName(" Vampire testing with param battle 13, 18 units vs 21")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestVampiresThirteen(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Defender.class, 11);
        myArmy.addUnits(Vampire.class, 3);
        myArmy.addUnits(Warrior.class, 4);

        enemyArmy.addUnits(Warrior.class, 4);
        enemyArmy.addUnits(Defender.class, 4);
        enemyArmy.addUnits(Vampire.class, 13);

        //act

        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("Vampire testing with param battle 14, 20 units vs 21")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestVampiresFourteen(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Defender.class, 9);
        myArmy.addUnits(Vampire.class, 3);
        myArmy.addUnits(Warrior.class, 8);

        enemyArmy.addUnits(Warrior.class, 4);
        enemyArmy.addUnits(Defender.class, 4);
        enemyArmy.addUnits(Vampire.class, 13);

        //act

        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("Lancer testing with param battle 15, 14 units vs 19")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestLancerFifthteen(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Lancer.class, 5);
        myArmy.addUnits(Vampire.class, 3);
        myArmy.addUnits(Warrior.class, 4);
        myArmy.addUnits(Defender.class, 2);

        enemyArmy.addUnits(Warrior.class, 4);
        enemyArmy.addUnits(Defender.class, 4);
        enemyArmy.addUnits(Vampire.class, 6);
        enemyArmy.addUnits(Lancer.class, 5);

        //act

        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("Lancer testing with param battle 16, 16 units vs 18")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestLancerSix(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Lancer.class, 7);
        myArmy.addUnits(Vampire.class, 3);
        myArmy.addUnits(Warrior.class, 4);
        myArmy.addUnits(Defender.class, 2);

        enemyArmy.addUnits(Warrior.class, 4);
        enemyArmy.addUnits(Defender.class, 4);
        enemyArmy.addUnits(Vampire.class, 6);
        enemyArmy.addUnits(Lancer.class, 4);

        //act
        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("Lancer testing with param battle 16, 16 units vs 18")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestLancerSeventeen(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Lancer.class, 7);
        myArmy.addUnits(Vampire.class, 3);
        myArmy.addUnits(Warrior.class, 4);
        myArmy.addUnits(Defender.class, 2);


        enemyArmy.addUnits(Warrior.class, 4);
        enemyArmy.addUnits(Defender.class, 4);
        enemyArmy.addUnits(Vampire.class, 6);
        enemyArmy.addUnits(Lancer.class, 4);

        //act
        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("Healer testing with param battle Checkio, 9 units vs 13")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestHealerCheckio(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Defender.class, 2);
        myArmy.addUnits(Healer.class, 1);
        myArmy.addUnits(Vampire.class, 2);
        myArmy.addUnits(Lancer.class, 2);
        myArmy.addUnits(Healer.class, 1);
        myArmy.addUnits(Warrior.class, 1);

        enemyArmy.addUnits(Warrior.class, 2);
        enemyArmy.addUnits(Lancer.class, 4);
        enemyArmy.addUnits(Healer.class, 1);
        enemyArmy.addUnits(Defender.class, 2);
        enemyArmy.addUnits(Vampire.class, 3);
        enemyArmy.addUnits(Healer.class, 1);

        //act
        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("Healer testing with param battle Checkio #2, 5 units vs 7")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestHealerCheckioSecond(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Warrior.class, 1);
        myArmy.addUnits(Lancer.class, 1);
        myArmy.addUnits(Healer.class, 1);
        myArmy.addUnits(Defender.class, 2);

        enemyArmy.addUnits(Vampire.class, 3);
        enemyArmy.addUnits(Warrior.class, 1);
        enemyArmy.addUnits(Healer.class, 1);
        enemyArmy.addUnits(Lancer.class, 2);


        //act
        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("Healer testing with param battle 18, 9 units vs 13")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestHealerEighteen(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Lancer.class, 1);
        myArmy.addUnits(Warrior.class, 3);
        myArmy.addUnits(Healer.class, 1);
        myArmy.addUnits(Warrior.class, 4);
        myArmy.addUnits(Healer.class, 1);
        myArmy.addUnits(Knight.class, 1);

        enemyArmy.addUnits(Warrior.class, 4);
        enemyArmy.addUnits(Defender.class, 4);
        enemyArmy.addUnits(Healer.class, 1);
        enemyArmy.addUnits(Vampire.class, 6);
        enemyArmy.addUnits(Lancer.class, 4);


        //act
        var result = Battle.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("StraightFight testing with param battle Chekio")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestStraightFight(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Defender.class, 2);
        myArmy.addUnits(Healer.class, 1);
        myArmy.addUnits(Vampire.class, 2);
        myArmy.addUnits(Lancer.class, 2);
        myArmy.addUnits(Healer.class, 1);
        myArmy.addUnits(Warrior.class, 1);

        enemyArmy.addUnits(Warrior.class, 2);
        enemyArmy.addUnits(Lancer.class, 4);
        enemyArmy.addUnits(Healer.class, 1);
        enemyArmy.addUnits(Defender.class, 2);
        enemyArmy.addUnits(Vampire.class, 3);
        myArmy.addUnits(Healer.class, 1);

        //act
        var result = Battle.straightFight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("StraightFight testing with param battle Chekio #2")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestStraightFightNineteen(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();

        myArmy.addUnits(Warrior.class, 10);

        enemyArmy.addUnits(Warrior.class, 6);
        enemyArmy.addUnits(Lancer.class, 5);

        //act
        var result = Battle.straightFight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("StraightFight testing with param battle Chekio #2")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestStraightFightTwo(boolean expected) {
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Lancer.class, 5);
        myArmy.addUnits(Vampire.class, 3);
        myArmy.addUnits(Warrior.class, 4);
        myArmy.addUnits(Defender.class, 2);

        enemyArmy.addUnits(Warrior.class, 4);
        enemyArmy.addUnits(Defender.class, 4);
        enemyArmy.addUnits(Vampire.class, 6);
        enemyArmy.addUnits(Lancer.class, 5);

        //act
        var result = Battle.straightFight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("StraightFight testing with param battle Chekio")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestStraightFightTwenty(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Lancer.class, 7);
        myArmy.addUnits(Vampire.class, 3);
        myArmy.addUnits(Warrior.class, 4);
        myArmy.addUnits(Defender.class, 2);

        enemyArmy.addUnits(Warrior.class, 4);
        enemyArmy.addUnits(Defender.class, 4);
        enemyArmy.addUnits(Vampire.class, 6);
        myArmy.addUnits(Lancer.class, 4);

        //act
        var result = Battle.straightFight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("StraightFight testing with param battle 21")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestStraightFightTwentyOne(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Lancer.class, 7);
        myArmy.addUnits(Vampire.class, 3);
        myArmy.addUnits(Healer.class, 1);
        myArmy.addUnits(Warrior.class, 4);
        myArmy.addUnits(Healer.class, 1);
        myArmy.addUnits(Defender.class, 2);


        enemyArmy.addUnits(Warrior.class, 4);
        enemyArmy.addUnits(Defender.class, 4);
        enemyArmy.addUnits(Healer.class, 1);
        enemyArmy.addUnits(Vampire.class, 6);
        enemyArmy.addUnits(Lancer.class, 4);

        //act
        var result = Battle.straightFight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("StraightFight testing with param battle 22")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestStraightFightTwentyTwo(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();
        myArmy.addUnits(Lancer.class, 4);
        myArmy.addUnits(Warrior.class, 3);
        myArmy.addUnits(Healer.class, 1);
        myArmy.addUnits(Warrior.class, 4);
        myArmy.addUnits(Healer.class, 1);
        myArmy.addUnits(Knight.class, 2);


        enemyArmy.addUnits(Warrior.class, 4);
        enemyArmy.addUnits(Defender.class, 4);
        enemyArmy.addUnits(Healer.class, 1);
        enemyArmy.addUnits(Vampire.class, 2);
        enemyArmy.addUnits(Lancer.class, 4);

        //act
        var result = Battle.straightFight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, result);
    }

    @DisplayName("Fight testing with weapon first")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestWeapon(boolean expected) {
        //arrange
        var unit1 = new Warrior();
        var unit2 = new Vampire();
        Weapons claws = Weapons.builder().health(-10).attack(5).defence(0).vampirism(40).heal(0).build();
        Weapons sword = new Sword();
        unit1.equipWeapon(claws);
        unit2.equipWeapon(sword);

        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(unit1, unit2);

        //assert
        assertEquals(expected, resultSecond);
    }

    @DisplayName("Fight testing with weapon SECOND")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestWeaponSecond(boolean expected) {
        //arrange
        var unit1 = new Defender();
        var unit2 = new Lancer();
        Weapons shield = new Shield();
        Weapons greatAxe = new GreatAxe();
        unit1.equipWeapon(shield);
        unit2.equipWeapon(greatAxe);

        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(unit1, unit2);

        //assert
        assertEquals(expected, resultSecond);
    }

    @DisplayName("Fight testing with weapon THIRD")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestWeaponThird(boolean expected) {
        //arrange
        var unit1 = new Healer();
        var unit2 = new Knight();
        Weapons shield = new MagicWand();
        Weapons greatAxe = new Katana();
        unit1.equipWeapon(shield);
        unit2.equipWeapon(greatAxe);

        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(unit1, unit2);

        //assert
        assertEquals(expected, resultSecond);
    }

    @DisplayName("Fight testing with weapon FOUR")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestWeaponFourth(boolean expected) {
        //arrange
        var unit1 = new Defender();
        var unit2 = new Vampire();
        Weapons shield = new Shield();
        Weapons greatAxe = new MagicWand();
        Weapons weapon3 = new Shield();
        Weapons katana = new Katana();

        unit1.equipWeapon(shield);
        unit1.equipWeapon(greatAxe);
        unit2.equipWeapon(weapon3);
        unit2.equipWeapon(katana);
        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(unit1, unit2);

        //assert
        assertEquals(expected, resultSecond);
    }

    @DisplayName("Fight testing with weapon Fifth")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestWeaponFifth(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();

        var knight = new Knight();
        var lancer = new Lancer();
        var vampire = new Vampire();
        var healer = new Healer();

        Weapons greatAxe = new GreatAxe();
        Weapons magicWand = new MagicWand();

        knight.equipWeapon(greatAxe);
        lancer.equipWeapon(magicWand);
        vampire.equipWeapon(greatAxe);
        healer.equipWeapon(magicWand);

        myArmy.addUnits(knight);
        myArmy.addUnits(lancer);
        enemyArmy.addUnits(vampire);
        enemyArmy.addUnits(healer);

        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, resultSecond);
    }

    @DisplayName("Fight testing with weapon Sixth")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestWeaponSixth(boolean expected) {
        //arrange
        Army myArmy = new Army();
        Army enemyArmy = new Army();

        var defender = new Defender();
        var warrior = new Warrior();
        var knight = new Knight();
        var healer = new Healer();

        Weapons sword = new Sword();
        Weapons greatAxe = new GreatAxe();


        defender.equipWeapon(greatAxe);
        warrior.equipWeapon(greatAxe);
        knight.equipWeapon(sword);
        healer.equipWeapon(sword);

        myArmy.addUnits(defender);
        myArmy.addUnits(warrior);
        enemyArmy.addUnits(knight);
        enemyArmy.addUnits(healer);

        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, resultSecond);
    }

    @DisplayName("Fight testing with weapon Seventh")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestWeaponSeventh(boolean expected) {
        //arrange
        Weapons katana = new Katana();
        Weapons shield = new Shield();
        Army myArmy = new Army();
        Army enemyArmy = new Army();

        var defender = new Defender();
        var defenderSecond = new Defender();
        var knight = new Knight();
        var vampire = new Vampire();

        defender.equipWeapon(katana);
        defenderSecond.equipWeapon(katana);
        knight.equipWeapon(katana);
        vampire.equipWeapon(katana);

        myArmy.addUnits(defender);
        myArmy.addUnits(defenderSecond);
        enemyArmy.addUnits(knight);
        enemyArmy.addUnits(vampire);

        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, resultSecond);
    }

    @DisplayName("Fight testing with weapon Eighth")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestWeaponEighth(boolean expected) {
        //arrange
        Weapons personalOne = Weapons.builder().health(-20).attack(6).defence(1).vampirism(40).heal(-2).build();
        Weapons unique = Weapons.builder().health(20).attack(-2).defence(2).vampirism(-55).heal(3).build();
        Army myArmy = new Army();
        Army enemyArmy = new Army();

        var knight1 = new Knight();
        var knight2 = new Knight();
        var knight3 = new Knight();

        var warrior = new Warrior();
        var defender = new Defender();
        var defenderOne = new Defender();

        knight1.equipWeapon(personalOne);
        knight2.equipWeapon(personalOne);
        knight3.equipWeapon(unique);

        warrior.equipWeapon(personalOne);
        defender.equipWeapon(unique);
        defenderOne.equipWeapon(unique);

        myArmy.addUnits(knight1);
        myArmy.addUnits(knight2);
        myArmy.addUnits(knight2);

        enemyArmy.addUnits(warrior);
        enemyArmy.addUnits(defender);
        enemyArmy.addUnits(defenderOne);
        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, resultSecond);
    }

    @DisplayName("Fight testing with weapon Ninth")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestWeaponNinth(boolean expected) {
        //arrange
        Weapons personalOne = Weapons.builder().health(-20).attack(1).defence(1).vampirism(40).heal(-2).build();
        Weapons uniqueTwo = Weapons.builder().health(20).attack(2).defence(2).vampirism(-55).heal(3).build();
        Army myArmy = new Army();
        Army enemyArmy = new Army();

        var vampire1 = new Vampire();
        var vampire2 = new Vampire();
        var vampire3 = new Vampire();

        var warrior = new Warrior();
        var defender = new Defender();
        var defenderOne = new Defender();

        vampire1.equipWeapon(personalOne);
        vampire2.equipWeapon(personalOne);
        vampire3.equipWeapon(uniqueTwo);

        warrior.equipWeapon(personalOne);
        defender.equipWeapon(uniqueTwo);
        defenderOne.equipWeapon(uniqueTwo);

        myArmy.addUnits(vampire1);
        myArmy.addUnits(vampire2);
        myArmy.addUnits(vampire3);

        enemyArmy.addUnits(warrior);
        enemyArmy.addUnits(defender);
        enemyArmy.addUnits(defenderOne);
        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, resultSecond);
    }

    @DisplayName("Fight testing with weapon Tenth")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestWeaponTenth(boolean expected) {
        //arrange
        Weapons katana = new Katana();
        Weapons shield = new Shield();
        Army myArmy = new Army();
        Army enemyArmy = new Army();

        var vampire1 = new Vampire();
        var vampire2 = new Vampire();
        var rookie1 = new Rookie();
        var rookie2 = new Rookie();

        var warrior = new Warrior();
        var defender = new Defender();
        var defenderOne = new Defender();

        vampire1.equipWeapon(katana);
        vampire2.equipWeapon(katana);
        rookie1.equipWeapon(shield);

        warrior.equipWeapon(katana);
        defender.equipWeapon(shield);
        defenderOne.equipWeapon(shield);

        myArmy.addUnits(vampire1);
        myArmy.addUnits(vampire2);
        myArmy.addUnits(rookie1);
        myArmy.addUnits(rookie2);

        enemyArmy.addUnits(warrior);
        enemyArmy.addUnits(defender);
        enemyArmy.addUnits(defenderOne);
        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, resultSecond);
    }

    @DisplayName("Fight testing with weapon Eleventh")
    @ParameterizedTest
    @CsvSource({"true"})
    void battleTestWeaponEleventh(boolean expected) {
        //arrange
        Weapons sword = new Sword();
        Weapons greatAxe = new GreatAxe();
        Army myArmy = new Army();
        Army enemyArmy = new Army();

        var vampire1 = new Vampire();
        var vampire2 = new Vampire();
        var vampire3 = new Vampire();

        var warrior = new Warrior();
        var defender = new Defender();

        vampire1.equipWeapon(sword);
        vampire2.equipWeapon(sword);
        vampire3.equipWeapon(sword);

        warrior.equipWeapon(greatAxe);
        defender.equipWeapon(greatAxe);

        myArmy.addUnits(vampire1);
        myArmy.addUnits(vampire2);
        myArmy.addUnits(vampire3);

        enemyArmy.addUnits(warrior);
        enemyArmy.addUnits(defender);
        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, resultSecond);
    }

    @DisplayName("Fight testing with weapon Twelve")
    @ParameterizedTest
    @CsvSource({"false"})
    void battleTestWeaponTwelve(boolean expected) {
        //arrange
        Weapons katana = new Katana();
        Weapons magicWand = new MagicWand();
        Army myArmy = new Army();
        Army enemyArmy = new Army();

        var rookie1 = new Rookie();
        var rookie2 = new Rookie();
        var rookie3 = new Rookie();

        var warrior = new Warrior();
        var defender = new Defender();

        rookie1.equipWeapon(katana);
        rookie2.equipWeapon(katana);
        rookie3.equipWeapon(katana);

        warrior.equipWeapon(magicWand);
        defender.equipWeapon(magicWand);

        myArmy.addUnits(rookie1);
        myArmy.addUnits(rookie2);
        myArmy.addUnits(rookie3);

        enemyArmy.addUnits(warrior);
        enemyArmy.addUnits(defender);
        //act
        Battle figth = new Battle();
        var resultSecond = figth.fight(myArmy, enemyArmy);

        //assert
        assertEquals(expected, resultSecond);
    }

    @DisplayName("Fight testing with weapon Warlords")
    @Test
    void battleTestArmyFightWithWarlordFirst() {
        Army army_1 = new Army();
        army_1.addUnits(Warlord.class, 1);
        army_1.addUnits(Warrior.class, 2);
        army_1.addUnits(Lancer.class, 2);
        army_1.addUnits(Healer.class, 2);
        army_1.addUnits(Healer.class, 1);

        Army army_2 = new Army();
        army_2.addUnits(Warlord.class, 1);
        army_2.addUnits(Vampire.class, 1);
        army_2.addUnits(Healer.class, 2);
        army_2.addUnits(Knight.class, 2);


        var result = Battle.fight(army_1, army_2);
        assertTrue(result);
    }

    @DisplayName("Fight testing with weapon Warlords second")
    @Test
    void battleTestArmyFightWithWarlordSecond() {

        Army army_1 = new Army()
                .addUnits(Warrior.class, 2)
                .addUnits(Lancer.class, 2)
                .addUnits(Defender.class, 1)
                .addUnits(Warlord.class, 3);

        Army army_2 = new Army()
                .addUnits(Warlord.class, 2)
                .addUnits(Vampire.class, 1)
                .addUnits(Healer.class, 5)
                .addUnits(Knight.class, 2);


        var result = Battle.fight(army_1, army_2);
        assertFalse(result);
    }

    @DisplayName("Fight testing with weapon Warlords Third")
    @Test
    void battleTestArmyFightWithWarlordThird() {
        Weapons sword = new Sword();
        Weapons shield = new Shield();
        Army myArmy = new Army();
        Warrior warrior = new Warrior();
        warrior.equipWeapon(sword);
        myArmy.addUnits(warrior);
        myArmy.addUnits(Warrior.class, 1)
                .addUnits(Lancer.class, 3)
                .addUnits(Defender.class, 1)
                .addUnits(Warlord.class, 4);

        Army enemyArmy = new Army();
        Warrior warlord = new Warlord();
        warlord.equipWeapon(shield);
        enemyArmy.addUnits(warlord).addUnits(Vampire.class, 1)
                .addUnits(Rookie.class, 1)
                .addUnits(Knight.class, 1);
        var result = Battle.fight(myArmy, enemyArmy);
        assertTrue(result);
    }

    @DisplayName("Fight testing with weapon Warlords & Weapon Fourth ")
    @Test
    void battleTestArmyFightWithWarlordFourth() {
        Weapons sword = new Sword();
        Weapons shield = new Shield();
        Army myArmy = new Army();
        Warrior warrior = new Warrior();
        warrior.equipWeapon(sword);
        myArmy.addUnits(warrior);
        myArmy.addUnits(Warrior.class, 1)
                .addUnits(Lancer.class, 3)
                .addUnits(Defender.class, 1)
                .addUnits(Warlord.class, 4);

        Army enemyArmy = new Army();
        Warrior warlord = new Warlord();
        warlord.equipWeapon(shield);
        enemyArmy.addUnits(warlord)
                .addUnits(Vampire.class, 1)
                .addUnits(Rookie.class, 1)
                .addUnits(Knight.class, 1);
        var result = Battle.fight(myArmy, enemyArmy);
        assertTrue(result);
    }

    @DisplayName("Fight testing with weapon Warlords & Weapon Fifth ")
    @Test
    void battleTestArmyFightWithWarlordFifth() {
        Weapons sword = new Sword();
        Weapons shield = new Shield();
        Army myArmy = new Army();
        Warrior warrior = new Warrior();
        warrior.equipWeapon(sword);
        myArmy.addUnits(warrior);
        myArmy.addUnits(Warrior.class, 1)
                .addUnits(Lancer.class, 3)
                .addUnits(Defender.class, 1)
                .addUnits(Warlord.class, 1);

        Army enemyArmy = new Army();
        Warrior warlord = new Warlord();
        warlord.equipWeapon(shield);
        enemyArmy.addUnits(warlord)
                .addUnits(Warlord.class, 4)
                .addUnits(Vampire.class, 1)
                .addUnits(Rookie.class, 1)
                .addUnits(Knight.class, 1);
        var result = Battle.fight(myArmy, enemyArmy);
        assertFalse(result);
    }

}