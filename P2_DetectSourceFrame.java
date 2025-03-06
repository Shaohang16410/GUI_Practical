import java.awt.BorderLayout;  // 导入BorderLayout类，用于布局管理
import java.awt.Color;        // 导入Color类，用于设置颜色
import java.awt.Font;         // 导入Font类，用于设置字体
import java.awt.event.*;      // 导入事件处理相关的类
import javax.swing.*;         // 导入Swing组件类

public class P2_DetectSourceFrame extends JFrame {  // 定义一个继承自JFrame的类

    private JLabel jlblColor = new JLabel("COLOR");  // 创建一个JLabel对象，显示文本"COLOR"
    private JButton jbtBlue = new JButton("Blue");   // 创建一个JButton对象，显示文本"Blue"
    private JButton jbtRed = new JButton("Red");     // 创建一个JButton对象，显示文本"Red"
    private JButton jbtGreen = new JButton("Green"); // 创建一个JButton对象，显示文本"Green"

    public P2_DetectSourceFrame() {  // 构造函数，初始化窗口和组件
        jlblColor.setFont(new Font("Cambria", Font.BOLD, 20));  // 设置JLabel的字体为Cambria，粗体，大小为20
        jlblColor.setHorizontalAlignment(JLabel.CENTER);  // 设置JLabel的文本居中对齐
        add(jlblColor, BorderLayout.NORTH);  // 将JLabel添加到窗口的北部（上方）

        JPanel jpButtons = new JPanel();  // 创建一个JPanel对象，用于放置按钮
        jpButtons.add(jbtRed);  // 将红色按钮添加到JPanel中
        jpButtons.add(jbtGreen);  // 将绿色按钮添加到JPanel中
        jpButtons.add(jbtBlue);  // 将蓝色按钮添加到JPanel中
        add(jpButtons);  // 将JPanel添加到窗口中
        
        ButtonListener listener = new ButtonListener();  // 创建一个ButtonListener对象，用于监听按钮点击事件

        jbtRed.addActionListener(listener);  // 为红色按钮添加事件监听器
        jbtBlue.addActionListener(listener);  // 为蓝色按钮添加事件监听器
        jbtGreen.addActionListener(listener);  // 为绿色按钮添加事件监听器

        setTitle("Primary Colors");  // 设置窗口标题为"Primary Colors"
        setSize(300, 100);  // 设置窗口大小为300x100像素
        setLocationRelativeTo(null);  // 将窗口居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置窗口关闭操作，点击关闭按钮时退出程序
        setVisible(true);  // 设置窗口可见
    }

    private class ButtonListener implements ActionListener {  // 定义一个内部类，实现ActionListener接口

        @Override
        public void actionPerformed(ActionEvent e) {  // 实现actionPerformed方法，处理按钮点击事件
            if (e.getSource() == jbtRed)  // 如果事件源是红色按钮
                jlblColor.setForeground(Color.RED);  // 将JLabel的文本颜色设置为红色
            else if (e.getSource() == jbtBlue)  // 如果事件源是蓝色按钮
                jlblColor.setForeground(Color.BLUE);  // 将JLabel的文本颜色设置为蓝色
            else if (e.getSource() == jbtGreen)  // 如果事件源是绿色按钮
                jlblColor.setForeground(Color.GREEN);  // 将JLabel的文本颜色设置为绿色
        }
    }

    public static void main(String[] args) {  // 主方法，程序入口
        new P2_DetectSourceFrame();  // 创建P2_DetectSourceFrame对象，启动程序
    }
}import java.awt.BorderLayout;  // 导入BorderLayout类，用于布局管理
import java.awt.Color;        // 导入Color类，用于设置颜色
import java.awt.Font;         // 导入Font类，用于设置字体
import java.awt.event.*;      // 导入事件处理相关的类
import javax.swing.*;         // 导入Swing组件类

public class P2_DetectSourceFrame extends JFrame {  // 定义一个继承自JFrame的类

    private JLabel jlblColor = new JLabel("COLOR");  // 创建一个JLabel对象，显示文本"COLOR"
    private JButton jbtBlue = new JButton("Blue");   // 创建一个JButton对象，显示文本"Blue"
    private JButton jbtRed = new JButton("Red");     // 创建一个JButton对象，显示文本"Red"
    private JButton jbtGreen = new JButton("Green"); // 创建一个JButton对象，显示文本"Green"

    public P2_DetectSourceFrame() {  // 构造函数，初始化窗口和组件
        jlblColor.setFont(new Font("Cambria", Font.BOLD, 20));  // 设置JLabel的字体为Cambria，粗体，大小为20
        jlblColor.setHorizontalAlignment(JLabel.CENTER);  // 设置JLabel的文本居中对齐
        add(jlblColor, BorderLayout.NORTH);  // 将JLabel添加到窗口的北部（上方）

        JPanel jpButtons = new JPanel();  // 创建一个JPanel对象，用于放置按钮
        jpButtons.add(jbtRed);  // 将红色按钮添加到JPanel中
        jpButtons.add(jbtGreen);  // 将绿色按钮添加到JPanel中
        jpButtons.add(jbtBlue);  // 将蓝色按钮添加到JPanel中
        add(jpButtons);  // 将JPanel添加到窗口中
        
        ButtonListener listener = new ButtonListener();  // 创建一个ButtonListener对象，用于监听按钮点击事件

        jbtRed.addActionListener(listener);  // 为红色按钮添加事件监听器
        jbtBlue.addActionListener(listener);  // 为蓝色按钮添加事件监听器
        jbtGreen.addActionListener(listener);  // 为绿色按钮添加事件监听器

        setTitle("Primary Colors");  // 设置窗口标题为"Primary Colors"
        setSize(300, 100);  // 设置窗口大小为300x100像素
        setLocationRelativeTo(null);  // 将窗口居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置窗口关闭操作，点击关闭按钮时退出程序
        setVisible(true);  // 设置窗口可见
    }

    private class ButtonListener implements ActionListener {  // 定义一个内部类，实现ActionListener接口

        @Override
        public void actionPerformed(ActionEvent e) {  // 实现actionPerformed方法，处理按钮点击事件
            if (e.getSource() == jbtRed)  // 如果事件源是红色按钮
                jlblColor.setForeground(Color.RED);  // 将JLabel的文本颜色设置为红色
            else if (e.getSource() == jbtBlue)  // 如果事件源是蓝色按钮
                jlblColor.setForeground(Color.BLUE);  // 将JLabel的文本颜色设置为蓝色
            else if (e.getSource() == jbtGreen)  // 如果事件源是绿色按钮
                jlblColor.setForeground(Color.GREEN);  // 将JLabel的文本颜色设置为绿色
        }
    }

    public static void main(String[] args) {  // 主方法，程序入口
        new P2_DetectSourceFrame();  // 创建P2_DetectSourceFrame对象，启动程序
    }
}
