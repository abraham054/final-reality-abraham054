package com.github.abraham054.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Your name>
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
  private final int attackPoints;

  /**
   * Creates a new enemy.
   * @param name          the enemy's name
   * @param weight        the enemy's weight
   * @param defense       the enemy's defense
   * @param attackPoints  the enemy's attack points
   * @param healthPoints  the enemy's health points
   * @param turnsQueue    the queue with the enemy waiting for their turn
   */
  public Enemy(@NotNull final String name, final int weight,final int defense,final int attackPoints,
      int healthPoints,
      @NotNull final BlockingQueue<ICharacter> turnsQueue) {
    super(turnsQueue, name,defense,healthPoints);
    this.weight = weight;
    this.attackPoints = attackPoints;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() { return weight; }

  /**
   * Returns the attack points of the enemy.
   * */
  public int getAttackPoints() { return attackPoints; }

  /**
   * Sets a scheduled executor to make this enemy (thread) wait for {@code weight / 10}
   * seconds before adding the enemy to the queue.
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
            .schedule(this::addToQueue, this.getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return enemy.hashCode() == hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }

}
