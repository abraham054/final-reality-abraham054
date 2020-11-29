package com.github.cc3002.finalreality.model.characterTest.playerTest;

import static org.junit.jupiter.api.Assertions.*;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import java.util.concurrent.BlockingQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractPlayerTest implements IPlayerTest{

    protected AbstractPlayerCharacter testPlayer;
    protected String name;
    protected int defense;
    protected int healthPoints;
    protected BlockingQueue<ICharacter> turns;

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

    @Override
    public void waitTurnTest() {
        assertTrue(turns.isEmpty());
        testPlayer.waitTurn();
        try {
            // Prueben disminuir este tiempo
            Thread.sleep(900);  // <----
            //
            assertEquals(0, turns.size());
            // Prueben aumentar este tiempo
            Thread.sleep(400);  // <----
            //
            assertEquals(1, turns.size());
            assertEquals(testPlayer, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
