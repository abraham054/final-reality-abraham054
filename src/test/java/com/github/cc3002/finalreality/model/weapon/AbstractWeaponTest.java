package com.github.cc3002.finalreality.model.weapon;

import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.WeaponType.WeaponType;
import com.github.cc3002.finalreality.model.weapon.IWeaponTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractWeaponTest implements IWeaponTest {
    protected Weapon testedWeapon;
    protected String name;
    protected int weight;
    protected int damage;
    protected WeaponType type;

    public abstract void setName();

    public abstract void setWeight();

    public abstract void setDamage();

    public abstract void setType();

    public abstract void setTestedWeapon();

    @BeforeEach
    public void setUp(){
        setTestedWeapon();
        setName();
        setWeight();
        setDamage();
        setType();
    }

    @Test
    @Override
    public void testName(){
        assertEquals(name,testedWeapon.getName());
    }

    @Test
    @Override
    public void testWeight(){
        assertEquals(weight,testedWeapon.getWeight());
    }

    @Test
    @Override
    public void testDamage(){
        assertEquals(damage,testedWeapon.getDamage());
    }

    @Test
    @Override
    public void testType(){
        assertEquals(type,testedWeapon.getType());
    }

}
