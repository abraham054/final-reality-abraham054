package com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.IPlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.WhiteMage;
import com.github.abraham054.finalreality.utils.characterFactories.AbstractCharacterFactory;

import java.util.concurrent.BlockingQueue;

public class WhiteMageFactory extends AbstractCharacterFactory implements IPlayerFactory{
    private final int mana;

    public WhiteMageFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.mana = 130;
        this.healthPoints = 130;
        this.defense = 50;
    }

    @Override
    public IPlayerCharacter make() {
        return new WhiteMage(name,turnsQueue,defense,healthPoints,mana);
    }
}
