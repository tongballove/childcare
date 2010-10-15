/*
 * HomePnl.java
 *
 * Created on August 26, 2006, 1:34 PM
 *
 */
package org.childcare.buss.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nguy?n Anh Minh
 * E-mail : anhminhnguyen@gmail.com
 * Skype: nguyen.anhminh
 */
public class HomePnl extends JPanel {

    public static final int TILED = 0;
    public static final int SCALED = 1;
    public static final int ACTUAL = 2;
    private BufferedImage image;
    private int style;
    private float alignmentX = 0.5f;
    private float alignmentY = 0.5f;

    /** Creates a new instance of HomePnl */
    public HomePnl(BufferedImage image, int style) {
        this.image = image;
        this.style = style;
        this.initComponents();
    }

    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        lblTitle = new JLabel();

        setLayout(new GridBagLayout());

        lblTitle.setFont(new Font("Tahoma", 0, 24));
        lblTitle.setForeground(new Color(0, 0, 255));
        lblTitle.setText("ChildCare Management System");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(lblTitle, gridBagConstraints);
    }

    public void setImageAlignmentX(float alignmentX) {
        this.alignmentX = alignmentX > 1.0f ? 1.0f : alignmentX < 0.0f ? 0.0f : alignmentX;
    }

    public void setImageAlignmentY(float alignmentY) {
        this.alignmentY = alignmentY > 1.0f ? 1.0f : alignmentY < 0.0f ? 0.0f : alignmentY;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image == null) {
            return;
        }

        switch (style) {
            case TILED:
                drawTiled(g);
                break;

            case SCALED:
                Dimension d = getSize();
                g.drawImage(image, 0, 0, d.width, d.height, null);
                break;

            case ACTUAL:
                drawActual(g);
                break;
        }
    }

    private void drawTiled(Graphics g) {
        Dimension d = getSize();
        int width = image.getWidth(null);
        int height = image.getHeight(null);

        for (int x = 0; x < d.width; x += width) {
            for (int y = 0; y < d.height; y += height) {
                g.drawImage(image, x, y, null, null);
            }
        }
    }

    private void drawActual(Graphics g) {
        Dimension d = getSize();
        float x = (d.width - image.getWidth()) * alignmentX;
        float y = (d.height - image.getHeight()) * alignmentY;
        g.drawImage(image, (int) x, (int) y, this);
    }
    private JLabel lblTitle;
}
