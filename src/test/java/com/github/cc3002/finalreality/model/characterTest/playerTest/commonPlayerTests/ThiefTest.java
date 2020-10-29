package com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.CommonPlayerTests;

import static org.junit.jupiter.api.Assertions.*;

import com.github.abraham054.finalreality.model.character.player.PlayerClasses.CommonPlayerClass;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Thief;
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

    @Override
    public void setClass() { playerClass = CommonPlayerClass.THIEF; }

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
