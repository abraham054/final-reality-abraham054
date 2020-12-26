package com.github.abraham054.finalreality.controller.phases;

import com.github.abraham054.finalreality.controller.GameController;
import com.github.abraham054.finalreality.controller.exceptions.InvalidTransitionException;
import com.github.abraham054.finalreality.controller.exceptions.InvalidTurnException;
import org.jetbrains.annotations.NotNull;

public abstract class Phase {
    protected GameController controller;

    public void setController(final @NotNull GameController controller) {
        this.controller = controller;
    }

    protected void changePhase(Phase phase) {
        controller.setPhase(phase);
    }

    protected boolean checkQueue(){
        return !controller.getTurns().isEmpty();
    }

    public boolean canAttack(){
        return false;
    }

    public void attack() throws InvalidTurnException{
        throw new InvalidTurnException("You cant attack right now");
    }

    public void playTurn() throws InvalidTurnException {
        throw new InvalidTurnException("You cant play a turn now");
    }

    public void StartTurns() throws InvalidTurnException {
        throw new InvalidTurnException("You cant queue the turns now");
    }

    public void toStartTurnsPhase() throws InvalidTransitionException{
        throw new InvalidTransitionException("Can't change from " + toString() + "to StartTurnsPhase.");
    }

    public void toCheckQueuePhase() throws InvalidTransitionException{
        throw new InvalidTransitionException("Can't change from " + toString() + "to CheckQueuePhase.");
    }

    public void toTurnPhase() throws InvalidTransitionException{
        throw new InvalidTransitionException("Can't change from " + toString() + "to TurnPhase.");
    }

    public void toPlayerTurnPhase() throws InvalidTransitionException{
        throw new InvalidTransitionException("Can't change from " + toString() + "to PlayerTurnPhase.");
    }

    public void toEnemyTurnPhase() throws InvalidTransitionException{
        throw new InvalidTransitionException("Can't change from " + toString() + "to EnemyTurnPhase.");
    }

    public abstract String toString();
}
