package com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.IPlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.BlackMage;
import com.github.abraham054.finalreality.utils.characterFactories.AbstractCharacterFactory;

import java.util.concurrent.BlockingQueue;

public class BlackMageFactory extends AbstractCharacterFactory implements IPlayerFactory{
    private final int mana;

    public BlackMageFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.mana = 150;
        this.healthPoints = 150;
        this.defense = 40;
    }

    @Override
    public IPlayerCharacter make() {
        return new BlackMage(name,turnsQueue,defense,healthPoints,mana);
    }
}
