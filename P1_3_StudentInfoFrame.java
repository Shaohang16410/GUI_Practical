import javax.swing.JFrame;  // 导入JFrame类，用于创建窗口
import javax.swing.JLabel;  // 导入JLabel类，用于创建标签
import javax.swing.JTextField;  // 导入JTextField类，用于创建文本输入框
import javax.swing.JButton;  // 导入JButton类，用于创建按钮
import java.awt.FlowLayout;  // 导入FlowLayout类，用于设置布局管理器

public class P1_StudentInfoFrame extends JFrame {  // 定义StudentInfoFrame类，继承自JFrame

    public P1_StudentInfoFrame() {  // 定义构造方法，用于初始化窗口
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));  // 设置布局为FlowLayout，左对齐，水平间距10，垂直间距20

        // 添加“Registration number”标签和对应的文本输入框
        add(new JLabel("Registration number"));  // 创建并添加标签
        add(new JTextField(10));  // 创建并添加文本输入框，宽度为10列

        // 添加“Name”标签和对应的文本输入框
        add(new JLabel("Name"));  // 创建并添加标签
        add(new JTextField(20));  // 创建并添加文本输入框，宽度为20列

        // 添加“Programme code”标签和对应的文本输入框
        add(new JLabel("Programme code"));  // 创建并添加标签
        add(new JTextField(10));  // 创建并添加文本输入框，宽度为10列

        // 添加“Submit”按钮
        add(new JButton("Submit"));  // 创建并添加按钮，文本为“Submit”

        setTitle("Student Information");  // 设置窗口标题为“Student Information”
        setSize(300, 250);  // 设置窗口大小为300x250像素
        setLocationRelativeTo(null);  // 将窗口居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置窗口关闭时退出程序
        setVisible(true);  // 设置窗口可见
    }

    public static void main(String[] args) {  // 主方法，程序入口
        new P1_StudentInfoFrame();  // 创建StudentInfoFrame对象，启动程序
    }
}
