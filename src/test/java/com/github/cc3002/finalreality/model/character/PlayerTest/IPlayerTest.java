package com.github.cc3002.finalreality.model.character.PlayerTest;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.weapon.Weapon;

import java.util.concurrent.BlockingQueue;

public interface IPlayerTest {

    void setPlayer();
    void setWeapon(Weapon weapon);

    void testClass();
    void testWeapon();
    void waitTurnTest();

}
