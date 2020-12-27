package com.github.abraham054.finalreality.controller.phases;

public class PlayerTurnPhase extends Phase{

    /**
     * Returns a string with the name of this phase.
     */
    @Override
    public String toString() {
        return "PlayerTurnPhase";
    }

    /**
     * Changes phase to check queue phase.
     */
    @Override
    public void toCheckQueuePhase(){
        changePhase(new CheckQueuePhase());
    }

    /**
     * makes the controller's selected ally attack then changes phase to check queue phase.
     */
    @Override
    public void attack(){
        controller.turnAttackAnEnemy();
        toCheckQueuePhase();
    }

    /**
     * Returns true now that a player can attack.
     */
    @Override
    public boolean canAttack() {
        return true;
    }
}
