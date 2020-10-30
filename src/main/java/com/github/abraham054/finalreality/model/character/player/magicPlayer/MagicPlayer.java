package com.github.abraham054.finalreality.model.character.player.MagicPlayer;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.PlayerClasses.MagicPlayerClass;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public abstract class MagicPlayer extends PlayerCharacter {
    private final int mana;

    /**
     * Creates a new character.
     *
     * @param name          the character's name
     * @param turnsQueue    the queue with the characters waiting for their turn
     * @param defense       the character's defense
     * @param healthPoints  the character's health points
     * @param mana          the character's mana
     */
    public MagicPlayer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                       int defense, int healthPoints, int mana,MagicPlayerClass playerClass){
        super(turnsQueue, name,defense,healthPoints,playerClass);
        this.mana = mana;
    }

    /**
     * Returns the character's mana
     *  */
    public int getMana() {
        return this.mana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MagicPlayer)) {
            return false;
        }
        final MagicPlayer that = (MagicPlayer) o;
        return that.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass(),getName());
    }
}
