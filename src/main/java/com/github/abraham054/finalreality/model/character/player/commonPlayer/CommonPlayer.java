package com.github.abraham054.finalreality.model.character.player.commonPlayer;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;


public class CommonPlayer extends PlayerCharacter {
    private final CommonPlayerClass commonClass;

    /**
     * Creates a new common character.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param defense
     *     the character's defense
     * @param healthPoints
     *     the character's health points
     * @param commonClass
     *     the character's not magic class
     */
    protected CommonPlayer(@NotNull String name,
                        @NotNull BlockingQueue<ICharacter> turnsQueue, int defense, int healthPoints,
                        CommonPlayerClass commonClass){
        super(turnsQueue, name,defense,healthPoints);
        this.commonClass = commonClass;
    }

    /**
     * Returns the class of the character.
     * */
    public CommonPlayerClass getCharacterClass() { return this.commonClass; }

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
