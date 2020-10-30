package com.github.cc3002.finalreality.model.characterTest.playerTest.CommonPlayerTests;

import com.github.abraham054.finalreality.model.character.player.CommonPlayer.CommonPlayer;
import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.MagicWeaponType;
import com.github.cc3002.finalreality.model.characterTest.playerTest.AbstractPlayerTest;
import org.junit.jupiter.api.BeforeEach;

public abstract class CommonPlayerTest extends AbstractPlayerTest {
    protected Weapon Axe;
    protected Weapon Bow;
    protected Weapon Sword;
    protected Weapon Knife;
    protected Weapon Staff;
    protected CommonPlayer dead;

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
        Axe = new CommonWeapon("Axe",20,100, CommonWeaponType.AXE);
        Bow = new CommonWeapon("Bow",15,60, CommonWeaponType.BOW);
        Sword = new CommonWeapon("Sword",30,120, CommonWeaponType.SWORD);
        Knife = new CommonWeapon("Knife",15,80, CommonWeaponType.KNIFE);
        Staff = new MagicWeapon("Staff",10,30, MagicWeaponType.STAFF,100);
    }

}
