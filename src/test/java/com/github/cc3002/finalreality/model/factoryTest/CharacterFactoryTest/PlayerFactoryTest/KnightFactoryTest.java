package com.github.cc3002.finalreality.model.factoryTest.CharacterFactoryTest.PlayerFactoryTest;

import com.github.abraham054.finalreality.model.character.player.commonPlayer.Knight;
import com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory.KnightFactory;

public class KnightFactoryTest extends AbstractPCFTest {
    @Override
    public void setName() {
        name = "Artorias";
    }

    @Override
    public void setFactoryCharacter() {
        factoryCharacter = new KnightFactory(turns,name).make();
    }

    @Override
    public void setCharacter() {
        playerCharacter = new Knight(name,turns,25,200);
    }
}
