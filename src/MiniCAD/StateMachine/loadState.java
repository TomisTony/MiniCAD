package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;
import MiniCAD.shapes.Shape;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Stack;

public class loadState extends CADState{
    String filePath;
    loadState(MiniCAD miniCAD, String filePath) {
        super(miniCAD);
        this.filePath = filePath;
        setStateName("loadState");
        getMiniCAD().nowState = this;
        handle();
    }

    @Override
    public void handle() {
        setNotify("");
        ObjectInputStream ios;
        try {
            ios = new ObjectInputStream(new FileInputStream(filePath));
            Object obj = ios.readObject();
            getMiniCAD().shapes = (ArrayList<Shape>) obj;
            getMiniCAD().paintAllShapes(getMiniCAD().graphics2D);
        }
        catch (Exception ie){
            System.out.println(ie.getMessage());
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
