package com.github.cc3002.finalreality.model.factoryTest.CharacterFactoryTest.PlayerFactoryTest;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.factoryTest.CharacterFactoryTest.ICharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractPCFTest implements ICharacterTest {
    protected AbstractPlayerCharacter playerCharacter;
    protected AbstractPlayerCharacter factoryCharacter;
    protected String name;
    protected int healthPoints;
    protected int defense;
    protected BlockingQueue<ICharacter> turns;

    public abstract void setName();

    public abstract void setFactoryCharacter();

    public abstract void setCharacter();

    @BeforeEach
    public void setUp(){
        setName();
        setFactoryCharacter();
        setCharacter();
    }

    @Test
    @Override
    public void testCharacter(){
        assertEquals(factoryCharacter.hashCode(),playerCharacter.hashCode());
    }
}
