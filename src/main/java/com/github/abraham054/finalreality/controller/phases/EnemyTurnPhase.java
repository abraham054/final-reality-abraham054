package com.github.abraham054.finalreality.controller.phases;

public class EnemyTurnPhase extends Phase{

    /**
     * Returns a string with the name of this phase.
     */
    @Override
    public String toString() {
        return "EnemyTurnPhase";
    }

    /**
     * Changes phase to check queue phase.
     */
    @Override
    public void toCheckQueuePhase(){
        changePhase(new CheckQueuePhase());
    }

    /**
     * makes the controller's selected enemy attack then changes phase to check queue phase.
     */
    @Override
    public void attack(){
        controller.turnAttackAPlayer();
        toCheckQueuePhase();
    }
}
