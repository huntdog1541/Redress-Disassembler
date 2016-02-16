package gui;

import abi.generic.abi.ABI;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.dockfx.*;
import org.dockfx.demo.DockFX;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by jamesrichardson on 2/15/16.
 */
public class MainController extends AnchorPane {
    public static final String CODEWINDOW_NAME = "Code Window";

    private final static Logger LOGGER = Logger.getLogger(MainController.class.getName());
    private static MainController mainController;
    private static final Image dockImage = new Image(DockFX.class.getResource("docknode.png").toExternalForm());

    private ABI abi;
    private CodePaneController codePaneController;
    private MenuBarController menuBarController;
    private DockNode codePaneDock;
    private Stage primaryStage;

    @FXML
    private AnchorPane content;
    @FXML
    private MenuBar menuBar;

    public static MainController getSharedMainController(){
        if(mainController == null) {
            mainController = new MainController();
        }
        return mainController;
    }

    private MainController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainController.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            //noinspection ProhibitedExceptionThrown
            throw new RuntimeException(exception);
        }
    }

    @FXML
    public void initialize() {
        DockPane dockPane = new DockPane();
        dockPane.prefWidthProperty().bind(content.widthProperty());
        dockPane.prefHeightProperty().bind(content.heightProperty());

        codePaneController= new CodePaneController();
        menuBarController = new MenuBarController(menuBar);

        codePaneDock = new DockNode(codePaneController,CODEWINDOW_NAME,new ImageView(dockImage));
        codePaneDock.setDockTitleBar(null);
        codePaneDock.setPrefSize(300, 100);
        codePaneDock.dock(dockPane, DockPos.BOTTOM);

        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        DockPane.initializeDefaultUserAgentStylesheet();

        content.getChildren().add(dockPane);

    }

    public Stage getPrimaryStage(){return primaryStage;}
    public void setPrimaryStage(Stage stage){this.primaryStage = stage;}
    public ABI getABI(){return abi;}
    public void setABI(ABI abi){this.abi = abi;}
    public CodePaneController getCodePaneController(){return codePaneController;}
    public MenuBarController getMenuBarController(){return menuBarController;}

}
