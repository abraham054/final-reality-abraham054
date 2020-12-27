package com.github.abraham054.finalreality.utils.weaponStates;

public class Occupied extends WeaponState{

    /**
     * The weapon isn't available therefore returns false.
     * */
    @Override
    public boolean isAvailable() {
        return false;
    }

    /**
     * Returns a string with the name of the weapon state.
     * */
    @Override
    public String toString() {
        return "not available";
    }
}
