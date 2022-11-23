package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;
import MiniCAD.DefaultSettings;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class drawFirstPointState extends CADState{
    private String shapeName;
    private int x1,y1;
    private JFrame textFrame;
    private JTextField content;
    drawFirstPointState(MiniCAD miniCAD, String shapeName, int x1, int y1) {
        super(miniCAD);
        this.shapeName = shapeName;
        this.x1 = x1;
        this.y1 = y1;
        setStateName("drawFirstPointState");
        getMiniCAD().nowState = this;
        handle();
    }

    @Override
    public void handle() {
        switch (shapeName){
            case "rectangular":
                setNotify("选择第二个点作为矩形的另一个点");
                break;
            case "circle":
                setNotify("选择第二个点来决定圆形的半径");
                break;
            case "line":
                setNotify("选择第二个点作为直线的第一个点");
                break;
            case "text":
                //TODO:弹出文字对话框
                buildTextFrame();
                setNextState(new drawTextState(getMiniCAD(),content,textFrame,x1,y1));
                break;
            default:
                logSwitchDefault(shapeName);
                break;
        }
    }

    /*
     * @description: 构建用于输入文字的框
     * @param :
     * @return 框内的文本框
     */
    private void buildTextFrame(){
        JLabel label = new JLabel(DefaultSettings.TEXT_LABLE_CONTENT);
        content = new JTextField(DefaultSettings.TEXT_COLOMN);
        textFrame = new JFrame(DefaultSettings.TEXT_FRAME_NAME);
        Container contentPane = textFrame.getContentPane();
        JButton OKbutton = new JButton("OK");
        OKbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getMiniCAD().nowState.clickButton(e);
            }
        });
        contentPane.setLayout(new FlowLayout());
        contentPane.add(label);
        contentPane.add(content);
        contentPane.add(OKbutton);
        textFrame.setSize(DefaultSettings.TEXT_WIDTH, DefaultSettings.TEXT_HEIGHT);
        textFrame.setLocationRelativeTo(null);
        textFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                setNextState(new drawShapeState(getMiniCAD(),shapeName));
            }

        }); //添加按下关闭按钮的回调
        textFrame.setVisible(true);
    }

    @Override
    public void clickButton(ActionEvent event) {
        //切换至idleState并执行按钮点击
        setNextState(new IdleState(getMiniCAD()));
        getMiniCAD().nowState.clickButton(event);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }

    @Override
    public void mouseMoved(MouseEvent event) {

    }

    @Override
    public void mouseEntered(MouseEvent event) {

    }

    @Override
    public void mouseExited(MouseEvent event) {

    }

    @Override
    public void mouseClicked(MouseEvent event) {

    }

    @Override
    public void mousePressed(MouseEvent event) {
        setNextState(new drawSecondPointState(getMiniCAD(),shapeName,x1,y1,event.getX(),event.getY()));
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent event) {

    }
}
