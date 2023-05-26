/**
 * A custom Button class that extends JButton and overrides the paintComponent method
 * to create a custom appearance with a darker background when the mouse is pressed.
 *
 * @author RAVEN
 * @since 1.0
 */
package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * Constructs a new Button with default settings.
 */
public class Button extends JButton {

    private boolean mousePress;

    /**
     * Constructs a new Button with the specified content and default settings.
     *
     * @param content the button's content
     */
    public Button() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(7, 5, 7, 5));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    mousePress = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    mousePress = false;
                }
            }
        });
    }

    /**
     * Overrides the paintComponent method to customize the appearance of the
     * button. This method is called when the button needs to be repainted.
     *
     * @param g the Graphics object used for painting
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (mousePress) {
            g2.setColor(getBackground().darker());
        } else {
            g2.setColor(getBackground());
        }
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), getHeight(), getHeight()));
        g2.dispose();
        super.paintComponent(grphcs);
    }

}
