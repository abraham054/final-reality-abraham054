package com.github.cc3002.finalreality.model.characterTest;

import com.github.abraham054.finalreality.model.character.AbstractCharacter;
import com.github.abraham054.finalreality.model.character.ICharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;;
import java.util.concurrent.BlockingQueue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public abstract class AbstractCharacterTests implements ICharacterTest{

    protected BlockingQueue<ICharacter> turns;
    protected AbstractCharacter testCharacter;
    protected String name;
    protected int defense;
    protected int healthPoints;

    public abstract void setName();

    public abstract void setDefense();

    public abstract void setHealthPoints();

    public abstract void setAbstractCharacter();

    @BeforeEach
    public void setUp(){
        setName();
        setDefense();
        setHealthPoints();
        setAbstractCharacter();
    }

    @Test
    @Override
    public void testName() { assertEquals(name, testCharacter.getName());}

    @Test
    @Override
    public void testDefense() { assertEquals(defense, testCharacter.getDefense());}

    @Test
    @Override
    public void testHealthPoint() { assertEquals(healthPoints, testCharacter.getHealthPoints());}
}
