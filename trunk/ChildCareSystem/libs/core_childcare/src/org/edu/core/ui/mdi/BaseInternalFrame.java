/*
 * BaseInternalFrame.java
 *
 * Created on August 23, 2006, 10:13 PM
 *
 */
package org.edu.core.ui.mdi;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class BaseInternalFrame extends JInternalFrame {

    private JRadioButtonMenuItem linkingMenuItem;
    private JComponent titlePanel;
    private JPanel contentPanel;
    private int mdiType;
    // MDIChild default heigh&width
    private static final int INI_WIDTH = 625;
    private static final int INI_HEIGHT = 471;
    public static final int PANEL = 0;
    public static final int REPORT = 1;

    public BaseInternalFrame(String title, JPanel contentPanel) {
        super("", true, true, true, true);
        this.setTitle(title);
        this.contentPanel = contentPanel;
        this.initComponents();
    }

    private void initComponents() {
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/org/edu/core/images/mdi.png")));
        titlePanel = ((BasicInternalFrameUI) this.getUI()).getNorthPane();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        linkingMenuItem = new JRadioButtonMenuItem(title);
        linkingMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 12));
        linkingMenuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if (isSelected()) {
                    return;
                }
                try {
                    if (isIcon()) {
                        setIcon(false);
                    }
                    setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
            }
        });

        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(contentPanel, gridBagConstraints);
    }

    public JComponent getTitlePane() {
        return this.titlePanel;
    }

    public JRadioButtonMenuItem getLinkingMenuItem() {
        return this.linkingMenuItem;
    }

    public Component getContentPanel() {
        return this.contentPanel;
    }

    public int getMDIType() {
        return this.mdiType;
    }

    public void setMDIType(int mdiType) {
        this.mdiType = mdiType;
    }
}
