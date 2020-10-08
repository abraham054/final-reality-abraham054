package com.github.cc3002.finalreality.model.character.PlayerTest.MagicPlayerTests;

import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicClasses.BlackMage;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;

public abstract class BlackMageTest extends MagicPlayertTest{
    private BlackMage negro;

    @Override
    public void setName() {
        name = "Negro";
    }

    @Override
    public void setPlayer() {
        testPlayer = new BlackMage(name,turns,defense,healthPoints,mana);
    }

    @BeforeEach
    void setUpBlackMage(){
        negro = new BlackMage(name,turns,defense,healthPoints,mana);
    }
    @Override
    public void testWeapon() {

    }



}
