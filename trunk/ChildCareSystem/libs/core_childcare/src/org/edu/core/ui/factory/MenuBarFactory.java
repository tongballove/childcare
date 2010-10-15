/*
 * MenuBarFactory.java
 *
 * Created on August 24, 2006, 10:43 PM
 *
 */
package org.edu.core.ui.factory;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBarFactory {

    protected Font font;
    protected String baseImagePath;

    /**
     * Creates a new instance of MenuBarFactory
     */
    public MenuBarFactory() {
    }

    public MenuBarFactory(String baseImagePath) {
        this.setBaseImagePath(baseImagePath);
    }

    public MenuBarFactory(String baseImagePath, Font font) {
        this.setBaseImagePath(baseImagePath);
        this.setFont(font);
    }

    public JMenu createMenu(String text) {
        JMenu menu = new JMenu(text);

        if (this.font != null) {
            menu.setFont(this.font);
        }

        return menu;
    }

    public JMenu createMenu(String text, int mmemonic) {
        JMenu menu = new JMenu(text);

        if (this.font != null) {
            menu.setFont(this.font);
        }

        if (mmemonic != -1) {
            menu.setMnemonic(mmemonic);
        }

        return menu;
    }

    public JMenu createMenu(String text, String icon, int mmemonic, String name, boolean visible) {
        JMenu menu = new JMenu(text);

        if (mmemonic != -1) {
            menu.setMnemonic(mmemonic);
        }

        if (this.font != null) {
            menu.setFont(this.font);
        }

        if (!icon.trim().equals("")) {
            menu.setIcon(this.createImageIcon(icon));
        } else {
            menu.setIcon(this.createEmptyImageIcon());
        }

        menu.setName(name);
        menu.setVisible(visible);

        return menu;
    }

    public JMenuItem createMenuItem(ActionListener listener, String text) {
        JMenuItem menuItem = new JMenuItem(text);

        if (this.font != null) {
            menuItem.setFont(this.font);
        }

        // set menu icon
        menuItem.setIcon(this.createEmptyImageIcon());
        menuItem.addActionListener(listener);

        return menuItem;
    }

    public JMenuItem createMenuItem(ActionListener listener, String text, String icon) {
        JMenuItem menuItem = new JMenuItem(text);

        if (this.font != null) {
            menuItem.setFont(this.font);
        }

        // set menu icon
        if (!icon.trim().equals("")) {
            menuItem.setIcon(this.createImageIcon(icon));
        } else {
            menuItem.setIcon(this.createEmptyImageIcon());
        }

        menuItem.addActionListener(listener);

        return menuItem;
    }

    public JMenuItem createMenuItem(ActionListener listener, String text, String icon, int mnemonic, int shortcut, String name, boolean visible) {
        JMenuItem menuItem = new JMenuItem(text);

        if (this.font != null) {
            menuItem.setFont(this.font);
        }

        // set item mnemonic
        if (mnemonic != -1) {
            menuItem.setMnemonic(mnemonic);
        }

        // set menu icon
        if (!icon.trim().equals("")) {
            menuItem.setIcon(this.createImageIcon(icon));
        } else {
            menuItem.setIcon(this.createEmptyImageIcon());
        }

        // set the alt-Shortcut accelerator
        if (shortcut != -1) {
            menuItem.setAccelerator(
                    KeyStroke.getKeyStroke(
                    shortcut, ActionEvent.CTRL_MASK));
        }

        menuItem.addActionListener(listener);
        menuItem.setName(name);
        menuItem.setVisible(visible);

        return menuItem;
    }

    public JCheckBoxMenuItem createCheckBoxMenuItem(ActionListener listener, String text) {
        JCheckBoxMenuItem menuItem = new JCheckBoxMenuItem(text);

        if (this.font != null) {
            menuItem.setFont(this.font);
        }

        menuItem.addActionListener(listener);

        return menuItem;
    }

    public JCheckBoxMenuItem createCheckBoxMenuItem(ActionListener listener, String text, String name, boolean visible) {
        JCheckBoxMenuItem menuItem = new JCheckBoxMenuItem(text);

        if (this.font != null) {
            menuItem.setFont(this.font);
        }

        menuItem.addActionListener(listener);
        menuItem.setName(name);
        menuItem.setVisible(visible);

        return menuItem;
    }

    protected ImageIcon createImageIcon(String icon) {
        return new ImageIcon(getClass().getResource(baseImagePath + icon));
    }

    protected ImageIcon createEmptyImageIcon() {
        return new ImageIcon(getClass().getResource(baseImagePath + "transparent.png"));
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setBaseImagePath(String baseImagePath) {
        this.baseImagePath = baseImagePath;
    }
}
