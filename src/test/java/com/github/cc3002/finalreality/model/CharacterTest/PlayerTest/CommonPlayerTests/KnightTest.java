package com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.CommonPlayerTests;

import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Knight;
import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public abstract class KnightTest extends CommonPlayerTest{
    private Knight artorias;
    private Weapon Axe;
    private Weapon Knife;
    private Weapon Sword;

    @Override
    public void setName() { name = "Artorias"; }

    @Override
    public void setPlayer() { testPlayer = new Knight(name,turns,defense,healthPoints); }

    @BeforeEach
    void setUpKnight(){
        artorias = new Knight(name,turns,defense,healthPoints);
    }

    @BeforeEach
    void setUpWeapons(){
        Axe = new CommonWeapon("Axe",20,100, CommonWeaponType.AXE);
        Knife = new CommonWeapon("Bow",5,60, CommonWeaponType.KNIFE);
        Sword = new CommonWeapon("Sword",30,120, CommonWeaponType.SWORD);
    }

    @Test
    @Override
    public void testWeapon() {
        assertNull(PlayerCharacter.getEquippedWeapon());
        artorias.equipWeapon(Sword);
        assertEquals(Sword,PlayerCharacter.getEquippedWeapon());
        artorias.equipWeapon(Axe);
        assertEquals(Axe,PlayerCharacter.getEquippedWeapon());
        artorias.equipWeapon(Knife);
        assertEquals(Knife,PlayerCharacter.getEquippedWeapon());
    }



}
