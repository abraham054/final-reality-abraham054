package com.github.abraham054.finalreality.utils.weaponStates;

public abstract class WeaponState {
    /**
     * Returns true if the weapon is available, false if not.
     * */
    public abstract boolean isAvailable();

    /**
     * Returns a string with the name of the weapon state.
     * */
    public abstract String toString();
}
