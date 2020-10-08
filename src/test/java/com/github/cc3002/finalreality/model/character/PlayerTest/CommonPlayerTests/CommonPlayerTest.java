package com.github.cc3002.finalreality.model.character.PlayerTest.CommonPlayerTests;

import com.github.cc3002.finalreality.model.character.AbstractCharacterTests;
import com.github.cc3002.finalreality.model.character.PlayerTest.AbstractPlayerTest;

public abstract class CommonPlayerTest extends AbstractPlayerTest {

    @Override
    public void setDefense() {
        defense = 15;
    }

    @Override
    public void setHealthPoints() {
        healthPoints = 100;
    }

}
