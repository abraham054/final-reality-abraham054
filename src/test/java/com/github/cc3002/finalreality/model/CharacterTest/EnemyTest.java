package com.github.cc3002.finalreality.model.CharacterTest;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Engineer;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Knight;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest extends AbstractCharacterTests {

  private final int weight = 100;
  private final int attackPoints = 15;
  private Enemy bigEnemy;
  private Enemy smallEnemy;
  private Knight arthas;

  @Override
  public void setName() {
    name = "Goblin";
  }

  @Override
  public void setDefense() {
    defense = 20;
  }

  @Override
  public void setHealthPoints() {
    healthPoints = 50;
  }

  @Override
  public void setAbstractCharacter() {
    testCharacter = new Enemy(name,weight,defense,attackPoints,healthPoints,turns);
  }

  @BeforeEach
  void setUpCharacters(){
    smallEnemy = new Enemy("Small",60,10,15,30,turns);
    arthas = new Knight("Arthas",turns,50,200);
    bigEnemy = new Enemy(name,weight,defense,attackPoints,healthPoints,turns);
  }

  @Test
  void testEnemy(){
    assertEquals(weight, bigEnemy.getWeight());
    assertEquals(attackPoints, bigEnemy.getAttackPoints());
    assertTrue(testCharacter.equals(bigEnemy));
    assertTrue(bigEnemy.equals(bigEnemy));
    assertFalse(bigEnemy.equals(smallEnemy));
    assertFalse(bigEnemy.equals(arthas));
    assertEquals(bigEnemy.hashCode(),testCharacter.hashCode());
  }

  @Test
  @Override
  public void waitTurnTest() {
    assertTrue(turns.isEmpty());
    bigEnemy.waitTurn();
    try {
      // Prueben disminuir este tiempo
      Thread.sleep(900);  // <----
      //
      Assertions.assertEquals(0, turns.size());
      // Prueben aumentar este tiempo
      Thread.sleep(600);  // <----
      //
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(bigEnemy, turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}