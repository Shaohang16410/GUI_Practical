import javax.swing.*;  // 导入Swing包，用于创建GUI组件
import java.awt.GridLayout;  // 导入GridLayout类，用于设置网格布局

public class P1_GridLayout extends JFrame {  // 定义P1_GridLayout类，继承自JFrame

    public P1_GridLayout() {  // 定义构造方法，用于初始化窗口
        // 设置窗口标题
        setTitle("Student Information");

        // 设置布局为GridLayout，4行2列
        setLayout(new GridLayout(4, 2));

        // 创建标签和文本框
        JLabel regNoLabel = new JLabel("Registration Number:");  // 创建“Registration Number”标签
        JTextField regNoField = new JTextField();  // 创建对应的文本框

        JLabel nameLabel = new JLabel("Name:");  // 创建“Name”标签
        JTextField nameField = new JTextField();  // 创建对应的文本框

        JLabel progCodeLabel = new JLabel("Programme Code:");  // 创建“Programme Code”标签
        JTextField progCodeField = new JTextField();  // 创建对应的文本框

        // 创建提交按钮
        JButton submitButton = new JButton("Submit");  // 创建“Submit”按钮

        // 将组件添加到窗口中
        add(regNoLabel);  // 添加“Registration Number”标签
        add(regNoField);  // 添加对应的文本框
        add(nameLabel);  // 添加“Name”标签
        add(nameField);  // 添加对应的文本框
        add(progCodeLabel);  // 添加“Programme Code”标签
        add(progCodeField);  // 添加对应的文本框
        add(new JLabel());  // 添加一个空标签用于占位
        add(submitButton);  // 添加“Submit”按钮

        // 设置窗口大小和关闭操作
        setSize(300, 200);  // 设置窗口大小为300x200像素
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置窗口关闭时退出程序
    }

    public static void main(String[] args) {  // 主方法，程序入口
        // 创建并显示窗口
        P1_GridLayout frame = new P1_GridLayout();  // 创建P1_GridLayout对象
        frame.setVisible(true);  // 设置窗口可见
    }
}