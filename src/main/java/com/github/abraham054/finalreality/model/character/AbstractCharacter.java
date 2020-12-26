package com.github.abraham054.finalreality.model.character;

import java.beans.PropertyChangeSupport;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import com.github.abraham054.finalreality.controller.handlers.IEventHandler;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractCharacter implements ICharacter {

  private final PropertyChangeSupport dyingEvent = new PropertyChangeSupport(this);
  protected final PropertyChangeSupport endTurnEvent = new PropertyChangeSupport(this);

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
   * The character receives damage until it's already dead
   * */
  public void receiveDamage(int damage){
    healthPoints -= damage - defense;
    if (healthPoints <= 0){
      healthPoints = 0;
      dyingEvent.firePropertyChange(name +" has died",null,this);
    }
  }

  /**
   * Attacks an objective character
   * */
  protected abstract void attack(AbstractCharacter character);

  public void addEndTurnListener(IEventHandler endTurnHandler) {
    endTurnEvent.addPropertyChangeListener(endTurnHandler);
  }

  public void addDeadListener(IEventHandler deadHandler){
    dyingEvent.addPropertyChangeListener(deadHandler);
  }

  @Override
  public abstract LinkedList<String> getStats();

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

  @Override
  public int hashCode() {
    return Objects.hash(getName(),getDefense(), getHealthPoints());
  }
}
