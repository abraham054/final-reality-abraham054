package com.github.cc3002.finalreality.model.gameControllerTest;

import com.github.abraham054.finalreality.controller.GameController;
import com.github.abraham054.finalreality.controller.exceptions.InvalidTransitionException;
import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Axe;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Knife;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Sword;
import com.github.abraham054.finalreality.model.weapon.magicWeapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

public class PhasesTest {
    protected GameController controller;

    @BeforeEach
    public void setWeapons(){
        controller = new GameController();
        controller.equipWeapon(4,new Staff("StaffM",12,0,0)); //Mago blanco equipa baston
        controller.equipWeapon(0,new Staff("StaffB",12,0,0)); //Mago oscuro equipa baston
        controller.equipWeapon(1,new Axe("Axe",13,0)); //Ingeniero equipa Hacha
        controller.equipWeapon(3,new Sword("Sword",15,0)); //Ladron equipa espada

    }

    @RepeatedTest(1)
    public void testPhases(){
        for (int i = 0; i < controller.getEnemies().size() - 1; i++) {
            controller.getEnemies().remove();
        }
        controller.tryStartTurn();
        controller.tryGoToMenu();
        controller.tryFight();
        controller.tryBeginCombat();
        try{
            controller.getPhase().toPlayerTurnPhase();
        }catch (InvalidTransitionException e){
            e.printStackTrace();
        }
        try{
            controller.getPhase().toEnemyTurnPhase();
        }catch (InvalidTransitionException e){
            e.printStackTrace();
        }
        controller.equipWeapon(2,new Knife("Knife",13,0)); //Caballero equipa cuchillo
        assertEquals("StartTurnsPhase",controller.getPhaseString());
        controller.tryBeginCombat();
        assertEquals("CheckQueuePhase",controller.getPhaseString());
        controller.tryBeginCombat();
        controller.tryStartTurn();
        try {
            controller.getPhase().toCheckQueuePhase();
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
        controller.tryGoToMenu();
        assertEquals("StartTurnsPhase",controller.getPhaseString());
        controller.tryBeginCombat();
        assertEquals("CheckQueuePhase",controller.getPhaseString());
        controller.tryStartTurn();
        try{
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controller.tryStartTurn();
        assertEquals("TurnPhase",controller.getPhaseString());
        controller.tryStartTurn();
        boolean allyAttacked = false;
        boolean enemyAttacked = false;
        for (ICharacter character :
                controller.getTurns()) {
            if(allyAttacked && enemyAttacked){
                break;
            }
            if(controller.getPhaseString().equals("CheckQueuePhase")){
                controller.tryStartTurn();
            }
            if(controller.isAllyTurn()){
                assertFalse(controller.tryEnemyAttack());
                controller.tryPlayerAttack();
                controller.tryFight();
                assertEquals("PlayerTurnPhase",controller.getPhaseString());
                assertTrue(controller.playerTurn());
                controller.tryPlayerAttack();
                allyAttacked = true;
            }else {
                controller.tryEnemyAttack();
                controller.tryFight();
                assertEquals("EnemyTurnPhase",controller.getPhaseString());
                assertFalse(controller.playerTurn());
                controller.tryEnemyAttack();
                enemyAttacked = true;
            }
        }
    }
}
