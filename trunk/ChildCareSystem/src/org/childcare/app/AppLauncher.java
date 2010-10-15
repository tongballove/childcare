/*
 * AppLauncher.java
 *
 * Created on August 24, 2006, 1:13 AM
 *
 */
package org.childcare.app;

import org.childcare.buss.panel.HomePnl;
import com.jgoodies.looks.HeaderStyle;
import com.jgoodies.looks.Options;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.ExperienceBlue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.UIManager;
import org.edu.core.ui.BaseMainFrame;

public class AppLauncher {

    private String applicationTitle = "ChildCare Management System";
    public static BaseMainFrame applicatinFrame;

    /** Creates a new instance of AppLauncher */
    public AppLauncher() {
        try {
            AppMenuBar menuBar = new AppMenuBar();
            menuBar.putClientProperty(Options.HEADER_STYLE_KEY, HeaderStyle.BOTH);

            AppToolBar toolBar = new AppToolBar();
            toolBar.putClientProperty("JToolBar.isRollover", Boolean.TRUE);
            toolBar.putClientProperty(Options.HEADER_STYLE_KEY, HeaderStyle.BOTH);

            BufferedImage image = ImageIO.read(getClass().getResource("/org/childcare/app/images/home.jpg"));
            JPanel homePanel = new HomePnl(image, HomePnl.SCALED);

            applicatinFrame = new BaseMainFrame(applicationTitle, menuBar, toolBar, homePanel);
            applicatinFrame.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent evt) {
                    System.exit(0);
                }
            });
        } catch (Exception ex) {
            System.out.println("Lỗi thực thi ứng dụng!");
        }
    }

    private void launchingApplication() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                applicatinFrame.setExtendedState(applicatinFrame.getExtendedState() | BaseMainFrame.MAXIMIZED_BOTH);
                applicatinFrame.setVisible(true);
            }
        });
    }

    public static void main(String args[]) {
        try {
            // JGoodies Look and Feel
            PlasticLookAndFeel laf = new Plastic3DLookAndFeel();
            PlasticLookAndFeel.setCurrentTheme(new ExperienceBlue());
            UIManager.setLookAndFeel(laf);
        } catch (Exception ex) {
        }

        AppLauncher launcher = new AppLauncher();
        launcher.launchingApplication();
    }
}
