package MiniCAD;
import MiniCAD.StateMachine.CADState;
import MiniCAD.StateMachine.IdleState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiniCAD {
    public CADState nowState;
    private ActionListener actionListener;
    JLabel notifyLable;
    final JFrame mainJFrame = new JFrame("MiniCAD");
    JPanel drawBoard = new JPanel();
    JPanel toolBar = new JPanel();
    JPanel bottomBar = new JPanel();

    public MiniCAD(){
        //顺序不能随意调换，需要先初始化state和actionListener,最后才能加鼠标监听
        nowState = new IdleState(this);
        actionListenerInit();
        setMainJFrame();
        setToolBar();
        setDrawBoard();
        setBottomBar();
        setMouseListener();
        mainJFrame.setVisible(true);
    }
    private void setMainJFrame(){
        mainJFrame.setSize(DefaultSettings.WINDOW_WIDTH, DefaultSettings.WINDOW_HEIGHT);
        mainJFrame.setResizable(false);//不允许改变大小，以免出现排版问题
        mainJFrame.setLocationRelativeTo(null);
        mainJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainJFrame.add(drawBoard, BorderLayout.CENTER);
        mainJFrame.add(toolBar, BorderLayout.WEST);
        mainJFrame.add(bottomBar, BorderLayout.SOUTH);
    }
    private void setToolBar(){
        toolBar.setPreferredSize(new Dimension(DefaultSettings.TOOLBAR_WIDTH, DefaultSettings.TOOLBAR_HEIGHT));
        toolBar.setBackground(Color.LIGHT_GRAY);
        setToolButtons();
        setColorButtons();
    }
    private void setToolButtons(){
        String[] shapeName = { "choose", "rectangular", "circle", "line", "text", "delete", "open", "save" };
        for (int i = 0; i < shapeName.length; i++) {
            JButton toolButton = new JButton(shapeName[i]);
            toolButton.setIcon(getFixedImageIcon("src/icons/" + shapeName[i] + ".png",shapeName[i],
                    DefaultSettings.TOOL_ICON_SIDE_LENGTH, DefaultSettings.TOOL_ICON_SIDE_LENGTH));
            toolButton.setPreferredSize(new Dimension(DefaultSettings.TOOL_ICON_SIDE_LENGTH+10,
                    DefaultSettings.TOOL_ICON_SIDE_LENGTH+10));
            toolButton.setBackground(Color.white);
            toolButton.setToolTipText(shapeName[i]);

//            toolButton.addActionListener(myMouse);
            toolBar.add(toolButton);
        }
    }
    private void setColorButtons(){
        Color[] colors = {Color.red, Color.pink, Color.orange, Color.yellow, Color.green, Color.blue, Color.cyan,
                Color.black, Color.gray, Color.white};
        for (int i = 0; i < colors.length; i++) {
            JButton colorButton = new JButton();
            colorButton.setBackground(colors[i]);
            colorButton.setPreferredSize(new Dimension(DefaultSettings.COLOR_SIDE_LENGTH ,
                    DefaultSettings.COLOR_SIDE_LENGTH));
//            nowButton.addActionListener(myMouse);
            toolBar.add(colorButton);
        }
    }
    private void setDrawBoard(){}
    private void setBottomBar(){
        bottomBar.setPreferredSize(new Dimension(DefaultSettings.BOTTOMBAR_WIDTH, DefaultSettings.BOTTOMBAR_HEIGHT));
        bottomBar.setBackground(Color.white);
        setNotifyLable();
        bottomBar.add(notifyLable);
    }

    /**
     * @description: 导入image并返回重置大小的ImageIcon
     * @param imageFileName: 导入的imageFile的路径
     * @param description: ImageIcon自带的Description
     * @param height: 重置的高度
     * @param width: 重置的宽度
     * @return javax.swing.ImageIcon
     */
    private ImageIcon getFixedImageIcon(String imageFileName, String description, int height, int width){
        ImageIcon icon = new ImageIcon(imageFileName,description);
        Image img = icon.getImage();
        img = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        icon.setImage(img);
        return icon;
    }

    private void setMouseListener(){
        drawBoard.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nowState.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                nowState.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                nowState.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                nowState.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                nowState.mouseExited(e);
            }
        });
        drawBoard.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                nowState.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                nowState.mouseMoved(e);
            }
        });
        drawBoard.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                nowState.mouseWheelMoved(e);
            }
        });
    }
    private void actionListenerInit(){
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowState.clickButton(e);
            }
        };
    }

    public void setNotifyLable() {
        this.notifyLable = new JLabel(this.nowState.getNotify());
        notifyLable.setForeground(Color.black);
        notifyLable.setVisible(true);
    }

}
