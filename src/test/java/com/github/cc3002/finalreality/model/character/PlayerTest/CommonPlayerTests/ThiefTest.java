package com.github.cc3002.finalreality.model.character.PlayerTest.CommonPlayerTests;

import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Thief;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class ThiefTest extends CommonPlayerTest{
    private Thief choro;

    @Override
    public void setName() { name = "Choro";}

    @Override
    public void setPlayer() { testPlayer = new Thief(name,turns,defense,healthPoints);}

    @BeforeEach
    void setUpThief(){
        choro = new Thief(name,turns,defense,healthPoints);
    }

    @Override
    @Test
    public void testWeapon() {

    }

}
