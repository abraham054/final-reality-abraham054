package com.github.cc3002.finalreality.model.characterTest.playerTest.magicPlayerTests;

import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicAbstractPlayer;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Axe;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Bow;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Knife;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Sword;
import com.github.abraham054.finalreality.model.weapon.magicWeapon.Staff;
import com.github.cc3002.finalreality.model.characterTest.playerTest.AbstractPlayerTest;
import org.junit.jupiter.api.BeforeEach;

public abstract class MagicPlayerTest extends AbstractPlayerTest {
    protected Weapon Axe;
    protected Weapon Bow;
    protected Weapon Sword;
    protected Weapon Knife;
    protected Weapon Staff;
    protected MagicAbstractPlayer dead;
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
        Knife = new Knife("Bow",15,60);
        Staff = new Staff("Staff",17,120, 100);
        Axe = new Axe("Axe",20,100);
        Bow = new Bow("Bow",15,60);
        Sword = new Sword("Sword",30,120);
    }

}
