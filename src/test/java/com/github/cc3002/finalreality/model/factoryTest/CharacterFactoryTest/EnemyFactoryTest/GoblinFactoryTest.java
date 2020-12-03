package com.github.cc3002.finalreality.model.factoryTest.CharacterFactoryTest.EnemyFactoryTest;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.utils.characterFactories.EnemyFactory.GoblinFactory;

public class GoblinFactoryTest extends AbstractEFTest{
    @Override
    public void setName() {
        name = "Bokoblin";
    }

    @Override
    public void setFactoryCharacter() {
        factoryEnemy = new GoblinFactory(turns,name).make();
    }

    @Override
    public void setCharacter() {
        enemy = new Enemy(name,12,30,30,60,turns);
    }
}
