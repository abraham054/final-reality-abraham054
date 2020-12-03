package com.github.cc3002.finalreality.model.factoryTest.WeaponFactoryTest;

import com.github.abraham054.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractWFTest implements IWeaponFactoryTest {

    protected IWeapon weapon;
    protected IWeapon factoryWeapon;
    protected String name;

    public abstract void setName();

    @BeforeEach
    void setUp(){
        setName();
        setWeapon();
        setFactoryWeapon();
    }

    @Test
    @Override
    public void testWeapon(){
        assertEquals(factoryWeapon.hashCode(),weapon.hashCode());
    }

}
