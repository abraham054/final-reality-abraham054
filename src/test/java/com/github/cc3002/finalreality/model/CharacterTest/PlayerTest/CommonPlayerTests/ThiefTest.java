package com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.CommonPlayerTests;

import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Thief;
import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.MagicWeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public abstract class ThiefTest extends CommonPlayerTest{
    private Thief choro;
    private Weapon Bow;
    private Weapon Sword;
    private Weapon Staff;

    @Override
    public void setName() { name = "Choro";}

    @Override
    public void setPlayer() { testPlayer = new Thief(name,turns,defense,healthPoints);}

    @BeforeEach
    void setUpThief(){
        choro = new Thief(name,turns,defense,healthPoints);
    }

    @BeforeEach
    void setUpWeapons(){
        Staff = new MagicWeapon("Axe",20,100, MagicWeaponType.STAFF,50);
        Bow = new CommonWeapon("Bow",5,60, CommonWeaponType.BOW);
        Sword = new CommonWeapon("Sword",30,120, CommonWeaponType.SWORD);
    }

    @Test
    @Override
    public void testWeapon() {
        assertNull(PlayerCharacter.getEquippedWeapon());
        choro.equipWeapon(Sword);
        assertEquals(Sword,PlayerCharacter.getEquippedWeapon());
        choro.equipWeapon(Bow);
        assertEquals(Bow,PlayerCharacter.getEquippedWeapon());
        choro.equipWeapon(Staff);
        assertEquals(Staff,PlayerCharacter.getEquippedWeapon());
    }

}
