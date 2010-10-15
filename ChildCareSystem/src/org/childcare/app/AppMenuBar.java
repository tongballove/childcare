/*
 * AppMenuBar.java
 *
 * Created on August 24, 2006, 1:13 AM
 *
 */
package org.childcare.app;

import org.childcare.buss.panel.DanhmucPnl;
import org.childcare.buss.panel.NghiepvuPnl;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import org.childcare.ui.AddChildrenDlg;
import org.childcare.ui.AddChildrenPnl;
import org.childcare.ui.LoginDlg;
import org.edu.core.ui.factory.MenuBarFactory;
import org.edu.core.ui.mdi.BaseDesktopPane;
import org.edu.core.ui.mdi.IFWindowMenu;

public class AppMenuBar extends JMenuBar implements ActionListener, IFWindowMenu {

    private JMenu mnSystem, mnDanhmuc, mnNghiepvu, mnHienthi, mnTrogiup;
    private JMenuItem mniLogin, mniConfig, mniAccount, mniLogout, mniExit;
    private JMenuItem mniDanhmucA, mniDanhmucB, mniDanhmucC, mniDanhmucD, mniDanhmucE;
    private JMenuItem mniNghiepvuA, mniNghiepvuB, mniNghiepvuC;
    private JCheckBoxMenuItem mniStatusbar, mniToolbar;
    private JMenuItem mniTile, mniCascade, mniClose, mniCloseALl;
    private JMenuItem mniHelp, mniAbout;

    /** Creates a new instance of AppMenuBar */
    public AppMenuBar() {
        super();
        this.initAppMenuBar();
    }

    private void initAppMenuBar() {
        MenuBarFactory menuFactory = new MenuBarFactory("/org/childcare/app/images/menubar/",
                new Font("Tahoma", Font.PLAIN, 12));
        /**
         *
         * System
         */
        mnSystem = menuFactory.createMenu("System", KeyEvent.VK_H);
        mniLogin = menuFactory.createMenuItem(this, "Login", "login.png");
        mnSystem.add(mniLogin);

        mniConfig = menuFactory.createMenuItem(this, "Config System", "config.png");
        mnSystem.add(mniConfig);

        mniAccount = menuFactory.createMenuItem(this, "Account Management", "account.png");
        mnSystem.add(mniAccount);

        mniLogout = menuFactory.createMenuItem(this, "Logout", "login.png");
        mnSystem.add(mniLogout);
        mnSystem.addSeparator();

        mniExit = menuFactory.createMenuItem(this, "Exit", "exit.png");
        mnSystem.add(mniExit);

        /**
         *
         * Management
         */
        mnDanhmuc = menuFactory.createMenu("Management", KeyEvent.VK_D);
        mniDanhmucA = menuFactory.createMenuItem(this, "Management staff", "danhmuca.png");
        mnDanhmuc.add(mniDanhmucA);
        mnDanhmuc.addSeparator();

        mniDanhmucB = menuFactory.createMenuItem(this, "Management nannies", "danhmucb.png");
        mnDanhmuc.add(mniDanhmucB);

        mniDanhmucC = menuFactory.createMenuItem(this, "Management children", "danhmucc.png");
        mnDanhmuc.add(mniDanhmucC);

        mniDanhmucD = menuFactory.createMenuItem(this, "Management class", "danhmucc.png");
        mnDanhmuc.add(mniDanhmucD);

        mniDanhmucE = menuFactory.createMenuItem(this, "Management age-group", "danhmucc.png");
        mnDanhmuc.add(mniDanhmucE);

        /**
         *
         * Services
         */
        mnNghiepvu = menuFactory.createMenu("Services", KeyEvent.VK_N);
        mniNghiepvuA = menuFactory.createMenuItem(this, "Services A", "nghiepvua.png");
        mnNghiepvu.add(mniNghiepvuA);

        mniNghiepvuB = menuFactory.createMenuItem(this, "Services B", "nghiepvub.png");
        mnNghiepvu.add(mniNghiepvuB);
        mnNghiepvu.addSeparator();

        mniNghiepvuC = menuFactory.createMenuItem(this, "Services C", "nghiepvuc.png");
        mnNghiepvu.add(mniNghiepvuC);
        /**
         *
         * Display
         */
        mnHienthi = menuFactory.createMenu("Display", KeyEvent.VK_T);
        mniToolbar = menuFactory.createCheckBoxMenuItem(this, "Menu Bar");
        mniToolbar.setSelected(true);
        mnHienthi.add(mniToolbar);

        mniStatusbar = menuFactory.createCheckBoxMenuItem(this, "Menu Status");
        mniStatusbar.setSelected(true);
        mnHienthi.add(mniStatusbar);
        mnHienthi.addSeparator();

        mniTile = menuFactory.createMenuItem(this, "Tile", "tile.png");
        mnHienthi.add(mniTile);

        mniCascade = menuFactory.createMenuItem(this, "Cascade", "cascade.png");
        mnHienthi.add(mniCascade);
        mnHienthi.addSeparator();

        mniClose = menuFactory.createMenuItem(this, "Close Windows");
        mnHienthi.add(mniClose);

        mniCloseALl = menuFactory.createMenuItem(this, "Close All Windows");
        mnHienthi.add(mniCloseALl);

        /**
         *
         * Help
         */
        mnTrogiup = menuFactory.createMenu("Help", KeyEvent.VK_G);
        mniHelp = menuFactory.createMenuItem(this, "Help Content", "help.png");
        mnTrogiup.add(mniHelp);
        mnTrogiup.addSeparator();

        mniAbout = menuFactory.createMenuItem(this, "About", "about.png");
        mnTrogiup.add(mniAbout);

        this.add(mnSystem);
        this.add(mnDanhmuc);
        this.add(mnNghiepvu);
        this.add(mnHienthi);
        this.add(mnTrogiup);
    }

    public void actionPerformed(ActionEvent e) {
        BaseDesktopPane desktopPane = AppLauncher.applicatinFrame.getDesktopPane();
        if (e.getSource() == this.mniLogin) {
            LoginDlg logdlg = new LoginDlg(JOptionPane.getFrameForComponent(AppLauncher.applicatinFrame.getDesktopPane()), true);
            AppLauncher.applicatinFrame.getDesktopPane().showDialog(logdlg);
        } else if (e.getSource() == this.mniExit) {
            System.exit(0);
        } else if (e.getSource() == this.mniToolbar) {
            // Ẩn thanh toolbar
        } else if (e.getSource() == this.mniStatusbar) {
            // Ẩn thanh status bar
        } else if (e.getSource() == this.mniTile) {
            desktopPane.tile();
        } else if (e.getSource() == this.mniCascade) {
            desktopPane.cascade();
        } else if (e.getSource() == this.mniClose) {
            desktopPane.close();
        } else if (e.getSource() == this.mniCloseALl) {
            desktopPane.closeAll();
        } else if (e.getSource() == this.mniHelp) {
            // Help
        } else if (e.getSource() == this.mniAbout) {
            // About
        } else if ((e.getSource() == this.mniDanhmucA)) {
            String function = ((JMenuItem) e.getSource()).getText();
            desktopPane.addMDIFrame("MDI Frame: " + function, new AddChildrenPnl());
        } else if ((e.getSource() == this.mniNghiepvuA) || (e.getSource() == this.mniNghiepvuB) || (e.getSource() == this.mniNghiepvuC)) {
            String function = ((JMenuItem) e.getSource()).getText();
            desktopPane.addMDIFrame("MDI Frame: " + function, new NghiepvuPnl());
        }

    }

    public JMenu getWindowMenu() {
        return this.mnHienthi;
    }
}
