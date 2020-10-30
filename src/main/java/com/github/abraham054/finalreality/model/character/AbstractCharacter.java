package com.github.abraham054.finalreality.model.character;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractCharacter implements ICharacter {

  protected  final BlockingQueue<ICharacter> turnsQueue;
  protected ScheduledExecutorService scheduledExecutor;
  protected final String name;
  protected int healthPoints;
  private final int defense;

  /**
   * Creates a new abstract character.
   *
   * @param turnsQueue    the queue with the abstract characters waiting for their turn
   * @param name          the name of the abstract character
   * @param defense       the defense of the abstract character
   * @param healthPoints  the health points of the abstract character
   * */
  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, int defense, int healthPoints) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.defense = defense;
    this.healthPoints = healthPoints;
  }

  /**
   * Adds this character to the turns queue.
   */
  public void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  /**
   * The character receives damage
   * */
  public void receiveDamage(int damage){
    healthPoints -= damage - defense;
    if (healthPoints < 0){ healthPoints = 0; }

  }

  /**
   * Attacks an objective character
   * */
  protected abstract void attack(AbstractCharacter character);

  /**
   * Returns the health points of the abstract character.
   */
  @Override
  public int getHealthPoints(){ return healthPoints; }

  /**
   * Returns the defense of the abstract character.
   */
  @Override
  public int getDefense(){ return defense; }

  /**
   * Returns the abstract character's name
   * */
  @Override
  public String getName() { return name; }

}
