package com.github.cc3002.finalreality.model.characterTest.playerTest.commonPlayerTests;

import static org.junit.jupiter.api.Assertions.*;

import com.github.abraham054.finalreality.model.character.player.commonPlayer.Engineer;
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

    @BeforeEach
    void setUpEngineer(){
        inge = new Engineer(name,turns,defense,healthPoints);
        titan = new Engineer("Titan",turns,defense,healthPoints);
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
        testPlayer.equipWeapon(Staff);
        testPlayer.equipWeapon(Knife);
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
