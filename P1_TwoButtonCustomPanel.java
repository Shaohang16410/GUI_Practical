import java.awt.GridLayout;  // 导入GridLayout类，用于网格布局
import javax.swing.*;        // 导入Swing库，用于创建图形用户界面

public class P1_TwoButtonCustomPanel extends JPanel {  // 定义一个名为TwoButtonCustomPanel的类，继承自JPanel
    public P1_TwoButtonCustomPanel() {  // 定义无参构造函数
        this("", "");  // 调用带参构造函数，传入空字符串作为按钮文本
    }

    public P1_TwoButtonCustomPanel(String buttonStr1, String buttonStr2) {  // 定义带参构造函数
        setLayout(new GridLayout(1, 2));  // 设置面板的布局为GridLayout，1行2列
        add(new JButton(buttonStr1));  // 在面板中添加一个按钮，文本为buttonStr1
        add(new JButton(buttonStr2));  // 在面板中添加一个按钮，文本为buttonStr2
    }
}