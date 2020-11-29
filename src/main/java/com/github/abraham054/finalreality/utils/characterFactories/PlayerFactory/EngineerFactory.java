package com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.IPlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.Engineer;
import com.github.abraham054.finalreality.utils.characterFactories.AbstractCharacterFactory;

import java.util.concurrent.BlockingQueue;

public class EngineerFactory extends AbstractCharacterFactory implements IPlayerFactory{

    public EngineerFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.healthPoints = 160;
        this.defense = 70;
    }

    @Override
    public IPlayerCharacter make() {
        return new Engineer(name,turnsQueue,defense,healthPoints);
    }
}
