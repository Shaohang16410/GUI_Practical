import java.awt.*;                     // 导入AWT库，用于布局管理和其他基本功能
import javax.swing.*;                  // 导入Swing库，用于创建图形用户界面

public class P1_FourButtonFrame extends JFrame {  // 定义一个名为P1_FourButtonFrame的类，继承自JFrame

    public P1_FourButtonFrame(){       // 定义构造函数
       setLayout(new FlowLayout());    // 设置框架的布局为FlowLayout，组件按顺序排列

       JPanel p1 = new JPanel();       // 创建一个面板p1
       p1.add(new JButton("One"));     // 在面板p1中添加一个按钮，文本为"One"
       p1.add(new JButton("Two"));     // 在面板p1中添加一个按钮，文本为"Two"

       JPanel p2 = new JPanel();       // 创建另一个面板p2
       p2.add(new JButton("Three"));   // 在面板p2中添加一个按钮，文本为"Three"
       p2.add(new JButton("Four"));    // 在面板p2中添加一个按钮，文本为"Four"
       
       add(p1);                        // 将面板p1添加到框架中
       add(p2);                        // 将面板p2添加到框架中

       setTitle("Four Buttons");       // 设置框架的标题为"Four Buttons"
       pack();                         // 调整框架大小以适应其子组件
       setLocationRelativeTo(null);    // 将框架居中显示
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置默认关闭操作，点击关闭按钮时退出程序
       setVisible(true);               // 设置框架可见
    }

    public static void main(String[] args) {  // 定义主方法
        new P1_FourButtonFrame();     // 创建并显示GUI
    }
}
