package com.github.cc3002.finalreality.model.factoryTest.CharacterFactoryTest.PlayerFactoryTest;

import com.github.abraham054.finalreality.model.character.player.commonPlayer.Engineer;
import com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory.EngineerFactory;

public class EngineerFactoryTest extends AbstractPCFTest {
    @Override
    public void setName() {
        name = "El industrial";
    }

    @Override
    public void setFactoryCharacter() {
        factoryCharacter = new EngineerFactory(turns,name).make();
    }

    @Override
    public void setCharacter() {
        playerCharacter = new Engineer(name,turns,20,160);
    }
}
