package com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.CommonPlayerTests;

import static org.junit.jupiter.api.Assertions.*;

import com.github.abraham054.finalreality.model.character.player.PlayerClasses.CommonPlayerClass;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

public class ThiefTest extends CommonPlayerTest{
    private Thief choro;

    @Override
    public void setName() { name = "Choro";}

    @Override
    public void setPlayer() {
        turns = new LinkedBlockingQueue<>();
        testPlayer = new Thief(name,turns,defense,healthPoints);
    }

    @Override
    public void setClass() { playerClass = CommonPlayerClass.THIEF; }

    @BeforeEach
    void setUpThief(){ choro = new Thief(name,turns,defense,healthPoints); }

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
    }

    @Test
    public void equals(){
        assertEquals(choro,testPlayer);
        assertTrue(choro.equals(testPlayer));
        assertFalse(choro.equals(Sword));
    }

}
