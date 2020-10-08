package com.github.cc3002.finalreality.model.character.PlayerTest;

import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.PlayerClasses.PlayerClasses;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.character.AbstractCharacterTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public abstract class AbstractPlayerTest extends AbstractCharacterTests implements IPlayerTest{

    protected PlayerClasses playerClass;
    protected PlayerCharacter testPlayer;

    public abstract void setPlayer();

    @Override
    @BeforeEach
    public void setUp(){
        setName();
        setDefense();
        setHealthPoints();
        setPlayer();
    }

    @Override
    @Test
    public void testClass() {
        assertEquals(playerClass,testPlayer.getCharacterClass());
    }

    @Override
    @Test
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
