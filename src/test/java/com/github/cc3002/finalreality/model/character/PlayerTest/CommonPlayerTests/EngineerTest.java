package com.github.cc3002.finalreality.model.character.PlayerTest.CommonPlayerTests;

import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Engineer;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Thief;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class EngineerTest extends CommonPlayerTest{
    private Engineer inge;

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

    @Override
    @Test
    public void testWeapon() {

    }

}
