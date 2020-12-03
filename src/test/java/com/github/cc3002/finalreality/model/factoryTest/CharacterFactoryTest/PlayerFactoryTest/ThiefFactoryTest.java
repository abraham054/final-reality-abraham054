package com.github.cc3002.finalreality.model.factoryTest.CharacterFactoryTest.PlayerFactoryTest;

import com.github.abraham054.finalreality.model.character.player.commonPlayer.Thief;
import com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory.ThiefFactory;

public class ThiefFactoryTest extends AbstractPCFTest {
    @Override
    public void setName() {
        name = "Khajiit";
    }

    @Override
    public void setFactoryCharacter() {
        factoryCharacter = new ThiefFactory(turns,name).make();
    }

    @Override
    public void setCharacter() {
        playerCharacter = new Thief(name,turns,15,100);
    }
}
