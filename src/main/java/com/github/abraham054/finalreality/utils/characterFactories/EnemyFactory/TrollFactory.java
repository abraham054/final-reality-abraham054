package com.github.abraham054.finalreality.utils.characterFactories.EnemyFactory;

import com.github.abraham054.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;

public class TrollFactory extends EnemyFactory{
    public TrollFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
        this.weight = 17;
        this.attackPoints = 50;
        this.healthPoints = 150;
        this.defense = 40;
    }
}
