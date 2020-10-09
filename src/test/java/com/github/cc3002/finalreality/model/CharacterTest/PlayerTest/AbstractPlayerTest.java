package com.github.cc3002.finalreality.model.CharacterTest.PlayerTest;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.PlayerClasses.PlayerClasses;
import org.junit.jupiter.api.Assertions;
import java.util.concurrent.BlockingQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractPlayerTest implements IPlayerTest{

    protected PlayerCharacter testPlayer;
    protected BlockingQueue<ICharacter> turns;
    protected String name;
    protected int defense;
    protected int healthPoints;
    protected PlayerClasses playerClass;

    public abstract void setName();

    public abstract void setDefense();

    public abstract void setHealthPoints();

    public abstract void setPlayer();

    @BeforeEach
    public void setUp(){
        setName();
        setDefense();
        setHealthPoints();
        setPlayer();
    }

    @Test
    @Override
    public void testName() { assertEquals(name, testPlayer.getName());}

    @Test
    @Override
    public void testDefense() { assertEquals(defense, testPlayer.getDefense());}

    @Test
    @Override
    public void testHealthPoints() { assertEquals(healthPoints, testPlayer.getHealthPoints());}

    @Test
    @Override
    public void testClass() {
        assertEquals(playerClass,testPlayer.getCharacterClass());
    }

    @Test
    @Override
    public void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        testPlayer.waitTurn();
        try {
            // Prueben disminuir este tiempo
            Thread.sleep(900);  // <----
            //
            Assertions.assertEquals(0, turns.size());
            // Prueben aumentar este tiempo
            Thread.sleep(200);  // <----
            //
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testPlayer, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
