package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class saveState extends CADState{
    String filePath;
    saveState(MiniCAD miniCAD, String filePath) {
        super(miniCAD);
        this.filePath = filePath;
        setStateName("saveState");
        getMiniCAD().nowState = this;
        handle();
    }

    @Override
    public void handle() {
        setNotify("");
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(getMiniCAD().shapes);
        }
        catch (IOException ie){

        }
        setNextState(new IdleState(getMiniCAD()));
    }

    @Override
    public void clickButton(ActionEvent event) {

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
