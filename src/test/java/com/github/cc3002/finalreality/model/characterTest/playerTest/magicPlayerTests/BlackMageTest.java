package com.github.cc3002.finalreality.model.characterTest.playerTest.magicPlayerTests;

import static org.junit.jupiter.api.Assertions.*;

import com.github.abraham054.finalreality.model.character.player.playerClasses.MagicPlayerClass;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.magicClasses.BlackMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

public class BlackMageTest extends MagicPlayerTest {
    private BlackMage oscuro;
    private BlackMage guldan;

    @Override
    public void setName() {
        name = "Mago oscuro";
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
        guldan = new BlackMage("Gul'dan",turns,defense,healthPoints,mana);
        oscuro = new BlackMage(name,turns,defense,healthPoints,mana);
        dead = new BlackMage(name,turns,defense,0,mana);
    }

    @Test
    public void testMana(){
        assertEquals(mana, oscuro.getMana());
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
        dead.equipWeapon(Staff);
    }

    @Test
    public void equals(){
        assertEquals(oscuro,testPlayer);
        assertTrue(oscuro.equals(testPlayer));
        assertTrue(oscuro.equals(oscuro));
        assertFalse(oscuro.equals(Staff));
        assertFalse(oscuro.equals(guldan));
    }

}
