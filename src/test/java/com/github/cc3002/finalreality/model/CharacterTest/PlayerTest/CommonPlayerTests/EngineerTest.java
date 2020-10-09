package com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.CommonPlayerTests;

import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Engineer;
import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public abstract class EngineerTest extends CommonPlayerTest{
    private Engineer inge;
    private Weapon Axe;
    private Weapon Bow;
    private Weapon Sword;

    @Override
    public void setName() {
        name = "Inge";
    }

    @Override
    public void setPlayer() {
        testPlayer = new Engineer(name,turns,defense,healthPoints);
    }

    @BeforeEach
    void setUpEngineer(){
        inge = new Engineer(name,turns,defense,healthPoints);
    }

    @BeforeEach
    void setUpWeapons(){
        Axe = new CommonWeapon("Axe",20,100, CommonWeaponType.AXE);
        Bow = new CommonWeapon("Bow",5,60, CommonWeaponType.BOW);
        Sword = new CommonWeapon("Sword",30,120, CommonWeaponType.SWORD);
    }

    @Test
    @Override
    public void testWeapon() {
        assertNull(PlayerCharacter.getEquippedWeapon());
        inge.equipWeapon(Axe);
        assertEquals(Axe,PlayerCharacter.getEquippedWeapon());
        inge.equipWeapon(Bow);
        assertEquals(Bow,PlayerCharacter.getEquippedWeapon());
        inge.equipWeapon(Sword);
        assertEquals(Bow,PlayerCharacter.getEquippedWeapon());
    }

}
