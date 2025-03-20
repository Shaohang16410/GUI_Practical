import java.awt.*; // 导入AWT包，用于图形用户界面
import java.awt.event.*; // 导入AWT事件包，用于处理事件
import javax.swing.*; // 导入Swing包，用于创建GUI组件

public class P3_1_SimpleCalculator extends JFrame { // 定义一个继承自JFrame的类

    private JLabel jlblFirst = new JLabel("First Number"); // 创建第一个数字的标签
    private JLabel jlblSecond = new JLabel("Second Number"); // 创建第二个数字的标签
    private JLabel jlblResult = new JLabel("Result"); // 创建结果标签
    private JTextField jtfFirst = new JTextField(); // 创建第一个数字的输入框
    private JTextField jtfSecond = new JTextField(); // 创建第二个数字的输入框
    private JTextField jtfResult = new JTextField(); // 创建结果输出框
    private JButton jbtAdd = new JButton("Add"); // 创建加法按钮
    private JButton jbtSubtract = new JButton("Subtract"); // 创建减法按钮
    private JButton jbtMultiply = new JButton("Multiply"); // 创建乘法按钮
    private JButton jbtDivide = new JButton("Divide"); // 创建除法按钮

    public P3_1_SimpleCalculator() { // 构造函数
        setTitle("Simple Calculator"); // 设置窗口标题
        Font font = new Font("Arial", Font.BOLD, 14); // 创建字体对象

        jlblFirst.setFont(font); // 设置第一个数字标签的字体
        jlblSecond.setFont(font); // 设置第二个数字标签的字体
        jlblResult.setFont(font); // 设置结果标签的字体
        jtfFirst.setFont(font); // 设置第一个数字输入框的字体
        jtfSecond.setFont(font); // 设置第二个数字输入框的字体
        jtfResult.setFont(font); // 设置结果输出框的字体
        jbtAdd.setFont(font); // 设置加法按钮的字体
        jbtSubtract.setFont(font); // 设置减法按钮的字体
        jbtMultiply.setFont(font); // 设置乘法按钮的字体
        jbtDivide.setFont(font); // 设置除法按钮的字体

        jtfResult.setEditable(false); // 设置结果输出框为不可编辑

        JPanel jpCenter = new JPanel(new GridLayout(3, 2, 2, 2)); // 创建中心面板，使用3行2列的网格布局
        jpCenter.add(jlblFirst); // 将第一个数字标签添加到面板
        jpCenter.add(jtfFirst); // 将第一个数字输入框添加到面板
        jpCenter.add(jlblSecond); // 将第二个数字标签添加到面板
        jpCenter.add(jtfSecond); // 将第二个数字输入框添加到面板
        jpCenter.add(jlblResult); // 将结果标签添加到面板
        jpCenter.add(jtfResult); // 将结果输出框添加到面板
        add(jpCenter, BorderLayout.CENTER); // 将中心面板添加到窗口的中央

        JPanel jpSouth = new JPanel(); // 创建底部面板
        jpSouth.add(jbtAdd); // 将加法按钮添加到面板
        jpSouth.add(jbtSubtract); // 将减法按钮添加到面板
        jpSouth.add(jbtMultiply); // 将乘法按钮添加到面板
        jpSouth.add(jbtDivide); // 将除法按钮添加到面板
        add(jpSouth, BorderLayout.SOUTH); // 将底部面板添加到窗口的南部

        jbtAdd.setMnemonic('A'); // 设置加法按钮的快捷键为A
        jbtSubtract.setMnemonic('S'); // 设置减法按钮的快捷键为S
        jbtMultiply.setMnemonic('M'); // 设置乘法按钮的快捷键为M
        jbtDivide.setMnemonic('D'); // 设置除法按钮的快捷键为D

        ButtonListener buttonListener = new ButtonListener(); // 创建按钮监听器
        jbtAdd.addActionListener(buttonListener); // 为加法按钮添加监听器
        jbtSubtract.addActionListener(buttonListener); // 为减法按钮添加监听器
        jbtMultiply.addActionListener(buttonListener); // 为乘法按钮添加监听器
        jbtDivide.addActionListener(buttonListener); // 为除法按钮添加监听器

        pack(); // 调整窗口大小以适应内容
        setLocationRelativeTo(null); // 将窗口居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭操作
        setVisible(true); // 设置窗口可见
    }

    public void clearTextFields() { // 清空文本框的方法
        jtfFirst.setText(""); // 清空第一个数字输入框
        jtfSecond.setText(""); // 清空第二个数字输入框
        jtfResult.setText(""); // 清空结果输出框
        jtfFirst.grabFocus(); // 将焦点设置到第一个数字输入框
    }

    private class ButtonListener implements ActionListener { // 内部类，实现按钮监听器

        @Override
        public void actionPerformed(ActionEvent e) { // 处理按钮点击事件
            try {
                double firstVal = Double.parseDouble(jtfFirst.getText()); // 获取第一个数字
                double secondVal = Double.parseDouble(jtfSecond.getText()); // 获取第二个数字
                double result = 0; // 初始化结果变量

                if (e.getSource() == jbtAdd) { // 如果点击的是加法按钮
                    result = firstVal + secondVal; // 计算加法结果
                } else if (e.getSource() == jbtSubtract) { // 如果点击的是减法按钮
                    result = firstVal - secondVal; // 计算减法结果
                } else if (e.getSource() == jbtMultiply) { // 如果点击的是乘法按钮
                    result = firstVal * secondVal; // 计算乘法结果
                } else if (e.getSource() == jbtDivide) { // 如果点击的是除法按钮
                    if (secondVal == 0) { // 如果第二个数字为零
                        JOptionPane.showMessageDialog(null, "Cannot divide by zero", "ERROR", JOptionPane.ERROR_MESSAGE); // 显示错误消息
                        clearTextFields(); // 清空文本框
                        return; // 退出方法
                    }
                    result = firstVal / secondVal; // 计算除法结果
                }

                jtfResult.setText(String.valueOf(result)); // 将结果显示在结果输出框中
            } catch (NumberFormatException ex) { // 捕获数字格式异常
                JOptionPane.showMessageDialog(null, "Non-numeric operand(s)", "ERROR", JOptionPane.ERROR_MESSAGE); // 显示错误消息
                clearTextFields(); // 清空文本框
            }
        }
    }

    public static void main(String[] args) { // 主方法
        new P3_1_SimpleCalculator(); // 创建计算器窗口
    }
}