package com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.Knight;
import com.github.abraham054.finalreality.utils.characterFactories.AbstractCharacterFactory;

import java.util.concurrent.BlockingQueue;

public class KnightFactory extends AbstractCharacterFactory implements IPlayerFactory {

    /**
     * Creates a Knight factory with it's predefined stats.
     * @param turnsQueue a blocking queue that contains the turns.
     * @param name       the name of the Knight.
     * */
    public KnightFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.healthPoints = 200;
        this.defense = 25;
    }

    /**
     * Creates a new Knight with it's predefined values of defense and health points.
     * */
    @Override
    public AbstractPlayerCharacter make() {
        return new Knight(name,turnsQueue,defense,healthPoints);
    }
}
