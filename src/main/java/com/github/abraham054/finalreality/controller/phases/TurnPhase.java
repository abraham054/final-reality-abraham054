package com.github.abraham054.finalreality.controller.phases;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;

public class TurnPhase extends Phase{

    /**
     * Returns a string with the name of this phase.
     */
    @Override
    public String toString() {
        return "TurnPhase";
    }

    /**
     * Changes phase to player turn phase.
     */
    @Override
    public void toPlayerTurnPhase() {
        changePhase(new PlayerTurnPhase());
    }

    /**
     * Changes phase to enemy turn phase.
     */
    @Override
    public void toEnemyTurnPhase() {
        changePhase(new EnemyTurnPhase());
    }

    /**
     * Check if it's now an ally turn, if so goes to player turn phase.
     * if it's an enemy turn goes to enemy turn phase.
     */
    @Override
    public void playTurn(){
        if (controller.isAllyTurn()){
            controller.allyTurn();
            controller.selectAlly(controller.getPlayerCharacters().indexOf(controller.getTurnsHead()));
            toPlayerTurnPhase();
        }
        else{
            toEnemyTurnPhase();
        }
    }
}
