package com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.MagicPlayerTests;

import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicPlayer;
import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.MagicWeaponType;
import com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.AbstractPlayerTest;
import org.junit.jupiter.api.BeforeEach;

public abstract class MagicPlayerTest extends AbstractPlayerTest {
    protected Weapon Staff;
    protected Weapon Knife;
    protected Weapon Axe;
    protected MagicPlayer dead;
    protected int mana;

    abstract void setMana();

    @Override
    public void setDefense() {
        defense = 10;
    }

    @Override
    public void setHealthPoints() {
        healthPoints = 70;
    }

    @BeforeEach
    void setUpWeapons(){
        Knife = new CommonWeapon("Bow",15,60, CommonWeaponType.KNIFE);
        Staff = new MagicWeapon("Staff",17,120, MagicWeaponType.STAFF,100);
        Axe = new CommonWeapon("Axe",20,100, CommonWeaponType.AXE);
    }

}
