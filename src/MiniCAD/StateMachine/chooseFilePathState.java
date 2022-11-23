package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;
import MiniCAD.shapes.Text;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.File;

public class chooseFilePathState extends CADState{
    private String buttonModel;
    chooseFilePathState(MiniCAD miniCAD, String buttonModel) {
        super(miniCAD);
        this.buttonModel = buttonModel;
        setStateName("chooseFilePathState");
        getMiniCAD().nowState = this;
        handle();
    }

    @Override
    public void handle() {
        String result;
        if(buttonModel.equals("save")) {
            setNotify("选择你要保存的路径");
            result = showFileSaveDialog(getMiniCAD().getMainJFrame());
            setNextState(new saveState(getMiniCAD(),result));
        }
        else if (buttonModel.equals("open")) {
            setNotify("选择你要读取的路径");
            result = showFileOpenDialog(getMiniCAD().getMainJFrame());
            setNextState(new loadState(getMiniCAD(),result));
        }

    }

    /*
     * @description: 打开一个文件选择器来选择打开的文件
     * @param parent:
     * @param msgTextArea:
     * @return void
     */
    private static String showFileOpenDialog(Component parent) {
        // 创建一个默认的文件选取器
        JFileChooser fileChooser = new JFileChooser();
        // 设置默认显示的文件夹为当前文件夹
        fileChooser.setCurrentDirectory(new File("."));
        // 设置文件选择的模式（只选文件、只选文件夹、文件和文件均可选）
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // 设置是否允许多选
        fileChooser.setMultiSelectionEnabled(false);
        // 设置默认使用的文件过滤器
        fileChooser.setFileFilter(new FileNameExtensionFilter("MiniCAD(*.cad)", "cad"));
        // 打开文件选择框（线程将被阻塞, 直到选择框被关闭）
        int result = fileChooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            // 如果点击了"确定", 则获取选择的文件路径
            File file = fileChooser.getSelectedFile();
            return file.getAbsolutePath();
        }
        return "";
    }

    /*
     * 选择文件保存路径
     */
    private static String showFileSaveDialog(Component parent) {
        // 创建一个默认的文件选取器
        JFileChooser fileChooser = new JFileChooser();
        // 设置默认显示的文件夹为当前文件夹
        fileChooser.setCurrentDirectory(new File("."));
        // 设置打开文件选择框后默认输入的文件名
        fileChooser.setSelectedFile(new File("data.cad"));
        // 设置默认使用的文件过滤器
        fileChooser.setFileFilter(new FileNameExtensionFilter("MiniCAD(*.cad)", "cad"));
        // 打开文件选择框（线程将被阻塞, 直到选择框被关闭）
        int result = fileChooser.showSaveDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            // 如果点击了"保存", 则获取选择的保存路径
            File file = fileChooser.getSelectedFile();
            return file.getAbsolutePath();
        }
        return "";
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
