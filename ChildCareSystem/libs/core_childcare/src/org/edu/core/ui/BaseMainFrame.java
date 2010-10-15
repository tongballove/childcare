/*
 * BaseMainFrame.java
 *
 * Created on August 23, 2006, 10:13 PM
 *
 */
package org.edu.core.ui;

import org.edu.core.ui.mdi.BaseDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

public class BaseMainFrame extends JFrame {

    private JMenuBar menuBar;
    private JToolBar toolBar;
    private JPanel homePanel;
    private BaseDesktopPane desktopPane;
    private String applicationTitle;

    /** Creates a new instance of BaseMainFrame */
    public BaseMainFrame(String applicationTitle, JMenuBar menuBar, JToolBar toolBar, JPanel homePanel) {
        this.applicationTitle = applicationTitle;
        this.menuBar = menuBar;
        this.toolBar = toolBar;
        this.homePanel = homePanel;

        this.initComponents();
    }

    private void initComponents() {
        this.setTitle(this.applicationTitle);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setFont(new java.awt.Font("Tahoma", 0, 12));

        this.setJMenuBar(this.menuBar);
        this.getContentPane().add(this.toolBar, BorderLayout.NORTH);


        this.desktopPane = new BaseDesktopPane();
        this.desktopPane.setParent(this);
        this.desktopPane.registerMenuBar(this.menuBar);
        this.getDesktopPane().setHomeScreenPanel(this.homePanel);

        getContentPane().add(this.desktopPane, BorderLayout.CENTER);
        pack();

    }

    public BaseDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle = applicationTitle;
    }

    public void setDefaultTitle() {
        this.setTitle(this.applicationTitle);
    }

    public void setMDIModelTitle(String mdiFrameTitle) {
        this.setTitle(this.applicationTitle + " - " + mdiFrameTitle);
    }
}
