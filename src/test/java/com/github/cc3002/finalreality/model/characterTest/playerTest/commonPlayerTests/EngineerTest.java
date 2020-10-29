package com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.CommonPlayerTests;

import static org.junit.jupiter.api.Assertions.*;

import com.github.abraham054.finalreality.model.character.player.PlayerClasses.CommonPlayerClass;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

public class EngineerTest extends CommonPlayerTest{
    private Engineer inge;
    private Engineer titan;

    @Override
    public void setName() {
        name = "Inge";
    }

    @Override
    public void setPlayer() {
        turns = new LinkedBlockingQueue<>();
        testPlayer = new Engineer(name,turns,defense,healthPoints);
    }

    @Override
    public void setClass() { playerClass = CommonPlayerClass.ENGINEER;}

    @BeforeEach
    void setUpEngineer(){
        titan = new Engineer("Titan",turns,defense,healthPoints);
        inge = new Engineer(name,turns,defense,healthPoints);
        dead = new Engineer(name,turns,defense,0);
    }

    @Test
    @Override
    public void testWeapon() {
        assertNull(testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Axe);
        assertEquals(Axe,testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Bow);
        assertEquals(Bow,testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Sword);
        assertEquals(Bow,testPlayer.getEquippedWeapon());
        waitTurnTest();
        dead.equipWeapon(Axe);
    }

    @Test
    public void equals(){
        assertEquals(inge,testPlayer);
        assertTrue(inge.equals(testPlayer));
        assertTrue(inge.equals(inge));
        assertFalse(inge.equals(Axe));
        assertFalse(inge.equals(titan));
    }

}
