package com.github.cc3002.finalreality.model.factoryTest.CharacterFactoryTest.PlayerFactoryTest;

import com.github.abraham054.finalreality.model.character.player.magicPlayer.BlackMage;
import com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory.BlackMageFactory;

public class BlackMageFactoryTest extends AbstractPCFTest {
    @Override
    public void setName() {
        name = "Mago tenebroso";
    }

    @Override
    public void setFactoryCharacter() {
        factoryCharacter = new BlackMageFactory(turns,name).make();
    }

    @Override
    public void setCharacter() {
        playerCharacter = new BlackMage(name,turns,10,150,150);
    }
}
