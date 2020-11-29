package com.github.abraham054.finalreality.utils.characterFactories.EnemyFactory;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.utils.characterFactories.AbstractCharacterFactory;

import java.util.concurrent.BlockingQueue;

public class EnemyFactory extends AbstractCharacterFactory implements IEnemyFactory {

    protected int weight;
    protected int attackPoints;

    protected EnemyFactory(BlockingQueue<ICharacter> turnsQueue, String name) {
        super(turnsQueue, name);
    }

    @Override
    public Enemy make() {
        return new Enemy(name,weight,defense,attackPoints,healthPoints,turnsQueue);
    }
}
