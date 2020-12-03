package com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.Engineer;
import com.github.abraham054.finalreality.utils.characterFactories.AbstractCharacterFactory;

import java.util.concurrent.BlockingQueue;

public class EngineerFactory extends AbstractCharacterFactory implements IPlayerFactory{

    /**
     * Creates a Engineer factory with it's predefined stats.
     * @param turnsQueue a blocking queue that contains the turns.
     * @param name       the name of the Engineer.
     * */
    public EngineerFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.healthPoints = 160;
        this.defense = 20;
    }

    /**
     * Creates a new Engineer with it's predefined values of defense and health points.
     * */
    @Override
    public AbstractPlayerCharacter make() {
        return new Engineer(name,turnsQueue,defense,healthPoints);
    }
}
