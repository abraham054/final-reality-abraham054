package com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.MagicPlayerTests;

import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicClasses.WhiteMage;
import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.MagicWeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public abstract class WhiteMageTest extends MagicPlayerTest {
    private WhiteMage gandalf;
    private Weapon Staff;

    @Override
    public void setName() {
        name = "Gandalf";
    }

    @Override
    public void setMana() { mana = 180; }

    @Override
    public void setPlayer() {
        testPlayer = new WhiteMage(name,turns,defense,healthPoints,mana);
    }

    @BeforeEach
    void setUpWhiteMage(){
        gandalf = new WhiteMage(name,turns,defense,healthPoints,mana);
    }

    @BeforeEach
    void setUpWeapons(){
        Staff = new MagicWeapon("Staff",30,120, MagicWeaponType.STAFF,100);
    }

    @Test
    void testMana(){
        assertEquals(mana, gandalf.getMana());
    }

    @Test
    @Override
    public void testWeapon() {
        assertNull(PlayerCharacter.getEquippedWeapon());
        gandalf.equipWeapon(Staff);
        assertEquals(Staff,PlayerCharacter.getEquippedWeapon());
    }

}
