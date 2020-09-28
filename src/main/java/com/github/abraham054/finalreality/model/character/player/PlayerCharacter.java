package com.github.abraham054.finalreality.model.character.player;

import com.github.abraham054.finalreality.model.character.AbstractCharacter;
import com.github.abraham054.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.github.abraham054.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class PlayerCharacter extends AbstractCharacter {

  private final CharacterClass characterClass;
  private static Weapon equippedWeapon = null;
  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   * @param defense
   *     the character's defense
   * @param healthPoints
   *     the character's health points
   */
  public PlayerCharacter(@NotNull String name,
      @NotNull BlockingQueue<ICharacter> turnsQueue,
      final CharacterClass characterClass,int defense,int healthPoints) {
    super(turnsQueue, name,defense,healthPoints);
    this.characterClass = characterClass;
  }

  /**
   * The character equips a weapon
   * */
  public void equip(Weapon weapon) { PlayerCharacter.equippedWeapon = weapon; }

  /**
   * Returns the character's equipped weapon
   * */
  public static Weapon getEquippedWeapon() { return PlayerCharacter.equippedWeapon; }

  /**
   * Returns the class of the character.
   * */
  public CharacterClass getCharacterClass() { return this.characterClass; }

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  @Override
  public void waitTurn() {
    scheduledExecutor.
            schedule(AbstractCharacter::addToQueue,getEquippedWeapon().getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerCharacter)) {
      return false;
    }
    final PlayerCharacter that = (PlayerCharacter) o;
    return getCharacterClass() == that.getCharacterClass()
        && getName().equals(that.getName());
  }

}
