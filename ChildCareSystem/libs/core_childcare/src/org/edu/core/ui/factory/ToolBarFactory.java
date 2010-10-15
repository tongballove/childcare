/*
 * ToolBarFactory.java
 *
 * Created on August 24, 2006, 10:43 PM
 *
 */
package org.edu.core.ui.factory;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class ToolBarFactory {

    protected String baseImagePath;
    protected Border inactive = new EmptyBorder(3, 3, 3, 3);
    protected Insets insets = new Insets(4, 4, 4, 4);

    /**
     * Creates a new instance of ToolBarFactory
     */
    public ToolBarFactory() {
    }

    public ToolBarFactory(String baseImagePath) {
        this.setBaseImagePath(baseImagePath);
    }

    public JButton createButton(ActionListener listener, String icon, String tooltip) {
        ToolBarButton button = new ToolBarButton(false);

        // set button icon
        if (!icon.trim().equals("")) {
            button.setIcon(this.createImageIcon(icon));
        }

        button.setBorder(this.inactive);
        button.setMargin(this.insets);
        button.setToolTipText(tooltip);
        button.setRequestFocusEnabled(false);
        button.addActionListener(listener);

        return button;
    }

    public JButton createButton(ActionListener listener, String icon, String tooltip, String name, boolean visible) {
        ToolBarButton button = new ToolBarButton(false);

        // set button icon
        if (!icon.trim().equals("")) {
            button.setIcon(this.createImageIcon(icon));
        }

        button.setBorder(this.inactive);
        button.setMargin(this.insets);
        button.setToolTipText(tooltip);
        button.setRequestFocusEnabled(false);
        button.addActionListener(listener);
        button.setName(name);
        button.setVisible(visible);

        return button;
    }

    public JButton createSeparator() {
        ToolBarButton button = new ToolBarButton(true);

        button.setIcon(this.createSeparatorIcon());

        button.setBorder(this.inactive);
        button.setMargin(this.insets);
        button.setRequestFocusEnabled(false);

        return button;
    }

    public void setBaseImagePath(String baseImagePath) {
        this.baseImagePath = baseImagePath;
    }

    protected ImageIcon createImageIcon(String icon) {
        return new ImageIcon(getClass().getResource(baseImagePath + icon));
    }

    protected ImageIcon createSeparatorIcon() {
        return new ImageIcon(getClass().getResource("/org/edu/core/images/toolbar/separator.png"));
    }

    class ToolBarButton extends JButton implements MouseListener {

        private Border border = ToolBarFactory.this.inactive;
        private Border raised = new SoftBevelBorder(BevelBorder.RAISED);
        private Border lowered = new SoftBevelBorder(BevelBorder.LOWERED);

        private ToolBarButton(boolean isSeparator) {
            super();
            if (!isSeparator) {
                this.addMouseListener(this);
            }
        }

        @Override
        public float getAlignmentY() {
            return 0.5f;
        }

        @Override
        public Border getBorder() {
            return this.border;
        }

        @Override
        public Insets getInsets() {
            return ToolBarFactory.this.insets;
        }

        public void mouseClicked(MouseEvent e) {
            // Do nothing
        }

        public void mousePressed(MouseEvent e) {
            this.border = this.lowered;
            this.setBorder(this.lowered);
        }

        public void mouseReleased(MouseEvent e) {
            this.border = ToolBarFactory.this.inactive;
            this.setBorder(ToolBarFactory.this.inactive);
        }

        public void mouseEntered(MouseEvent e) {
            this.border = this.raised;
            this.setBorder(this.raised);
        }

        public void mouseExited(MouseEvent e) {
            this.border = ToolBarFactory.this.inactive;
            this.setBorder(ToolBarFactory.this.inactive);
        }
    }
}
