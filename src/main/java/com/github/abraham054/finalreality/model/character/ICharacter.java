package com.github.abraham054.finalreality.model.character;

import java.util.LinkedList;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns the name of the character.
   */
  String getName();

  /**
   * Returns the defense of the character.
   */
  int getDefense();

  /**
   * Returns the health points of the character.
   */
  int getHealthPoints();

  /**
   * Returns true if the character is a player character, if it's an enemy returns false.
   */
  boolean isAlly();

  /**
   * Returns a list with the stats of the character.
   */
  LinkedList<String> getStats();

}
