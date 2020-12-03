package com.github.cc3002.finalreality.model.factoryTest.CharacterFactoryTest.EnemyFactoryTest;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.utils.characterFactories.EnemyFactory.TrollFactory;

public class TrollFactoryTest extends AbstractEFTest{
    @Override
    public void setName() {
        name = "Troll de las montañas";
    }

    @Override
    public void setFactoryCharacter() {
        factoryEnemy = new TrollFactory(turns,name).make();
    }

    @Override
    public void setCharacter() {
        enemy = new Enemy(name,17,40,50,150,turns);
    }
}
