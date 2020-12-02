package com.github.abraham054.finalreality.utils.characterFactories.EnemyFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;

public class DemonFactory extends EnemyFactory{

    /**
     * Creates a Demon factory with it's predefined stats.
     * @param turnsQueue a blocking queue that contains the turns.
     * @param name       the name of the Demon.
     * */
    public DemonFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.weight = 14;
        this.attackPoints = 65;
        this.healthPoints = 100;
        this.defense = 20;
    }
}
