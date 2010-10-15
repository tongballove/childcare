/*
 * AppToolBar.java
 *
 * Created on August 24, 2006, 1:13 AM
 *
 */
package org.childcare.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JToolBar;
import org.edu.core.ui.factory.ToolBarFactory;

public class AppToolBar extends JToolBar implements ActionListener {

    private JButton item1, item2, item3;

    /** Creates a new instance of AppToolBar */
    public AppToolBar() {
        super();
        initAppToolBar();
    }

    public void initAppToolBar() {
        this.setFloatable(false);

        ToolBarFactory toolBarFactory = new ToolBarFactory("/org/childcare/app/images/toolbar/");

        item1 = toolBarFactory.createButton(this, "1.png", "Toolbar Item 1");
        this.add(item1);

        item2 = toolBarFactory.createButton(this, "2.png", "Toolbar Item 2");
        this.add(item2);
        this.add(toolBarFactory.createSeparator());

        item3 = toolBarFactory.createButton(this, "3.png", "Toolbar Item 3");
        this.add(item3);
    }

    public void actionPerformed(ActionEvent e) {
    }
}
