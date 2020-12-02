package com.github.abraham054.finalreality.utils.characterFactories.EnemyFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;

public class TrollFactory extends EnemyFactory{

    /**
     * Creates a Troll factory with it's predefined stats.
     * @param turnsQueue a blocking queue that contains the turns.
     * @param name       the name of the Troll.
     * */
    public TrollFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.weight = 17;
        this.attackPoints = 50;
        this.healthPoints = 150;
        this.defense = 40;
    }
}
