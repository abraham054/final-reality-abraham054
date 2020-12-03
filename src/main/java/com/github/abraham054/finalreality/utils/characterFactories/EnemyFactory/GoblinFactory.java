package com.github.abraham054.finalreality.utils.characterFactories.EnemyFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;

public class GoblinFactory extends EnemyFactory{

    /**
     * Creates a Goblin factory with it's predefined stats.
     * @param turnsQueue a blocking queue that contains the turns.
     * @param name       the name of the Goblin.
     * */
   public GoblinFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.weight = 12;
        this.attackPoints = 40;
        this.healthPoints = 60;
        this.defense = 30;
    }
}
