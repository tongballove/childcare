/*
 * MDIWindowButton.java
 *
 * Created on August 23, 2006, 10:59 PM
 *
 */
package org.edu.core.ui.mdi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MDIWindowButton extends JButton {

    /** Constant indicating close button type */
    public static final int CLOSE_BUTTON = 1000;
    /** Constant indicating restore button type */
    public static final int RESTORE_BUTTON = 2000;
    /** Constant indicating iconify button type */
    public static final int ICONIFY_BUTTON = 3000;
    /**
     * Indicates the current type of button will be always one
     * of <code>MDIWindowButton.CLOSE_BUTTON</code> , <code>MDIWindowButton.RESTORE_BUTTON</code> or
     * <code>MDIWindowButton.ICONIFY_BUTTON</code>. Note it is a readonly property. Once set in
     * constructor it should not be changed.
     */
    protected int buttonType;
    /**
     * This icon is used when there is no mouse foucs on the button.
     */
    protected Icon buttonIcon = null;
    /**
     * This icon is used when there is mouse foucs on the button when <code>mouseOverEnabled</code> is set to <code>true</code>.
     */
    protected Icon mouseOverIcon = null;
    /**
     * This property is used to toggle the rollover icon feature for the button.
     */
    private boolean mouseOverIconEnabled = true;
    /**
     * This is the instance of MouseOverListener that is
     * used for the roll over icon effect. Note that the
     * default rollOverIcon feature provided by the basic JButton
     * is not sufficient for MDIWindowButton because of focus
     * problems presented by the fact that as soon as the
     * iconify or restore button is clicked the buttons
     * are removed and then they don't get the subsequent
     * mouse out event.
     */
    private MouseOverListener mouseOverListener = new MouseOverListener();

    /**
     * Creates a new instance of MDIWindowButton
     */
    public MDIWindowButton(int type) {
        super();
        this.buttonType = type;

        switch (this.buttonType) {
            case MDIWindowButton.ICONIFY_BUTTON:
                buttonIcon = new ImageIcon(getClass().getResource("/org/edu/core/images/window/FrameMinimize.png"));
                mouseOverIcon = new ImageIcon(getClass().getResource("/org/edu/core/images/window/FrameMinimizeRollover.png"));
                break;
            case MDIWindowButton.RESTORE_BUTTON:
                buttonIcon = new ImageIcon(getClass().getResource("/org/edu/core/images/window/FrameRestore.png"));
                mouseOverIcon = new ImageIcon(getClass().getResource("/org/edu/core/images/window/FrameRestoreRollover.png"));
                break;
            case MDIWindowButton.CLOSE_BUTTON:
                buttonIcon = new ImageIcon(getClass().getResource("/org/edu/core/images/window/FrameClose.png"));
                mouseOverIcon = new ImageIcon(getClass().getResource("/org/edu/core/images/window/FrameCloseRollover.png"));
        }

        this.setIcon(buttonIcon);
        Dimension size = new Dimension(16, 16);
        this.setPreferredSize(size);
        this.setBorderPainted(false);
        this.setOpaque(false);

        //The following sentence just sets an transperent color
        //to the button to support ocean theme.
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        this.setFocusPainted(false);
        this.setFocusable(false);

        this.addMouseListener(mouseOverListener);
    }

    /**
     * Gives the icon used for the button.
     * @return Returns the buttonIcon.
     */
    public Icon getButtonIcon() {
        return buttonIcon;
    }

    /**
     * Sets the icon for the button. Note that this method
     * uses <code>JButton.setIcon()</code> to set the icon.
     * So you don't have to call it again.
     * @param buttonIcon The buttonIcon to set.
     */
    public void setButtonIcon(Icon buttonIcon) {
        this.buttonIcon = buttonIcon;
        this.setIcon(buttonIcon);
    }

    /**
     * Gives the roll over icon for the button.
     * @return Returns the mouseOverIcon.
     */
    public Icon getMouseOverIcon() {
        return mouseOverIcon;
    }

    /**
     * Sets the roll over icon for the button. Note that
     * <code>MDIWindowButton</code> has its own imlementation of roll over icon
     * feature seperate from basic roll over icon functionality
     * provided by the <code>JButton</code> class.
     * <P>
     * To enable roll over icon feature you must call
     * <code>MDIFrameButtonInstance.set setMouseOverIconEnabled(true)</code>
     * 
     * @param mouseOverIcon The mouseOverIcon to set.
     * @see MDIWindowButton#setMouseOverIconEnabled(boolean)
     */
    public void setMouseOverIcon(Icon mouseOverIcon) {
        this.mouseOverIcon = mouseOverIcon;
    }

    /**
     * This method is used to toggle the roll over icon feature
     * for the button. Note that the
     * default rollOverIcon feature provided by the basic JButton
     * is not sufficient for MDIWindowButton because of focus
     * problems presented by the fact that as soon as the
     * iconify or restore button is clicked, the buttons
     * are removed and then they don't get the subsequent
     * mouse out event.
     * 
     * 
     * @param mouseOverIconEnabled The mouseOverIconEnabled to set.
     */
    public void setMouseOverIconEnabled(boolean mouseOverIconEnabled) {
        this.mouseOverIconEnabled = mouseOverIconEnabled;
    }

    /**
     * gives the type of the button.
     * 
     * @return Returns the button Type, always one
     * of <code>MDIWindowButton.CLOSE_BUTTON</code> , <code>MDIWindowButton.RESTORE_BUTTON</code> or
     * <code>MDIWindowButton.ICONIFY_BUTTON</code>.
     */
    public int getButtonType() {
        return buttonType;
    }

    /**
     * The MouseListener implemetation that provides the
     * roll over icon feature for the MDIWindowButton
     * 
     * @author Pritam G. Barhate
     */
    class MouseOverListener extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            if (mouseOverIconEnabled) {
                MDIWindowButton.this.setIcon(mouseOverIcon);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (mouseOverIconEnabled) {
                MDIWindowButton.this.setIcon(buttonIcon);
            }
        }

        /**
         * Note that the default rollOverIcon feature provided by the basic JButton
         * is not sufficient for MDIWindowButton because of focus
         * problems presented by the fact that as soon as the
         * iconify or restore button is clicked, the buttons
         * are removed and then they don't get the subsequent
         * mouse out event. To overcome this problem the
         * mouse released event is used to set the normal
         * button Icon for the button.
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            if (mouseOverIconEnabled) {
                MDIWindowButton.this.setIcon(buttonIcon);
            }
        }
    }
}
