package com.github.abraham054.finalreality.model.character.player;

import com.github.abraham054.finalreality.model.character.AbstractCharacter;
import com.github.abraham054.finalreality.model.character.ICharacter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import com.github.abraham054.finalreality.model.character.player.PlayerClasses.PlayerClasses;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class PlayerCharacter extends AbstractCharacter {
  protected Weapon equippedWeapon = null;
  protected final PlayerClasses playerClass;

  /**
   * Creates a new character.
   *
   * @param name          the character's name
   * @param turnsQueue    the queue with the characters waiting for their turn
   * @param defense       the character's defense
   * @param healthPoints  the character's health points
   * @param playerClass   the character's class
   */
  protected PlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                            @NotNull String name, int defense, int healthPoints,PlayerClasses playerClass) {
    super(turnsQueue, name,defense,healthPoints);
    this.playerClass = playerClass;
  }

  /**
   * Returns the class of the character.
   * */
  public PlayerClasses getCharacterClass() { return this.playerClass; }

  /**
   * The character equips a weapon
   * */
  public abstract void equipWeapon(Weapon weapon);

  /**
   * Returns the character's equipped weapon
   * */
  public Weapon getEquippedWeapon() { return this.equippedWeapon; }

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

}
