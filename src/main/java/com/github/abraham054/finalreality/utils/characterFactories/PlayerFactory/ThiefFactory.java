package com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.Thief;
import com.github.abraham054.finalreality.utils.characterFactories.AbstractCharacterFactory;

import java.util.concurrent.BlockingQueue;

public class ThiefFactory extends AbstractCharacterFactory implements IPlayerFactory {

    /**
     * Creates a Thief factory with it's predefined stats.
     * @param turnsQueue a blocking queue that contains the turns.
     * @param name       the name of the Thief.
     * */
    public ThiefFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.healthPoints = 100;
        this.defense = 30;
    }

    /**
     * Creates a new Thief with it's predefined values of defense and health points.
     * */
    @Override
    public AbstractPlayerCharacter make() {
        return new Thief(name,turnsQueue,defense,healthPoints);
    }
}
