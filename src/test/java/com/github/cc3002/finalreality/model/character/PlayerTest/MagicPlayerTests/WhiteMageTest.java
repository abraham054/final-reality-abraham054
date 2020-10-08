package com.github.cc3002.finalreality.model.character.PlayerTest.MagicPlayerTests;

import com.github.abraham054.finalreality.model.character.player.PlayerClasses.MagicPlayerClass;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicClasses.WhiteMage;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class WhiteMageTest extends MagicPlayertTest {
    private WhiteMage gandalf;

    @Override
    public void setName() {
        name = "Gandalf";
    }

    @Override
    public void setPlayer() {
        testPlayer = new WhiteMage(name,turns,defense,healthPoints,mana);
    }

    @BeforeEach
    void setUpWhiteMage(){
        gandalf = new WhiteMage(name,turns,defense,healthPoints,mana);
    }

    @Test
    void testMana(){
        assertEquals(mana, gandalf.getMana());
    }

    @Override
    @Test
    public void testWeapon() {

    }

}
