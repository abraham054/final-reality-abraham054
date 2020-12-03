package com.github.cc3002.finalreality.model.factoryTest.CharacterFactoryTest.EnemyFactoryTest;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.factoryTest.CharacterFactoryTest.ICharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractEFTest implements ICharacterTest {
    protected Enemy enemy;
    protected Enemy factoryEnemy;
    protected String name;
    protected BlockingQueue<ICharacter> turns;

    public abstract void setName();

    public abstract void setFactoryCharacter();

    public abstract void setCharacter();

    @BeforeEach
    void setUp(){
        setName();
        setFactoryCharacter();
        setCharacter();
    }

    @Test
    @Override
    public void testCharacter(){
        assertEquals(factoryEnemy.hashCode(),enemy.hashCode());
    }
}
