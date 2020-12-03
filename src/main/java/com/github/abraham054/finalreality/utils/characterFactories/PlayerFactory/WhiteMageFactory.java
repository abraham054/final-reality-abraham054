package com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.WhiteMage;
import com.github.abraham054.finalreality.utils.characterFactories.AbstractCharacterFactory;

import java.util.concurrent.BlockingQueue;

public class WhiteMageFactory extends AbstractCharacterFactory implements IPlayerFactory{
    private final int mana;

    /**
     * Creates a White mage factory with it's predefined stats.
     * @param turnsQueue a blocking queue that contains the turns.
     * @param name       the name of the White mage.
     * */
    public WhiteMageFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.mana = 130;
        this.healthPoints = 130;
        this.defense = 13;
    }

    /**
     * Creates a new White mage with it's predefined values of defense, mana and health points.
     * */
    @Override
    public AbstractPlayerCharacter make() {
        return new WhiteMage(name,turnsQueue,defense,healthPoints,mana);
    }
}
