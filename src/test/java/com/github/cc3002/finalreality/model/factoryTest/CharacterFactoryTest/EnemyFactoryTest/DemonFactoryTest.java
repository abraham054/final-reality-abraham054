package com.github.cc3002.finalreality.model.factoryTest.CharacterFactoryTest.EnemyFactoryTest;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.utils.characterFactories.EnemyFactory.DemonFactory;

public class DemonFactoryTest extends AbstractEFTest{
    @Override
    public void setName() {
        name = "Roba almas";
    }

    @Override
    public void setFactoryCharacter() {
        factoryEnemy = new DemonFactory(turns,name).make();
    }

    @Override
    public void setCharacter() {
        enemy = new Enemy(name,14,20,65,100,turns);
    }
}
