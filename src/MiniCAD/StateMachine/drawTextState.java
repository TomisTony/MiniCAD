package MiniCAD.StateMachine;
import MiniCAD.DefaultSettings;
import MiniCAD.MiniCAD;
import MiniCAD.shapes.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class drawTextState extends CADState{
    JTextField content;
    JFrame textFrame;
    int x,y;
    drawTextState(MiniCAD miniCAD, JTextField content, JFrame textFrame, int x, int y) {
        super(miniCAD);
        this.content = content;
        this.textFrame = textFrame;
        this.x = x;
        this.y = y;
        setStateName("drawTextState");
        getMiniCAD().nowState = this;
        handle();
    }

    @Override
    public void handle() {
        setNotify("选择输入所要展示的Text");
    }

    @Override
    public void clickButton(ActionEvent event) {
        logButtonName(event);
        String buttonName = event.getActionCommand();
        switch (buttonName){
            case "OK":
                String text = content.getText();
                textFrame.setVisible(false);
                if (!text.isEmpty()) {
                    getMiniCAD().shapes.add(new Text(x, y, DefaultSettings.TEXT_DEFAULT_SIZE,
                            DefaultSettings.DEFAULT_SHAPE_COLOR,text));
                    getMiniCAD().paintAllShapes(getMiniCAD().graphics2D);
                    setNextState(new drawShapeState(getMiniCAD(),"text"));
                }
                break;
            default:
                logSwitchDefault(buttonName);
                break;
        }
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

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent event) {

    }
}
