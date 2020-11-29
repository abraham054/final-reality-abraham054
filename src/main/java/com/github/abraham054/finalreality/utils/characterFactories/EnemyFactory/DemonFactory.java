package com.github.abraham054.finalreality.utils.characterFactories.EnemyFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;

public class DemonFactory extends EnemyFactory{
    public DemonFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.weight = 14;
        this.attackPoints = 65;
        this.healthPoints = 100;
        this.defense = 20;
    }
}
