import javax.swing.*;
import java.awt.*;

public class P1_FourButtonGridLayoutFrame extends JFrame {
    public P1_FourButtonGridLayoutFrame() {
        JPanel p1 = new JPanel(new GridLayout(1, 2));// 创建一个面板p1，使用GridLayout布局，1行2列
        p1.add(new JButton("One"));// 在面板p1中添加一个按钮，文本为"One"
        p1.add(new JButton("Two"));// 在面板p1中添加一个按钮，文本为"Two"

        JPanel p2 = new JPanel(new GridLayout(1, 2));// 创建另一个面板p2，使用GridLayout布局，1行2列
        p2.add(new JButton("Three"));// 在面板p2中添加一个按钮，文本为"Three"
        p2.add(new JButton("Four"));// 在面板p2中添加一个按钮，文本为"Four"

        add(p2, BorderLayout.SOUTH);// 将面板p2添加到框架的南部（底部）
        add(p1, BorderLayout.CENTER);// 将面板p1添加到框架的中心

        setTitle("Four Buttons");// 设置框架的标题为"Four Buttons"
        pack();// 调整框架大小以适应其子组件
        setLocationRelativeTo(null);// 将框架居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置默认关闭操作，点击关闭按钮时退出程序
        setVisible(true);// 设置框架可见
    }

    public static void main(String[] args) {
        new P1_FourButtonGridLayoutFrame();// 创建并显示GUI

    }
}
