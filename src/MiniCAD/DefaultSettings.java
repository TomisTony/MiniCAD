package MiniCAD;

import java.awt.*;

public class DefaultSettings {

    //region UI default settings
    public static final int WINDOW_WIDTH = 1200;//窗口宽度
    public static final int WINDOW_HEIGHT = 815;//窗口高度
    public static final int TOOLBAR_WIDTH = 90;//工具栏宽度
    public static final int BOTTOMBAR_WIDTH = WINDOW_WIDTH - TOOLBAR_WIDTH;//底部栏宽度
    public static final int BOTTOMBAR_HEIGHT = 30;//底部栏高度
    public static final int TOOLBAR_HEIGHT = WINDOW_HEIGHT - BOTTOMBAR_HEIGHT;//工具栏高度
    public static final int TOOL_ICON_SIDE_LENGTH = 50;//工具图标边长
    public static final int COLOR_SIDE_LENGTH = 40;//颜色选择器边长
    public static final Color TOOLBAR_BGCOLOR = Color.lightGray;//ToolBar的背景颜色
    public static final Color TOOLBUTTON_BGCOLOR = Color.white;//ToolButton的背景颜色
    public static final Color BOTTOMBAR_BGCOLOR = Color.white;//BottomBar的背景颜色
    public static final Color NOTIFY_COLOR = Color.black;//Notify文字的颜色
    public static final Color DRAW_BOARD_BGCOLOR = Color.white;//drawBoard的背景颜色
    public static final String TEXT_LABLE_CONTENT = "Input Text(No longer than 100)";//输入text的弹出框的label的文字
    public static final String TEXT_FRAME_NAME = "Text";//输入text的弹出框的框名
    public static final int TEXT_WIDTH = 400;//输入text的弹出框的框宽度
    public static final int TEXT_HEIGHT = 150;//输入text的弹出框的框高度
    public static final int TEXT_COLOMN = 32;//输入text的弹出框的文字列数
    //endregion

    //region shape default settings
    public static final float SHAPE_DEFAULT_DELTA_SIZE = 5.0f;//shape的默认增大增小量度
    public static final int TEXT_DEFAULT_SIZE = 20;
    public static final float SHAPE_MIN_SIZE = 10.0f;//shape的最小大小
    public static final float LINE_NEAR_RANGE = 3.0f;//用于判断某个点是否在Line的旁边，基本用于Line的isIn
    public static final int FONT_SIZE_BASE = 1;//font-size的基数
    public static final Color DEFAULT_SHAPE_COLOR = Color.black;//默认shape颜色
    //endregion


}
