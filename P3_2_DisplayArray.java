import java.awt.*; // 导入AWT包
import java.awt.event.*; // 导入AWT事件包
import javax.swing.*; // 导入Swing包

public class P3_2_DisplayArray extends JFrame { // 定义一个继承自JFrame的类

    private int[] intArr = new int[100]; // 创建一个包含100个元素的整数数组
    private JTextField jtfIndex = new JTextField(); // 创建索引输入框
    private JTextField jtfElement = new JTextField(); // 创建元素显示框
    private JButton jbtDisplay = new JButton("Show Element"); // 创建显示按钮

    public P3_2_DisplayArray() { // 构造函数
        initializeArray(); // 初始化数组

        JPanel jpCenter = new JPanel(new GridLayout(2, 2)); // 创建中心面板，使用2行2列的网格布局
        jpCenter.add(new JLabel("Array Index")); // 添加索引标签
        jpCenter.add(jtfIndex); // 添加索引输入框
        jpCenter.add(new JLabel("Array Element")); // 添加元素标签
        jpCenter.add(jtfElement); // 添加元素显示框
        jtfElement.setEditable(false); // 设置元素显示框为不可编辑
        add(jpCenter, BorderLayout.CENTER); // 将中心面板添加到窗口的中央

        JPanel jpSouth = new JPanel(); // 创建底部面板
        jpSouth.add(jbtDisplay); // 添加显示按钮
        jbtDisplay.setFont(new Font("Arial", Font.BOLD, 14)); // 设置按钮字体
        add(jpSouth, BorderLayout.SOUTH); // 将底部面板添加到窗口的南部

        jbtDisplay.addActionListener(new ButtonListener()); // 为显示按钮添加监听器

        setTitle("Display: Show Bounds Error"); // 设置窗口标题
        setSize(400, 150); // 设置窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭操作
        setLocationRelativeTo(null); // 将窗口居中显示
        setVisible(true); // 设置窗口可见
    }

    private class ButtonListener implements ActionListener { // 内部类，实现按钮监听器

        @Override
        public void actionPerformed(ActionEvent e) { // 处理按钮点击事件
            try {
                int index = Integer.parseInt(jtfIndex.getText()); // 获取用户输入的索引
                if (index < 0 || index >= intArr.length) { // 如果索引超出范围
                    jtfElement.setText("Out of Bounds"); // 显示“超出范围”消息
                } else {
                    jtfElement.setText("" + intArr[index]); // 显示对应索引的元素
                }
            } catch (NumberFormatException ex) { // 捕获数字格式异常
                jtfElement.setText("Invalid Index"); // 显示“无效索引”消息
            }
        }
    }

    private void initializeArray() { // 初始化数组的方法
        for (int i = 0; i < intArr.length; ++i) { // 遍历数组
            intArr[i] = (int) (Math.random() * 10000); // 为每个元素生成随机数
        }
    }

    public static void main(String[] args) { // 主方法
        new P3_2_DisplayArray(); // 创建显示数组窗口
    }
}