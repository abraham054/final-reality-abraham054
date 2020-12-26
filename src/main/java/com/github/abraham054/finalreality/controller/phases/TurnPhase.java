package com.github.abraham054.finalreality.controller.phases;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;

public class TurnPhase extends Phase{

    @Override
    public String toString() {
        return "TurnPhase";
    }

    @Override
    public void toPlayerTurnPhase() {
        changePhase(new PlayerTurnPhase());
    }

    @Override
    public void toEnemyTurnPhase() {
        changePhase(new EnemyTurnPhase());
    }

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
