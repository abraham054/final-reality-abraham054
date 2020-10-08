package com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicClasses;
import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicPlayer;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicPlayerClass;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class WhiteMage extends MagicPlayer {
    /**
     * Creates a new character.
     *
     * @param name         the character's name
     * @param turnsQueue   the queue with the characters waiting for their turn
     * @param defense      the character's defense
     * @param healthPoints the character's health points
     * @param mana         the character's mana
     */
    public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int defense, int healthPoints, int mana) {
        super(name, turnsQueue, defense, healthPoints, mana);
        this.magicClass = MagicPlayerClass.WHITE_MAGE;
    }
}