package com.github.abraham054.finalreality.model.character.player;

import com.github.abraham054.finalreality.controller.handlers.IEventHandler;
import com.github.abraham054.finalreality.model.character.AbstractCharacter;
import com.github.abraham054.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeSupport;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import com.github.abraham054.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter{
  protected IWeapon equippedWeapon = null;
  private final PropertyChangeSupport beginTurnEvent = new PropertyChangeSupport(this);


  /**
   * Creates a new player character.
   *  @param turnsQueue    the queue with the characters waiting for their turn
   * @param name          the character's name
   * @param defense       the character's defense
   * @param healthPoints  the character's health points
   */
  protected AbstractPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                                    @NotNull String name, int defense, int healthPoints) {
    super(turnsQueue, name,defense,healthPoints);
  }

  @Override
  public boolean isAlly() {
    return true;
  }

  /**
   * Returns the player character's equipped weapon
   * */
  @Override
  public IWeapon getEquippedWeapon() { return equippedWeapon; }


  /**
   * Attacks an objective character when having a weapon and being alive
   * */
  @Override
  public void attack(AbstractCharacter character){
    if(healthPoints > 0 && equippedWeapon != null) {
      int damage = getEquippedWeapon().getDamage();
      character.receiveDamage(damage);
      endTurnEvent.firePropertyChange(name + " has attacked",null,this);
    }
  }

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.
            schedule(this::addToQueue, getEquippedWeapon().getWeight() / 10, TimeUnit.SECONDS);
  }

  public void addBeginTurnListener(IEventHandler beginTurnHandler) {
    beginTurnEvent.addPropertyChangeListener(beginTurnHandler);
  }

  public void isTurn() {
    beginTurnEvent.firePropertyChange(name + "turn has started",null,this);
  }
}
