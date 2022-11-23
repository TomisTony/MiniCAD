package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class IdleState extends CADState{
    public IdleState(MiniCAD miniCAD){
        super(miniCAD);
        setStateName("IdleState");
        setNotify("(idle)");
        handle();
    }

    @Override
    public void handle() {

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
}
