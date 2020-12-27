package com.github.abraham054.finalreality.utils.weaponStates;

public class Available extends WeaponState{

    /**
     * The weapon is available therefore returns true.
     * */
    @Override
    public boolean isAvailable() {
        return true;
    }

    /**
     * Returns a string with the name of the weapon state.
     * */
    @Override
    public String toString() {
        return "is available";
    }
}
