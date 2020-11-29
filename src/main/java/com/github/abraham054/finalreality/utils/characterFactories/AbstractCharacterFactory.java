package com.github.abraham054.finalreality.utils.characterFactories;

import com.github.abraham054.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractCharacterFactory {

    protected final BlockingQueue<ICharacter> turnsQueue;
    protected final String name;
    protected int healthPoints;
    protected int defense;

    public AbstractCharacterFactory(BlockingQueue<ICharacter> turnsQueue, String name){
        this.turnsQueue = turnsQueue;
        this.name = name;
    }
}
