package com.github.cc3002.finalreality.model.character.PlayerTest.CommonPlayerTests;

import com.github.abraham054.finalreality.model.character.player.PlayerClasses.CommonPlayerClass;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Knight;
import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class KnightTest extends CommonPlayerTest{
    private Knight artorias;

    @Override
    public void setName() { name = "Artorias"; }

    @Override
    public void setPlayer() { testPlayer = new Knight(name,turns,defense,healthPoints); }

    @BeforeEach
    void setUpKnight(){
        artorias = new Knight(name,turns,defense,healthPoints);
    }

    @Override
    @Test
    public void testWeapon() {
    }



}
