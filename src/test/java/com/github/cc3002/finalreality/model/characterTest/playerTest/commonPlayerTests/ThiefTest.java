package com.github.cc3002.finalreality.model.characterTest.playerTest.commonPlayerTests;

import static org.junit.jupiter.api.Assertions.*;

import com.github.abraham054.finalreality.model.character.player.commonPlayer.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

public class ThiefTest extends CommonPlayerTest{
    private Thief ladron;

    @Override
    public void setName() { name = "Ladron";}

    @Override
    public void setPlayer() {
        turns = new LinkedBlockingQueue<>();
        testPlayer = new Thief(name,turns,defense,healthPoints);
    }

    @BeforeEach
    void setUpThief(){
        ladron = new Thief(name,turns,defense,healthPoints);
        dead = new Thief(name,turns,defense,0);
    }

    @Test
    @Override
    public void testWeapon() {
        assertNull(testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Sword);
        assertEquals(Sword,testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Bow);
        assertEquals(Bow,testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Staff);
        assertEquals(Staff,testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Knife);
        testPlayer.equipWeapon(Axe);
        assertEquals(Staff,testPlayer.getEquippedWeapon());
        waitTurnTest();
        dead.equipWeapon(Sword);
    }

    @Test
    public void equals(){
        assertEquals(ladron,testPlayer);
        assertTrue(ladron.equals(testPlayer));
        assertFalse(ladron.equals(Sword));
    }

}
