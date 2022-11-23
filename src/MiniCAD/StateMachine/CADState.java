package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public abstract class CADState {
    protected String stateName;
    protected String notify;
    private MiniCAD miniCAD;

    CADState(MiniCAD miniCAD) {
        this.miniCAD = miniCAD;
    }

    public void setStateName(String stateName) {
        System.out.println("\nnow state: " + stateName);
        this.stateName = stateName;
    }

    public void setNotify(String notify) {
        this.notify = notify;
        miniCAD.setNotifyLable(getStateName()+": "+notify);
    }

    public abstract void handle();

    public abstract void clickButton(ActionEvent event);

    public abstract void mouseDragged(MouseEvent event);

    public abstract void mouseReleased(MouseEvent event);

    public abstract void mouseMoved(MouseEvent event);
    public abstract void mouseEntered(MouseEvent event);
    public abstract void mouseExited(MouseEvent event);
    public abstract void mouseClicked(MouseEvent event);
    public abstract void mousePressed(MouseEvent event);
    public abstract void mouseWheelMoved(MouseWheelEvent event);
    public String getNotify() {
        return notify;
    }

    public String getStateName() {
        return stateName;
    }

    protected void setNextState(CADState nextState){
        System.out.println("(state change:" + miniCAD.nowState.getStateName() + " -> " + nextState.getStateName()+")");
        //不能在此处设置nowState，因为构造函数会先于设置nowState出发，导致状态机的实际状态与nowState发生冲突
        //正确的设置方法是在状态的构造函数内，handle()之前设置nowState
    }

    public MiniCAD getMiniCAD(){
        return miniCAD;
    }

    /*
     * @description: 用于统一处理按钮的函数。写在这里是为了避免在不同状态机一直写同一大段代码
     * @param event: 按钮事件
     * @return void
     */
    protected void logButtonName(ActionEvent event){
        System.out.println("button clicked: "+event.getActionCommand());
    }
    protected void logSwitchDefault(String switchCaseName){
        System.out.println("An switch default is occurred: " + switchCaseName);
    }

}
