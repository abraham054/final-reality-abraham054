package com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.MagicPlayerTests;

import static org.junit.jupiter.api.Assertions.*;

import com.github.abraham054.finalreality.model.character.player.PlayerClasses.MagicPlayerClass;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicClasses.BlackMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

public class BlackMageTest extends MagicPlayerTest {
    private BlackMage negro;
    private BlackMage will;

    @Override
    public void setName() {
        name = "Negro";
    }

    @Override
    public void setMana() { mana = 150; }

    @Override
    public void setClass() { playerClass = MagicPlayerClass.BLACK_MAGE;}

    @Override
    public void setPlayer() {
        turns = new LinkedBlockingQueue<>();
        testPlayer = new BlackMage(name,turns,defense,healthPoints,mana);
    }

    @BeforeEach
    void setUpMage(){
        will = new BlackMage("Will",turns,defense,healthPoints,mana);
        negro = new BlackMage(name,turns,defense,healthPoints,mana);
    }

    @Test
    public void testMana(){
        assertEquals(mana, negro.getMana());
    }

    @Test
    @Override
    public void testWeapon() {
        assertNull(testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Staff);
        assertEquals(Staff,testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Knife);
        assertEquals(Knife,testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Axe);
        waitTurnTest();
    }

    @Test
    public void equals(){
        assertEquals(negro,testPlayer);
        assertTrue(negro.equals(testPlayer));
        assertTrue(negro.equals(negro));
        assertFalse(negro.equals(Staff));
        assertFalse(negro.equals(will));
    }

}
