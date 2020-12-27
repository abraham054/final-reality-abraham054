package com.github.abraham054.finalreality.controller.phases;

import com.github.abraham054.finalreality.controller.GameController;
import com.github.abraham054.finalreality.controller.exceptions.InvalidTransitionException;
import com.github.abraham054.finalreality.controller.exceptions.InvalidTurnException;
import org.jetbrains.annotations.NotNull;

public abstract class Phase {
    protected GameController controller;

    /**
     * Sets the controller to a given one.
     */
    public void setController(final @NotNull GameController controller) {
        this.controller = controller;
    }

    /**
     * Changes the controller phase.
     */
    protected void changePhase(Phase phase) {
        controller.setPhase(phase);
    }

    /**
     * Check if the controller's turns is not empty, then return true if empty returns false.
     */
    protected boolean checkQueue(){
        return !controller.getTurns().isEmpty();
    }

    /**
     * Returns false because is this phase you can't attack.
     */
    public boolean canAttack(){
        return false;
    }

    /**
     * Throws an exception because you can't attack.
     */
    public void attack() throws InvalidTurnException{
        throw new InvalidTurnException("You cant attack right now");
    }

    /**
     * Throws an exception because you can't play a turn.
     */
    public void playTurn() throws InvalidTurnException {
        throw new InvalidTurnException("You cant play a turn now");
    }

    /**
     * Throws an exception because you can't start a turn.
     */
    public void StartTurns() throws InvalidTurnException {
        throw new InvalidTurnException("You cant queue the turns now");
    }

    /**
     * Throws an exception because you can't change to start turns phase.
     */
    public void toStartTurnsPhase() throws InvalidTransitionException{
        throw new InvalidTransitionException("Can't change from " + toString() + "to StartTurnsPhase.");
    }

    /**
     * Throws an exception because you can't change to check queue phase.
     */
    public void toCheckQueuePhase() throws InvalidTransitionException{
        throw new InvalidTransitionException("Can't change from " + toString() + "to CheckQueuePhase.");
    }

    /**
     * Throws an exception because you can't change to turn phase.
     */
    public void toTurnPhase() throws InvalidTransitionException{
        throw new InvalidTransitionException("Can't change from " + toString() + "to TurnPhase.");
    }

    /**
     * Throws an exception because you can't change to player turn phase.
     */
    public void toPlayerTurnPhase() throws InvalidTransitionException{
        throw new InvalidTransitionException("Can't change from " + toString() + "to PlayerTurnPhase.");
    }

    /**
     * Throws an exception because you can't change to enemy turn phase.
     */
    public void toEnemyTurnPhase() throws InvalidTransitionException{
        throw new InvalidTransitionException("Can't change from " + toString() + "to EnemyTurnPhase.");
    }

    /**
     * Returns a string with the name of the phase.
     */
    public abstract String toString();
}
