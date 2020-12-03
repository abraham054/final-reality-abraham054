package com.github.cc3002.finalreality.model.factoryTest.CharacterFactoryTest.PlayerFactoryTest;

import com.github.abraham054.finalreality.model.character.player.magicPlayer.WhiteMage;
import com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory.WhiteMageFactory;

public class WhiteMageFactoryTest extends AbstractPCFTest {
    @Override
    public void setName() {
        name = "Maradona";
    }

    @Override
    public void setFactoryCharacter() {
        factoryCharacter = new WhiteMageFactory(turns,name).make();
    }

    @Override
    public void setCharacter() {
        playerCharacter = new WhiteMage(name,turns,13,130,130);
    }
}
