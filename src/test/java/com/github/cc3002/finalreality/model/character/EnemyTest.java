package com.github.cc3002.finalreality.model.character;

import com.github.abraham054.finalreality.model.character.Enemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EnemyTest extends AbstractCharacterTests {

  private final int weight = 100;
  private final int attackPoints = 30;
  private Enemy enemy;

  @Override
  public void setName() {
    name = "Goblin";
  }

  @Override
  public void setDefense() {
    defense = 15;
  }

  @Override
  public void setHealthPoints() {
    healthPoints = 40;
  }

  @Override
  public void setAbstractCharacter() {
    testCharacter = new Enemy(name,weight,defense,attackPoints,healthPoints,turns);
  }

  @BeforeEach
  void setUpEnemy(){
    enemy = new Enemy(name,weight,defense,attackPoints,healthPoints,turns);
  }

  @Test
  void testEnemy(){
    assertEquals(weight,enemy.getWeight());
    assertEquals(attackPoints,enemy.getAttackPoints());
  }

  @Override
  @Test
  public void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    enemy.waitTurn();
    try {
      // Prueben disminuir este tiempo
      Thread.sleep(900);  // <----
      //
      Assertions.assertEquals(0, turns.size());
      // Prueben aumentar este tiempo
      Thread.sleep(200);  // <----
      //
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(enemy, turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}