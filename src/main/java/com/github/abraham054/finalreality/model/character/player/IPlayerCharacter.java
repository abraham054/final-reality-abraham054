package com.github.abraham054.finalreality.model.character.player;

import com.github.abraham054.finalreality.model.weapon.IWeapon;

public interface IPlayerCharacter {

    /**
     * Equips an IPlayer viable weapon.
     * */
    void equipWeapon(IWeapon weapon);

    /**
     * Returns the IPlayer's weapon.
     * */
    IWeapon getEquippedWeapon();

}
