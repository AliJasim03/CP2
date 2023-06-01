package ComboBox;

import javax.swing.JComboBox;

/**
 * Custom ComboBox class
 *
 * @author RAVEN
 */
public class ComboBoxSuggestion<E> extends JComboBox<E> {
    //defualt constructor 
    public ComboBoxSuggestion() {
        setUI(new ComboSuggestionUI());
    }
}
