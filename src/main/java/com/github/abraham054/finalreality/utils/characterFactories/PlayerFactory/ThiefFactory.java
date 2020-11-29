package com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.IPlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.Thief;
import com.github.abraham054.finalreality.utils.characterFactories.AbstractCharacterFactory;

import java.util.concurrent.BlockingQueue;

public class ThiefFactory extends AbstractCharacterFactory implements IPlayerFactory {

    public ThiefFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.healthPoints = 100;
        this.defense = 30;
    }

    @Override
    public IPlayerCharacter make() {
        return new Thief(name,turnsQueue,defense,healthPoints);
    }
}
