package com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.MagicPlayerTests;

import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicClasses.BlackMage;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicPlayer;
import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.MagicWeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public abstract class BlackMageTest extends MagicPlayerTest {
    private BlackMage negro;
    private Weapon Knife;
    private Weapon Staff;

    @Override
    public void setName() {
        name = "Negro";
    }

    @Override
    void setMana() { mana = 150; }

    @Override
    public void setPlayer() {
        testPlayer = new BlackMage(name,turns,defense,healthPoints,mana);
    }

    @BeforeEach
    void setUpBlackMage(){
        negro = new BlackMage(name,turns,defense,healthPoints,mana);
    }

    @BeforeEach
    void setUpWeapons(){
        Knife = new CommonWeapon("Bow",5,60, CommonWeaponType.KNIFE);
        Staff = new MagicWeapon("Staff",30,120, MagicWeaponType.STAFF,100);
    }

    @Test
    public void testMana(){
        assertEquals(mana, MagicPlayer.getMana());
    }

    @Test
    @Override
    public void testWeapon() {
        assertNull(PlayerCharacter.getEquippedWeapon());
        negro.equipWeapon(Staff);
        assertEquals(Staff,PlayerCharacter.getEquippedWeapon());
        negro.equipWeapon(Knife);
        assertEquals(Knife,PlayerCharacter.getEquippedWeapon());
    }



}
