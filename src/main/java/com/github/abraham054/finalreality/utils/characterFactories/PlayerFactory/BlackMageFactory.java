package com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.BlackMage;
import com.github.abraham054.finalreality.utils.characterFactories.AbstractCharacterFactory;

import java.util.concurrent.BlockingQueue;

public class BlackMageFactory extends AbstractCharacterFactory implements IPlayerFactory{
    private final int mana;

    /**
     * Creates a Black mage factory with it's predefined stats.
     * @param turnsQueue a blocking queue that contains the turns.
     * @param name       the name of the Black mage.
     * */
    public BlackMageFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.mana = 150;
        this.healthPoints = 150;
        this.defense = 40;
    }

    /**
     * Creates a new Black mage with it's predefined values of defense, health points and mana.
     * */
    @Override
    public AbstractPlayerCharacter make() {
        return new BlackMage(name,turnsQueue,defense,healthPoints,mana);
    }
}
