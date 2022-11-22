import javax.swing.*;
import java.awt.*;

public class MiniCAD {
    final JFrame mainJFrame = new JFrame("MiniCAD");
    JPanel drawBoard = new JPanel();
    JPanel toolBar = new JPanel();
    JPanel bottomBar = new JPanel();
    MiniCAD(){
        setMainJFrame();
        setToolBar();
        setDrawBoard();
        setBottomBar();
        mainJFrame.setVisible(true);
    }
    private void setMainJFrame(){
        mainJFrame.setSize(defaultSettings.WINDOW_WIDTH,defaultSettings.WINDOW_HEIGHT);
        mainJFrame.setResizable(false);//不允许改变大小，以免出现排版问题
        mainJFrame.setLocationRelativeTo(null);
        mainJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainJFrame.add(drawBoard, BorderLayout.CENTER);
        mainJFrame.add(toolBar, BorderLayout.WEST);
        mainJFrame.add(bottomBar, BorderLayout.SOUTH);
    }
    private void setToolBar(){
        toolBar.setPreferredSize(new Dimension(defaultSettings.TOOLBAR_WIDTH, defaultSettings.TOOLBAR_HEIGHT));
        toolBar.setBackground(Color.LIGHT_GRAY);
        setToolButtons();
        setColorButtons();
    }
    private void setToolButtons(){
        String[] shapeName = { "choose", "rectangular", "circle", "line", "text", "delete", "open", "save" };
        for (int i = 0; i < shapeName.length; i++) {
            JButton toolButton = new JButton(shapeName[i]);
            toolButton.setIcon(getFixedImageIcon("src/icons/" + shapeName[i] + ".png",shapeName[i],
                    defaultSettings.TOOL_ICON_SIDE_LENGTH,defaultSettings.TOOL_ICON_SIDE_LENGTH));
            toolButton.setPreferredSize(new Dimension(defaultSettings.TOOL_ICON_SIDE_LENGTH+10,
                    defaultSettings.TOOL_ICON_SIDE_LENGTH+10));
            toolButton.setBackground(Color.white);

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
            colorButton.setPreferredSize(new Dimension(defaultSettings.COLOR_SIDE_LENGTH ,
                    defaultSettings.COLOR_SIDE_LENGTH));
//            nowButton.addActionListener(myMouse);
            toolBar.add(colorButton);
        }
    }
    private void setDrawBoard(){}
    private void setBottomBar(){
        bottomBar.setPreferredSize(new Dimension(defaultSettings.BOTTOMBAR_WIDTH,defaultSettings.BOTTOMBAR_HEIGHT));
        bottomBar.setBackground(Color.white);
        JLabel notifyLable = new JLabel(defaultSettings.NOTIFY_IDLE);
        notifyLable.setForeground(Color.black);
        notifyLable.setVisible(true);
        notifyLable.setBackground(Color.BLUE);
        notifyLable.setHorizontalAlignment(SwingConstants.LEFT);
        notifyLable.setVerticalAlignment(SwingConstants.TOP);
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
    public static void main(String[] args) {
        new MiniCAD();
    }



    public static void showNewWindow(JFrame relativeWindow) {
        // 创建一个新窗口
        JFrame newJFrame = new JFrame("新的窗口");

        newJFrame.setSize(250, 250);

        // 把新窗口的位置设置到 relativeWindow 窗口的中心
        newJFrame.setLocationRelativeTo(relativeWindow);

        // 点击窗口关闭按钮, 执行销毁窗口操作（如果设置为 EXIT_ON_CLOSE, 则点击新窗口关闭按钮后, 整个进程将结束）
        newJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // 窗口设置为不可改变大小
        newJFrame.setResizable(false);

        JPanel panel = new JPanel(new GridLayout(1, 1));

        // 在新窗口中显示一个标签
        JLabel label = new JLabel("这是一个窗口");
        label.setFont(new Font(null, Font.PLAIN, 25));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(label);

        newJFrame.setContentPane(panel);
        newJFrame.setVisible(true);
    }

}
