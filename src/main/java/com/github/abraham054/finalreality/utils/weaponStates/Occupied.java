package com.github.abraham054.finalreality.utils.weaponStates;

public class Occupied extends WeaponState{
    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public String toString() {
        return "not available";
    }
}
