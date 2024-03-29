package com.github.cc3002.finalreality.model.characterTest.playerTest.magicPlayerTests;

import static org.junit.jupiter.api.Assertions.*;

import com.github.abraham054.finalreality.model.character.player.magicPlayer.WhiteMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

public class WhiteMageTest extends MagicPlayerTest {
    private WhiteMage gandalf;
    private WhiteMage onion;

    @Override
    public void setName() {
        name = "Gandalf";
    }

    @Override
    public void setMana() { mana = 180; }


    @Override
    public void setPlayer() {
        turns = new LinkedBlockingQueue<>();
        testPlayer = new WhiteMage(name,turns,defense,healthPoints,mana);
    }

    @BeforeEach
    void setUpMage(){
        onion = new WhiteMage("Onion",turns,defense,healthPoints,mana);
        gandalf = new WhiteMage(name,turns,defense,healthPoints,mana);
        dead = new WhiteMage(name,turns,defense,0,mana);
    }

    @Test
    void testMana(){
        assertEquals(mana, gandalf.getMana());
    }

    @Test
    @Override
    public void testWeapon() {
        assertNull(gandalf.getEquippedWeapon());
        testPlayer.equipWeapon(Staff);
        assertEquals(Staff,testPlayer.getEquippedWeapon());
        testPlayer.equipWeapon(Knife);
        testPlayer.equipWeapon(Axe);
        testPlayer.equipWeapon(Sword);
        testPlayer.equipWeapon(Bow);
        assertEquals(Staff,testPlayer.getEquippedWeapon());
        waitTurnTest();
        dead.equipWeapon(Staff);
    }

    @Test
    public void testWhiteMage(){
        assertTrue(testPlayer.isAlly());
    }

    @Test
    public void testStats() {
        LinkedList<String> stats = new LinkedList<>();
        stats.add(gandalf.getName());
        stats.add("Defense: " + String.valueOf(gandalf.getDefense()));
        stats.add("Health points: " + String.valueOf(gandalf.getHealthPoints()));
        stats.add("Mana: " + String.valueOf(gandalf.getMana()));
        assertEquals(stats,gandalf.getStats());
        gandalf.equipWeapon(Staff);
        stats.add("Arma: " + gandalf.getEquippedWeapon().getName());
        assertEquals(stats,gandalf.getStats());
    }

    @Test
    public void equals(){
        assertEquals(gandalf,testPlayer);
        assertTrue(gandalf.equals(testPlayer));
        assertFalse(gandalf.equals(Staff));
        assertFalse(gandalf.equals(onion));
    }

}
