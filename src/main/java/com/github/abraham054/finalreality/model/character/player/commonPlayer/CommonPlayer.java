package com.github.abraham054.finalreality.model.character.player.commonPlayer;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.PlayerClasses.CommonPlayerClass;
import com.github.abraham054.finalreality.model.character.player.PlayerClasses.PlayerClasses;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;


public abstract class CommonPlayer extends PlayerCharacter {

    /**
     * Creates a new common character.
     *
     * @param name          the character's name
     * @param turnsQueue    the queue with the characters waiting for their turn
     * @param defense       the character's defense
     * @param healthPoints  the character's health points
     */
    protected CommonPlayer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                           int defense, int healthPoints,CommonPlayerClass playerClass){
        super(turnsQueue, name,defense,healthPoints,playerClass);
    }

    /**
     * Returns the class of the character.
     * */
    public PlayerClasses getCharacterClass() { return this.playerClass; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommonPlayer)) {
            return false;
        }
        final CommonPlayer that = (CommonPlayer) o;
        return getCharacterClass() == that.getCharacterClass()
                && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass());
    }
}
