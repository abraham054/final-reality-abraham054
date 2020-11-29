package com.github.cc3002.finalreality.model.characterTest.playerTest.commonPlayerTests;

import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonAbstractPlayer;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.*;
import com.github.abraham054.finalreality.model.weapon.magicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.magicWeapon.Staff;
import com.github.cc3002.finalreality.model.characterTest.playerTest.AbstractPlayerTest;
import org.junit.jupiter.api.BeforeEach;

public abstract class CommonPlayerTest extends AbstractPlayerTest {
    protected Weapon Axe;
    protected Weapon Bow;
    protected Weapon Sword;
    protected Weapon Knife;
    protected Weapon Staff;
    protected CommonAbstractPlayer dead;

    @Override
    public void setDefense() {
        defense = 25;
    }

    @Override
    public void setHealthPoints() {
        healthPoints = 100;
    }

    @BeforeEach
    void setUpWeapons(){
        Axe = new Axe("Axe",20,100);
        Bow = new Bow("Bow",15,60);
        Sword = new Sword("Sword",30,120);
        Knife = new Knife("Knife",15,80);
        Staff = new Staff("Staff",10,30, 100);
    }

}
