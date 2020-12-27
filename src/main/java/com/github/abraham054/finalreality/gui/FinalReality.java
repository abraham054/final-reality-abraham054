package com.github.abraham054.finalreality.gui;

import com.github.abraham054.finalreality.controller.GameController;
import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class FinalReality extends Application {
    private final GameController controller = new GameController();
    private Stage stage;
    private boolean turnsRound = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final @NotNull Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("Final reality");
        primaryStage.setResizable(false);
        Scene gameScene = createMainScene();
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }

    /**
     * Creates the inventory menu scene.
     */
    private @NotNull Scene createMainScene() {
        Group newRoot = new Group();
        createCharSelButtons(newRoot);
        createInventoryButtons(newRoot);
        createInventoryLabels(newRoot);
        createAllyNames(newRoot, 100);
        createEnemiesNames(newRoot);
        createBeginBattleButton(newRoot);
        createStatsText(newRoot,10);
        showCurrentPhase(newRoot);
        return new Scene(newRoot, 1024, 460);
    }

    /**
     * Creates the combat scene.
     */
    private @NotNull Scene createCombatScene(){
        Group newRoot = new Group();
        createAllyNames(newRoot, 10);
        createEnemiesNames(newRoot);
        createHptext(newRoot);
        showCurrentPhase(newRoot);
        createEnemySelButton(newRoot);
        createEnemyStatsText(newRoot);
        createNextButton(newRoot);
        showCurrentPhase(newRoot);
        createGotoMainButton(newRoot);
        if(controller.playerTurn()){
            createAttackButton(newRoot);
            createTurnPlayerStats(newRoot);
        }
        return new Scene(newRoot, 1024, 460);
    }

    /**
     * Creates the defeat scene.
     */
    private Scene createDefeatScene() {
        Group newRoot = new Group();
        createLabel(500,230,newRoot,"Derrota");
        return new Scene(newRoot, 1024, 460);
    }

    /**
     * Creates the victory scene.
     */
    private Scene createVictoryScene() {
        Group newRoot = new Group();
        createLabel(500,230,newRoot,"Victoria");
        return new Scene(newRoot, 1024, 460);
    }

    /**
     * Creates a button that makes you change to the inventory menu if able.
     */
    private void createGotoMainButton(Group root){
        Button gotoMain = createButton(500,200, root);
        gotoMain.setText("Volver al menu de inventario");
        gotoMain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(controller.getTurns().isEmpty() && turnsRound){
                    controller.tryGoToMenu();
                    Scene mainScene = createMainScene();;
                    stage.setScene(mainScene);
                    turnsRound = false;
                }
                else{
                    refreshCombatScreen();
                    Label aviso = createLabel(350,100, (Group) stage.getScene().getRoot(),
                            "Aun quedan turnos por los que pasar antes de volver al menu de inventario");
                }
            }
        });
    }

    /**
     * Creates labels that tells you the stats from a player in the turns head.
     */
    private void createTurnPlayerStats(Group root) {
        LinkedList<String> stats = controller.getTurns().peek().getStats();
        for (int i = 0; i < stats.size(); i++) {
            String stat = stats.get(i);
            createLabel(100,250+40*(i), root,stat);
        }
    }

    /**
     * Creates an attack button that makes the player in the turns head attack a selected enemy.
     */
    private void createAttackButton(Group root){
        Button attackButton = createButton(500,250, root);
        attackButton.setText("attack the objective");
        attackButton.setOnAction(event -> controller.tryPlayerAttack());
        attackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controller.tryPlayerAttack();
                refreshCombatScreen();
            }
        });
    }

    /**
     * Creates a label that shows the hp form the allies.
     */
    private void createHptext(Group root) {
        LinkedList<AbstractPlayerCharacter> playerCharacters = controller.getPlayerCharacters();
        for (int i = 0; i < playerCharacters.size(); i++) {
            String health = controller.getPlayerStats(i).get(2);
            createLabel(100,35+40*(i),root,health);
        }
    }

    /**
     * Creates a button that makes you progress in the combat scene.
     */
    private void createNextButton(Group root) {
        Button nextTurnButton = createButton(10,250, root);
        nextTurnButton.setText("Next");
        nextTurnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                refreshCombatScreen();
                controller.tryStartTurn();
                controller.tryFight();
                if(!controller.getTurns().isEmpty()){
                    turnsRound = true;
                }
                if(controller.tryEnemyAttack()){
                    createLabel(350,100,(Group) stage.getScene().getRoot(),"Un enemigo ataco a un aliado");
                }
                if(controller.deadEnemies()){
                    refreshVictoryScene();
                }
                if(controller.deadAllies()){
                    refreshDefeatScene();
                }
            }
        });
    }

    /**
     * Creates a label.
     */
    private @NotNull Label createLabel(int xPos, int yPos, Group root,String message) {
        Label label = new Label();
        label.setLayoutX(xPos);
        label.setLayoutY(yPos);
        label.setText(message);
        root.getChildren().add(label);
        return label;
    }

    /**
     * Creates a button.
     */
    private @NotNull Button createButton(int xPos, int yPos, Group root) {
        Button button = new Button();
        button.setLayoutX(xPos);
        button.setLayoutY(yPos);
        root.getChildren().add(button);
        return button;
    }

    /**
     * Creates a button that makes you go to the combat scene if able.
     */
    private void createBeginBattleButton(Group root){
        Button battleButton = createButton(500,200, root);
        battleButton.setText("Iniciar combate");
        battleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(controller.allTeamEquipped()){
                    controller.tryBeginCombat();
                    Scene battleScene = createCombatScene();;
                    stage.setScene(battleScene);
                }
                else{
                    refreshMainScreen();
                    Label aviso = createLabel(350,100, (Group) stage.getScene().getRoot(),
                            "Aun no se puede iniciar combate, equipar a todos los aliados primero");
                }
            }
        });
    }

    /**
     * Creates labels that show you the name of your allies.
     */
    private void createAllyNames(Group root,int xOffset){
        LinkedList<AbstractPlayerCharacter> playerCharacters = controller.getPlayerCharacters();
        for (int i = 0; i < playerCharacters.size(); i++) {
            String name = controller.getPlayerStats(i).getFirst();
            createLabel(xOffset,35+40*(i),root,name);
        }
    }

    /**
     * Creates labels that show you the name of the enemies.
     */
    private void createEnemiesNames(Group root){
        LinkedList<Enemy> enemies = controller.getEnemies();
        for (int i = 0; i < enemies.size(); i++) {
            String name = controller.getEnemyStats(i).getFirst();
            createLabel(900,35+40*(i),root,name);
        }
    }

    /**
     * Creates a button that makes you select a player.
     */
    private void createCharSelButtons(Group root) {
        LinkedList<AbstractPlayerCharacter> playerCharacters = controller.getPlayerCharacters();
        for (int i = 0; i < playerCharacters.size(); i++) {
            Button charSelection = createButton(10,30+40*i,root);
            charSelection.setText("Selecciona:");
            int finalI = i;
            charSelection.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    controller.selectAlly(finalI);
                    refreshMainScreen();
                }
            });
        }
    }

    /**
     * Creates a button that makes you select an enemy.
     */
    private void createEnemySelButton(Group root){
        LinkedList<Enemy> enemies = controller.getEnemies();
        for (int i = 0; i < enemies.size(); i++) {
            Button charSelection = createButton(800,30+40*i,root);
            charSelection.setText("Selecciona:");
            int finalI = i;
            charSelection.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    controller.selectEnemy(finalI);
                    refreshCombatScreen();
                }
            });
        }
    }

    /**
     * Refresh the victory scene.
     */
    private void refreshVictoryScene(){
        Scene victoryScene = createVictoryScene();
        stage.setScene(victoryScene);
    }

    /**
     * Refresh the defeat scene.
     */
    private void refreshDefeatScene(){
        Scene lostScene = createDefeatScene();
        stage.setScene(lostScene);
    }

    /**
     * Refresh the inventory menu scene.
     */
    private void refreshMainScreen(){
        Scene refreshedScene = createMainScene();
        stage.setScene(refreshedScene);
    }

    /**
     * Refresh the combat scene.
     */
    private void refreshCombatScreen(){
        Scene refreshedScene = createCombatScene();
        stage.setScene(refreshedScene);
        if(!controller.deadEnemies()){
            controller.selectEnemy(0);
        }
        if(controller.getTurns().isEmpty() && turnsRound){
            createLabel(500,230, (Group) refreshedScene.getRoot(),"Se acabaron los turnos, regrese al menu de seleccion");
        }
    }

    /**
     * Creates a label that shows the controller's current phase.
     */
    private void showCurrentPhase(Group root){
        Label phaseLabel = createLabel(20, 435, root,controller.getPhaseString());
    }

    /**
     * Creates labels that shows you an ally stats.
     */
    private void createStatsText(Group root,int xOffset){
        LinkedList<String> stats = controller.getSelectedAlly().getStats();
        for (int i = 0; i < stats.size(); i++) {
            String stat = stats.get(i);
            createLabel(xOffset,250+40*(i), root,stat);
        }
    }

    /**
     * Creates labels that shows you an enemy stats.
     */
    private void createEnemyStatsText(Group root){
        LinkedList<String> stats = controller.getSelectedEnemy().getStats();
        for (int i = 0; i < stats.size(); i++) {
            String stat = stats.get(i);
            createLabel(800,250+40*(i), root,stat);
        }
    }

    /**
     * Creates labels that show you your inventory weapon's stats.
     */
    private void createInventoryLabels(Group root){
        int yOffset = 300;
        int xOffset = 200;
        LinkedList<String> context = new LinkedList<>();
        context.add("Name: ");
        context.add("Weight: ");
        context.add("Damage: ");
        context.add("Magic damage: ");
        context.add("State: ");
        for (int i = 0; i< controller.getInventory().size(); i++){
            LinkedList<String> stats = controller.getWeaponStats(i);
            for (int j = 0; j < stats.size(); j++){
                if(stats.size() == 4 && j == 3){
                    createLabel(xOffset+140*i,yOffset + 30 * j,root,context.get(j+1)+ stats.get(j));
                }
                else{
                    createLabel(xOffset+140*i,yOffset + 30 * j,root,context.get(j)+ stats.get(j));
                }
            }
        }
    }

    /**
     * Creates a button that allows you to select a weapon an equip it.
     */
    private void createInventoryButtons(Group root){
        for (int i = 0; i < controller.getInventory().size(); i++) {
            Button equipWeapon = createButton(200+140*i, 260, root);
            equipWeapon.setText("Equipar arma");
            int finalI = i;
            equipWeapon.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    controller.equipSelectedAlly(controller.getInventory().get(finalI));
                    refreshMainScreen();
                }
            });
        }
    }

}