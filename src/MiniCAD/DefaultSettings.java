package MiniCAD;

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
    //endregion

    //region shape default settings
    public static final float SHAPE_DEFAULT_DELTA_SIZE = 5.0f;//shape的默认增大增小量度
    public static final float SHAPE_MIN_SIZE = 10.0f;//shape的最小大小
    public static final float LINE_NEAR_RANGE = 3.0f;//用于判断某个点是否在Line的旁边，基本用于Line的isIn
    public static final int FONT_SIZE_BASE = 10;//font-size的基数
    //endregion


}
