package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicPlayer;
import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 * @see PlayerCharacter
 */
class PlayerCharacterTest extends AbstractCharacterTest {

  private static final String BLACK_MAGE_NAME = "Vivi";
  private static final String KNIGHT_NAME = "Adelbert";
  private static final String WHITE_MAGE_NAME = "Eiko";
  private static final String ENGINEER_NAME = "Cid";
  private static final String THIEF_NAME = "Tifa";
  private Map<MagicPlayer, String> characterNames;

  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    characterNames = new EnumMap<>(MagicPlayer.class);
    characterNames.put(MagicPlayer.BLACK_MAGE, BLACK_MAGE_NAME);
    characterNames.put(MagicPlayer.KNIGHT, KNIGHT_NAME);
    characterNames.put(MagicPlayer.WHITE_MAGE, WHITE_MAGE_NAME);
    characterNames.put(MagicPlayer.ENGINEER, ENGINEER_NAME);
    characterNames.put(MagicPlayer.THIEF, THIEF_NAME);

    for (var characterClass :
        characterNames.keySet()) {
      testCharacters.add(
          new PlayerCharacter(characterNames.get(characterClass), turns, characterClass));
    }
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var enemy = new Enemy("Enemy", 10, turns);
    for (var character :
        testCharacters) {
      var characterClass = character.getCharacterClass();
      var characterName = characterNames.get(characterClass);
      checkConstruction(new PlayerCharacter(characterName, turns, characterClass),
          character,
          new PlayerCharacter("Test", turns, characterClass),
          new PlayerCharacter(characterName, turns,
              characterClass == MagicPlayer.THIEF ? MagicPlayer.BLACK_MAGE
                  : MagicPlayer.THIEF));
      assertNotEquals(character, enemy);
    }

  }

  @Test
  void equipWeaponTest() {
    for (var character :
        testCharacters) {
      assertNull(character.getEquippedWeapon());
      character.equip(testWeapon);
      assertEquals(testWeapon, character.getEquippedWeapon());
    }
  }
}
