package com.github.cc3002.finalreality.model.characterTest;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.player.CommonPlayer.CommonClasses.Knight;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest extends AbstractCharacterTests {

  private final int weight = 18;
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
    arthas = new Knight("Arthas",turns,50,200);
    smallEnemy = new Enemy(name,weight-10,defense,attackPoints,healthPoints,turns);
    turns = new LinkedBlockingQueue<>();
    bigEnemy = new Enemy(name,weight,defense,attackPoints,healthPoints,turns);
  }

  @Test
  void testEnemy(){
    assertEquals(weight, bigEnemy.getWeight());
    assertEquals(attackPoints, bigEnemy.getAttackPoints());
  }

  @Test
  void equals(){
    assertTrue(testCharacter.equals(bigEnemy));
    assertTrue(testCharacter.equals(testCharacter));
    assertFalse(testCharacter.equals(arthas));
    assertFalse(testCharacter.equals(smallEnemy));
    assertEquals(testCharacter.hashCode(),bigEnemy.hashCode());
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
      Thread.sleep(200);  // <----
      //
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(bigEnemy, turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}