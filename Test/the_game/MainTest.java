package the_game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import the_game.character.*;
import the_game.funcions.Army;
import the_game.funcions.Battle;

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
}