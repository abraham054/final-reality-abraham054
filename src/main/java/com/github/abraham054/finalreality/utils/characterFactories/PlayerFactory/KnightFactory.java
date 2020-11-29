package com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.IPlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.Knight;
import com.github.abraham054.finalreality.utils.characterFactories.AbstractCharacterFactory;

import java.util.concurrent.BlockingQueue;

public class KnightFactory extends AbstractCharacterFactory implements IPlayerFactory {

    public KnightFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.healthPoints = 200;
        this.defense = 80;
    }

    @Override
    public IPlayerCharacter make() {
        return new Knight(name,turnsQueue,defense,healthPoints);
    }
}
