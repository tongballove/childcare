/*
 * BaseDesktopPane.java
 *
 * Created on August 23, 2006, 10:13 PM
 *
 */
package org.edu.core.ui.mdi;

import org.edu.core.ui.BaseMainFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.plaf.InternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class BaseDesktopPane extends JDesktopPane {
    // MDIFrame default heigh&width

    private static final int INI_WIDTH = 600;
    private static final int INI_HEIGHT = 400;
    protected JMenuBar menuBar;
    protected JMenu mnWindow;
    protected JSeparator mniSeparator;
    protected ButtonGroup linkingButtonsGroup;
    protected BaseMainFrame parent;
    protected JPanel windowPanel;
    protected boolean windowPanelVisible = false;
    protected boolean maximum = true;

    public BaseDesktopPane() {
        this.windowPanel = this.createWindowPanel();
        this.mniSeparator = new JSeparator();
        this.linkingButtonsGroup = new ButtonGroup();
    }

    public JInternalFrame setHomeScreenPanel(JPanel panel) {
        JInternalFrame frame = new JInternalFrame();
        InternalFrameUI frameUI = frame.getUI();
        ((BasicInternalFrameUI) frameUI).setNorthPane(null);
        frame.setBorder(null);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setIconifiable(false);
        add(frame, JLayeredPane.FRAME_CONTENT_LAYER);

        try {
            frame.setMaximum(true);
        } catch (Exception ex) {
        }

        this.getDesktopManager().maximizeFrame(frame);
        frame.setVisible(true);

        return frame;
    }

    public JInternalFrame addMDIFrame(String title, JPanel panel) {
        // Xử lý trường hợp người sử dụng chọn một chức năng
        // đã được mở ở thời điểm hiện tại
        try {
            JInternalFrame[] frames = getAllFrames();
            for (int i = 0; i < frames.length - 1; i++) {
                if (title.equals(frames[i].getTitle())) {
                    frames[i].setSelected(true);
                    return frames[i];
                }
            }
        } catch (Exception ex) {
        }

        // Kiểm tra nếu chưa có chức năng nào được gọi thì tiến hành
        // thêm thanh ngang trước danh sách các chức năng đang thực hiện
        // trên menu Hiển thị
        if (this.getAllFrames().length == 1) {
            this.mnWindow.add(this.mniSeparator);
        }

        // Khoi tao va add JInteralFrame vao JDesktopPane
        BaseInternalFrame activeFrame = this.createMDIFrame(title, panel);
        this.add(activeFrame, JLayeredPane.DEFAULT_LAYER);

        // Them Linking Menu Item vao menu Hien thi
        JRadioButtonMenuItem item = activeFrame.getLinkingMenuItem();
        this.mnWindow.add(item);
        this.linkingButtonsGroup.add(item);
        item.setSelected(true);

        // Nếu đang ở chế độ cửa sổ con cực đại
        if (this.isMaximum()) {
            // Nếu chưa đặt buttonsPanel lên JMenuBar
            if (!this.isWindowPanelVisible()) {
                this.setWindowPanelVisible(true);
            }

            try {
                activeFrame.setMaximum(true);
            } catch (Exception ex) {
            }
            this.getDesktopManager().maximizeFrame(activeFrame);
        }

        activeFrame.setVisible(true);
        return activeFrame;
    }

    public JInternalFrame addMDIFrame(String title, JPanel panel, boolean duplicatable) {
        // Không chấp nhận cửa sổ con có cùng chức năng
        if (!duplicatable) {
            return this.addMDIFrame(title, panel);
        }

        // Kiểm tra nếu chưa có chức năng nào được gọi thì tiến hành
        // thêm thanh ngang trước danh sách các chức năng đang thực hiện
        // trên menu Hiển thị
        if (this.getAllFrames().length == 1) {
            this.mnWindow.add(this.mniSeparator);
        }

        // Khoi tao va add JInteralFrame vao JDesktopPane
        BaseInternalFrame activeFrame = this.createMDIFrame(title, panel);
        this.add(activeFrame, JLayeredPane.DEFAULT_LAYER);

        // Them Linking Menu Item vao menu Hien thi
        JRadioButtonMenuItem item = activeFrame.getLinkingMenuItem();

        this.mnWindow.add(item);
        this.linkingButtonsGroup.add(item);
        item.setSelected(true);

        // Nếu đang ở chế độ cửa sổ con cực đại
        if (this.isMaximum()) {
            // Nếu chưa đặt buttonsPanel lên JMenuBar
            if (!this.isWindowPanelVisible()) {
                this.setWindowPanelVisible(true);
            }

            try {
                activeFrame.setMaximum(true);
            } catch (Exception ex) {
            }
            getDesktopManager().maximizeFrame(activeFrame);
        }

        activeFrame.setVisible(true);
        return activeFrame;
    }

    public void showDialog(JDialog dialog) {

        // Close the dialog when user press Esc key
        final JDialog dialogChild = dialog;
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                dialogChild.dispose();
            }
        };
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        dialog.getRootPane().getActionMap().put("ESCAPE", escapeAction);

        // Centering the dialog
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public void showDialog(JDialog dialog, boolean isCenterScreen) {
        // Không muốn dialog hiển thị ở chính giữa màn hình
        if (!isCenterScreen) {
            this.showDialog(dialog);
            return;
        }

        // Close the dialog when user press Esc key
        final JDialog dialogChild = dialog;
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                dialogChild.dispose();
            }
        };
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        dialog.getRootPane().getActionMap().put("ESCAPE", escapeAction);

        // Centering the dialog
        Dimension d = dialog.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setBounds(
                (int) (0.5 * (screenSize.width - d.getWidth())),
                (int) (0.5 * (screenSize.height - d.getHeight())),
                d.width, d.height);
        dialog.setVisible(true);
    }

    public void setParent(BaseMainFrame parent) {
        this.parent = parent;
    }

    public void registerMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
        this.mnWindow = ((IFWindowMenu) this.menuBar).getWindowMenu();
    }

    protected JPanel createWindowPanel() {
        JPanel wPanel = new JPanel();
        wPanel.setOpaque(false);

        MDIWindowButton iconifyButton = new MDIWindowButton(MDIWindowButton.ICONIFY_BUTTON);
        iconifyButton.setToolTipText("Thu nhỏ");
        iconifyButton.addActionListener(new MDIWindowButtonListener());

        MDIWindowButton restoreButton = new MDIWindowButton(MDIWindowButton.RESTORE_BUTTON);
        restoreButton.setToolTipText("Phục hồi");
        restoreButton.addActionListener(new MDIWindowButtonListener());

        MDIWindowButton closeButton = new MDIWindowButton(MDIWindowButton.CLOSE_BUTTON);
        closeButton.setToolTipText("Đóng");
        closeButton.addActionListener(new MDIWindowButtonListener());

        wPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 1, 3));
        wPanel.add(iconifyButton);
        wPanel.add(restoreButton);
        wPanel.add(closeButton);

        return wPanel;
    }

    protected void setWindowPanelVisible(boolean aFlag) {
        if (aFlag) {
            this.menuBar.add(BaseDesktopPane.this.windowPanel);
        } else {
            this.menuBar.remove(BaseDesktopPane.this.windowPanel);
        }

        this.windowPanelVisible = aFlag;
        this.menuBar.updateUI();
    }

    protected boolean isWindowPanelVisible() {
        return this.windowPanelVisible;
    }

    protected void setMaximun(boolean aFalg) {
        this.maximum = aFalg;
    }

    protected boolean isMaximum() {
        return this.maximum;
    }

    public void cascade() {
        try {
            JInternalFrame[] frames = getAllFrames();
            JInternalFrame selectedChild = getSelectedFrame();
            int x = 0;
            int y = 0;

            if (!this.isMaximum()) {
                for (int i = frames.length - 2; i >= 0; i--) {
                    frames[i].setMaximum(false);
                    frames[i].setIcon(false);
                    frames[i].setBounds(x, y, INI_WIDTH, INI_HEIGHT);
                    x += 20;
                    y += 20;
                }
            } else {
                for (int i = frames.length - 2; i >= 0; i--) {
                    InternalFrameUI frameUI = frames[i].getUI();
                    ((BasicInternalFrameUI) frameUI).setNorthPane(((BaseInternalFrame) frames[i]).getTitlePane());
                    frames[i].setBorder((Border) UIManager.get("InternalFrame.border"));

                    frames[i].setMaximum(false);
                    frames[i].setIcon(false);
                    frames[i].setBounds(x, y, INI_WIDTH, INI_HEIGHT);
                    frames[i].updateUI();

                    // Đăng ký đối tượng quản lý sự kiện thay đổi thuộc tính trên JInternalFrame
                    frames[i].addVetoableChangeListener(new MDIFrameChangeListener());

                    x += 20;
                    y += 20;
                }

                // Cập nhật trạng thái trên cửa sổ chính
                this.setWindowPanelVisible(false);
                this.setMaximun(false);
                this.parent.setDefaultTitle();
            }

            if (selectedChild != null) {
                setSelectedFrame(selectedChild);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void tile() {
        try {
            Rectangle viewP = this.getVisibleRect();
            int totalNonIconFrames = 0;
            JInternalFrame[] frames = getAllFrames();

            if (this.isMaximum()) {
                for (int i = 0; i < frames.length - 1; i++) {
                    if (!frames[i].isIcon()) {
                        // don't include iconified frames...
                        totalNonIconFrames++;
                    }
                    InternalFrameUI frameUI = frames[i].getUI();
                    ((BasicInternalFrameUI) frameUI).setNorthPane(((BaseInternalFrame) frames[i]).getTitlePane());
                    frames[i].setBorder((Border) UIManager.get("InternalFrame.border"));
                    frames[i].setMaximum(false);
                    frames[i].updateUI();

                    // Đăng ký đối tượng quản lý sự kiện thay đổi thuộc tính trên JInternalFrame
                    frames[i].addVetoableChangeListener(new MDIFrameChangeListener());
                }

                // Cập nhật trạng thái trên cửa sổ chính
                this.setWindowPanelVisible(false);
                this.setMaximun(false);
                this.parent.setDefaultTitle();
            } else {
                for (int i = 0; i < frames.length - 1; i++) {
                    if (!frames[i].isIcon()) {
                        // don't include iconified frames...
                        totalNonIconFrames++;
                    }
                }
            }

            int curCol = 0;
            int curRow = 0;
            int i = 0;

            if (totalNonIconFrames > 0) {
                // compute number of columns and rows then tile the frames
                int numCols = (int) Math.sqrt(totalNonIconFrames);
                int frameWidth = viewP.width / numCols;
                for (curCol = 0; curCol < numCols; curCol++) {

                    int numRows = totalNonIconFrames / numCols;
                    int remainder = totalNonIconFrames % numCols;

                    if ((numCols - curCol) <= remainder) {
                        // add an extra row for this guy
                        numRows++;
                    }

                    int frameHeight = viewP.height / numRows;
                    for (curRow = 0; curRow < numRows; curRow++) {
                        while (frames[i].isIcon()) {
                            // find the next visible frame
                            i++;
                        }

                        frames[i].setBounds(curCol * frameWidth, curRow * frameHeight,
                                frameWidth, frameHeight);
                        i++;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean close() {
        // Khong dong trong truong hop DesktopPane chi chua cua so trang chu
        if (this.getAllFrames().length == 1) {

            return true;
        }

        BaseInternalFrame frame = ((BaseInternalFrame) this.getSelectedFrame());
        if (frame == null) {

            return true;
        }

        this.removeInternalFrame(frame);
        if (this.getAllFrames().length == 1) {
            if (this.isWindowPanelVisible()) {
                this.parent.setDefaultTitle();
                this.setWindowPanelVisible(false);
            }
        }

        return true;
    }

    public boolean closeAll() {
        boolean success = true;
        JInternalFrame[] child = getAllFrames();
        if (child.length == 1) {

            return true;
        }

        for (int i = child.length - 2; i >= 0; i--) {
            this.removeInternalFrame((BaseInternalFrame) child[i]);
            success = success && true;
        }

        if ((success == true) && (this.isWindowPanelVisible())) {
            this.parent.setDefaultTitle();
            this.setWindowPanelVisible(false);
        }

        return success;
    }

    private BaseInternalFrame createMDIFrame(String title, JPanel panel) {
        BaseInternalFrame newMDIChild = new BaseInternalFrame(title, panel);

        // Nếu đang ở chế độ màn hình cực đại
        // thì khởi tạo JInternalFrame không có title và border
        if (this.isMaximum()) {
            newMDIChild.setBorder(null);
            newMDIChild.setResizable(false);
            InternalFrameUI frameUI = newMDIChild.getUI();
            ((BasicInternalFrameUI) frameUI).setNorthPane(null);
        } else {
            newMDIChild.addVetoableChangeListener(new MDIFrameChangeListener());
            newMDIChild.setBounds(0, 0, INI_WIDTH, INI_HEIGHT);
        }

        newMDIChild.addInternalFrameListener(new MDIFrameAdapter());
        return newMDIChild;
    }

    protected void removeInternalFrame(BaseInternalFrame frame) {
        // Clear listener relate
        JRadioButtonMenuItem item = frame.getLinkingMenuItem();
        this.linkingButtonsGroup.remove(item);
        this.mnWindow.remove(item);
        item = null;

        JPanel panel = (JPanel) frame.getContentPanel();
        panel.removeAll();
        panel = null;

        // Dispose InternalFrame
        frame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        getDesktopManager().closeFrame(frame);
        frame.dispose();
        frame = null;

        // Remove linking Radio Menu Item
        // Kiểm tra nếu không còn chức năng nào được gọi thì tiến hành
        // bỏ thanh ngang trên menu Hiển thị
        if (this.getAllFrames().length == 1) {
            this.mnWindow.remove(this.mniSeparator);
        }
    }

    class MDIFrameAdapter extends InternalFrameAdapter {

        @Override
        public void internalFrameClosing(InternalFrameEvent e) {
            BaseInternalFrame frame = (BaseInternalFrame) e.getInternalFrame();
            // Kiem tra neu chuc nang doi phai phai xac nhan truoc khi dong
            BaseDesktopPane.this.removeInternalFrame(frame);
        }

        @Override
        public void internalFrameActivated(InternalFrameEvent e) {
            BaseInternalFrame frame = (BaseInternalFrame) e.getInternalFrame();
            frame.getLinkingMenuItem().setSelected(true);

            // Gán lại tiêu đề cho cửa sổ chính
            if (!BaseDesktopPane.this.isMaximum()) {
                BaseDesktopPane.this.parent.setDefaultTitle();
            } else {
                BaseDesktopPane.this.parent.setMDIModelTitle(frame.getTitle());
            }
        }
    }

    class MDIWindowButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JInternalFrame child = BaseDesktopPane.this.getSelectedFrame();
            JInternalFrame[] frameChilds = BaseDesktopPane.this.getAllFrames();
            switch (((MDIWindowButton) e.getSource()).getButtonType()) {
                case MDIWindowButton.ICONIFY_BUTTON:
                    try {
                        BaseDesktopPane.this.getSelectedFrame().setIcon(true);
                        BaseDesktopPane.this.setWindowPanelVisible(false);
                        BaseDesktopPane.this.setMaximun(false);

                        BaseDesktopPane.this.parent.setDefaultTitle();
                        for (int i = 0; i < frameChilds.length - 1; i++) {
                            InternalFrameUI frameUI = frameChilds[i].getUI();
                            ((BasicInternalFrameUI) frameUI).setNorthPane(((BaseInternalFrame) frameChilds[i]).getTitlePane());
                            frameChilds[i].setBorder((Border) UIManager.get("InternalFrame.border"));
                            frameChilds[i].setResizable(true);
                            frameChilds[i].updateUI();
                            frameChilds[i].setMaximum(false);
                            frameChilds[i].addVetoableChangeListener(new MDIFrameChangeListener());
                        }
                    } catch (Exception ex) {
                    }
                    break;
                case MDIWindowButton.RESTORE_BUTTON:
                    try {
                        BaseDesktopPane.this.setWindowPanelVisible(false);
                        BaseDesktopPane.this.setMaximun(false);

                        BaseDesktopPane.this.parent.setDefaultTitle();
                        for (int i = 0; i < frameChilds.length - 1; i++) {
                            InternalFrameUI frameUI = frameChilds[i].getUI();
                            ((BasicInternalFrameUI) frameUI).setNorthPane(((BaseInternalFrame) frameChilds[i]).getTitlePane());
                            frameChilds[i].setBorder((Border) UIManager.get("InternalFrame.border"));
                            frameChilds[i].setResizable(true);
                            frameChilds[i].updateUI();
                            frameChilds[i].setMaximum(false);
                            frameChilds[i].addVetoableChangeListener(new MDIFrameChangeListener());
                        }
                        // Reactive the selected frame
                        child.setSelected(true);
                    } catch (Exception ex) {
                    }
                    break;
                case MDIWindowButton.CLOSE_BUTTON:
                    BaseInternalFrame frame = (BaseInternalFrame) BaseDesktopPane.this.getSelectedFrame();

                    if (frameChilds.length == 2) {
                        BaseDesktopPane.this.setWindowPanelVisible(false);
                        BaseDesktopPane.this.parent.setDefaultTitle();
                    }

                    BaseDesktopPane.this.removeInternalFrame(frame);
                    break;
            }
        }
    }

    class MDIFrameChangeListener implements VetoableChangeListener {

        public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
            if (evt.getPropertyName() == JInternalFrame.IS_MAXIMUM_PROPERTY) {
                BaseDesktopPane.this.setWindowPanelVisible(true);
                BaseDesktopPane.this.setMaximun(true);
                BaseDesktopPane.this.parent.setMDIModelTitle(BaseDesktopPane.this.getSelectedFrame().getTitle());

                JInternalFrame[] frames = BaseDesktopPane.this.getAllFrames();

                for (int i = 0; i < frames.length - 1; i++) {
                    frames[i].setBorder(null);
                    frames[i].setResizable(false);
                    InternalFrameUI frameUI = frames[i].getUI();
                    ((BasicInternalFrameUI) frameUI).setNorthPane(null);
                    BaseDesktopPane.this.getDesktopManager().maximizeFrame(frames[i]);
                    frames[i].removeVetoableChangeListener(frames[i].getVetoableChangeListeners()[0]);
                }
            }
        }
    }
}
