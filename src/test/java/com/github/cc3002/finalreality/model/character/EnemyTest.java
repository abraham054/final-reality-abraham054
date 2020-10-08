package com.github.cc3002.finalreality.model.character;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicPlayer;
import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
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
  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(ENEMY_NAME, 10,10,10,10, turns));
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 10,10,10,10, turns),
        testCharacters.get(0),
        new Enemy(ENEMY_NAME, 11,10,10,10, turns),
        new PlayerCharacter(ENEMY_NAME, turns, MagicPlayer.THIEF));
  }
}