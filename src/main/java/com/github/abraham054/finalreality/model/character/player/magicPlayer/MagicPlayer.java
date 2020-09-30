package com.github.abraham054.finalreality.model.character.player.magicPlayer;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class MagicPlayer extends PlayerCharacter {
    private final MagicPlayerClass magicClass;
    private static int mana;

    /**
     * Creates a new character.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param defense
     *     the character's defense
     * @param healthPoints
     *     the character's health points
     * @param magicClass
     *     the character's magic class
     * @param mana
     *     the character's mana
     */
    public MagicPlayer(@NotNull String name,
                       @NotNull BlockingQueue<ICharacter> turnsQueue, int defense, int healthPoints,
                       MagicPlayerClass magicClass, int mana){
        super(turnsQueue, name,defense,healthPoints);
        this.magicClass = magicClass;
        MagicPlayer.mana = mana;
    }

    /**
     * The magic character equips a magic weapon
     * */
    public void equipMagicWeapon(MagicWeapon weapon) {
        equippedWeapon = weapon;
    }

    /**
     * Returns the character's mana
     *  */
    public static int getMana() {
        return mana;
    }

    /**
     * Returns the class of the character.
     * */
    public MagicPlayerClass getCharacterClass() { return this.magicClass; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MagicPlayer)) {
            return false;
        }
        final MagicPlayer that = (MagicPlayer) o;
        return getCharacterClass() == that.getCharacterClass()
                && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass());
    }
}
