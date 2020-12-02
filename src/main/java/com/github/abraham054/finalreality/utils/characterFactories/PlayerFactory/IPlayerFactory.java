package com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory;

import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;

public interface IPlayerFactory {

    /**
     * Creates a new Player character.
     * */
    AbstractPlayerCharacter make();
}
