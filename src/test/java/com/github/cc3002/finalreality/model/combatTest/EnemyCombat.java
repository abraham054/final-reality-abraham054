package com.github.cc3002.finalreality.model.combatTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyCombat extends AbstractCombat{

    @Override
    public void setHealths() {
        healthEnemyFighter = 20;
        healthCharFighter = 200;
    }

    @Test
    @Override
    public void testFight() {
        /* Attacks and do 90 damage */
        testEnemyFighter.attack(testCharFighter);
        assertEquals(110,testCharFighter.getHealthPoints());
        /* Receives enough damage to get killed */
        testEnemyFighter.receiveDamage(40);
        assertEquals(0,testEnemyFighter.getHealthPoints());
        /* Can't attack without hp */
        testEnemyFighter.attack(testCharFighter);
        assertEquals(110,testCharFighter.getHealthPoints());
    }

}
