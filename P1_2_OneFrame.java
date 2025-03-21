import javax.swing.JButton;  // 导入JButton类，用于创建按钮
import javax.swing.JFrame;    // 导入JFrame类，用于创建窗口

public class P1_OneFrame extends JFrame {  // 定义OneFrame类，继承自JFrame
    private JButton jbtHello = new JButton("Hello");  // 创建一个按钮对象，文本为"Hello"

    public P1_OneFrame() {  // 定义构造方法，用于初始化窗口
        add(jbtHello);  // 将按钮添加到窗口中
        setTitle("One Frame");  // 设置窗口的标题为"One Frame"
        setSize(500, 600);  // 设置窗口的大小为500x600像素
        setLocationRelativeTo(null);  // 将窗口居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置窗口关闭时退出程序
        setVisible(true);  // 设置窗口可见
    }

    public static void main(String[] args) {  // 主方法，程序入口
        new P1_OneFrame();  // 创建OneFrame对象，启动程序
    }
}
