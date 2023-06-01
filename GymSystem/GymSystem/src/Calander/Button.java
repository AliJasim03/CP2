package Calander;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * Custom rounded Button
 *
 * @author RAVEN
 */
public final class Button extends JButton {

    /**
     * Returns whether or not the background should be painted. This is
     * determined by the value of #getPaintBackground ().
     *
     *
     * @return whether or not the background should be painted in the frame or
     * not ( default is false )
     */
    public boolean isPaintBackground() {
        return paintBackground;
    }

    /**
     * Sets whether or not the background should be painted. This is useful for
     * determining if we are going to draw a background or not
     *
     * @param paintBackground - true if the background should be
     */
    public void setPaintBackground(boolean paintBackground) {
        this.paintBackground = paintBackground;
    }

    private Event event;
    private boolean paintBackground = true;
    private Color colorSelected;

    /**
     * Called when the mouse is pressed. This is the event handler for the mouse
     * button. It checks if the text is day or year and if so calls event.
     * execute ( me Integer. valueOf ( text )).
     *
     * me - The MouseEvent that triggered this method call. This will be
     * null
     */
    public Button() {
        setBorder(null);
        setContentAreaFilled(false);
        setFocusable(false);
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                // Set the text and name of the button.
                if (!getText().equals("") && getName() != null) {
                    // If the name is day or year
                    if (getName().equals("day") || getName().equals("year")) {
                        event.execute(me, Integer.valueOf(getText()));
                    } else {
                        event.execute(me, Integer.valueOf(getName()));
                    }
                    setBackground(getColorSelected());
                    setForeground(new Color(255, 255, 255));
                }
            }
        });
    }

    /**
     * Returns the event associated with this Event. This will be null if there
     * is no event associated with this Event.
     *
     *
     * @return the Event associated with this Event or null if there is no event
     * associated with this Event ( for example if the Event is an instance of
     * Event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Sets the event to be sent to the event bus. This is useful for sending
     * events to the bus as they are handled in the EventBus
     *
     * @param event - the event to be
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * Paints the component. If paintBackground is true the component will be
     * painted in the center of the screen.
     *
     * @param grphcs - the graphics context to paint with ( never null
     */
    @Override
    public void paint(Graphics grphcs) {
        // Draw the background if paintBackground is true.
        if (paintBackground) {
            int width = getWidth();
            int height = getHeight();
            int size = Math.min(width, height);
            int x = (width - size) / 2;
            int y = (height - size) / 2;
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillOval(x, y, size, size);
        }
        super.paint(grphcs);
    }

    /**
     * Returns the color selected. Note that this is a copy of the color that
     * was selected by the user.
     *
     *
     * @return the color selected by the user or null if none was selected by
     * the user ( in this case the user is not able to select a color
     */
    public Color getColorSelected() {
        return colorSelected;
    }

    /**
     * Sets the color of the currently selected item. Note that this is a
     * property of the Item that can be changed by the user.
     *
     * @param colorSelected - The color of the currently selected item. If null
     * the color will be set to the default
     */
    public void setColorSelected(Color colorSelected) {
        this.colorSelected = colorSelected;
    }
}
