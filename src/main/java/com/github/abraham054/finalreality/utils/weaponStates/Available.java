package com.github.abraham054.finalreality.utils.weaponStates;

public class Available extends WeaponState{
    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String toString() {
        return "is available";
    }
}
