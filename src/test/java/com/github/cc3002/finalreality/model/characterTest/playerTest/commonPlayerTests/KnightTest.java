package com.github.cc3002.finalreality.model.characterTest.playerTest.commonPlayerTests;

import static org.junit.jupiter.api.Assertions.*;

import com.github.abraham054.finalreality.model.character.player.commonPlayer.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

public class KnightTest extends CommonPlayerTest{
    private Knight artorias;

    @Override
    public void setName() { name = "Artorias"; }

    @Override
    public void setPlayer() {
        turns = new LinkedBlockingQueue<>();
        testPlayer = new Knight(name,turns,defense,healthPoints);
    }

    @BeforeEach
    void setUpKnight(){
        artorias = new Knight(name,turns,defense,healthPoints);
        dead = new Knight(name,turns,defense,0);
    }

    @Test
    @Override
    public void testWeapon() {
        assertNull(testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Sword);
        assertEquals(Sword,testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Axe);
        assertEquals(Axe,testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Knife);
        assertEquals(Knife,testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Staff);
        testPlayer.equipWeapon(Bow);
        assertEquals(Knife,testPlayer.getEquippedWeapon());
        waitTurnTest();
        dead.equipWeapon(Sword);
    }

    @Test
    public void equals(){
        assertEquals(artorias,testPlayer);
        assertTrue(artorias.equals(testPlayer));
        assertFalse(artorias.equals(Axe));
    }

}
