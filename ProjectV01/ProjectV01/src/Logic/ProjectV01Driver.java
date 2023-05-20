package Logic;

import FileManager.FileManager;
import GUI.MainPage;
import java.io.IOException;


/**
 *
 * @author alija
 */
public class ProjectV01Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //MainPage frame = new testingFrameCodes();
        MainPage frame = new MainPage();
        // set the initially invisible testingFrameCodes to // visible - also from the Component class
        frame.setVisible(true);
    }
}
