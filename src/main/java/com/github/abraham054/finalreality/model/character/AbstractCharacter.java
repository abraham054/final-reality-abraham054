package com.github.abraham054.finalreality.model.character;

import com.github.abraham054.finalreality.model.character.player.CharacterClass;
import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractCharacter implements ICharacter {

  protected  final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  private static int healthPoints;
  private final int defense;
  protected ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new abstract character.
   * @param turnsQueue
   *     the queue with the abstract characters waiting for their turn
   * @param name
   *     the name of the abstract character
   * @param defense
   *     the defense of the abstract character
   * @param healthPoints
   *     the health points of the abstract character
   * */
  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, int defense, int healthPoints) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.defense = defense;
    AbstractCharacter.healthPoints = healthPoints;
  }

  /**
   * Adds this character to the turns queue.
   */
  public void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

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
