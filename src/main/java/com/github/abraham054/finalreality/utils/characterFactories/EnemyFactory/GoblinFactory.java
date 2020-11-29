package com.github.abraham054.finalreality.utils.characterFactories.EnemyFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;

public class GoblinFactory extends EnemyFactory{
   public GoblinFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.weight = 12;
        this.attackPoints = 30;
        this.healthPoints = 60;
        this.defense = 30;
    }
}
