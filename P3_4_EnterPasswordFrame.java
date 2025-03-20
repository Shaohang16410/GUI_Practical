import javax.swing.*; // 导入Swing包
import java.awt.*; // 导入AWT包
import java.awt.event.*; // 导入AWT事件包

public class P3_4_EnterPasswordFrame extends JFrame { // 定义一个继承自JFrame的类

    JPasswordField jpfPassword = new JPasswordField(15); // 创建密码输入框
    JButton jbtSubmit = new JButton("Submit"); // 创建提交按钮
    JTextArea jtaMessage = new JTextArea(5, 30); // 创建消息显示区域

    public P3_4_EnterPasswordFrame() { // 构造函数
        JPanel jpCenter = new JPanel(new GridLayout(2, 2)); // 创建中心面板，使用2行2列的网格布局
        jpCenter.add(new JLabel("Enter your password")); // 添加密码标签
        jpCenter.add(jpfPassword); // 添加密码输入框
        jpCenter.add(new JLabel()); // 添加空标签
        jpCenter.add(jbtSubmit); // 添加提交按钮
        add(jpCenter, BorderLayout.CENTER); // 将中心面板添加到窗口的中央
        add(jtaMessage, BorderLayout.SOUTH); // 将消息显示区域添加到窗口的南部
        jtaMessage.setLineWrap(true); // 设置消息显示区域自动换行
        jtaMessage.setWrapStyleWord(true); // 设置消息显示区域按单词换行
        jtaMessage.setEditable(false); // 设置消息显示区域为不可编辑

        jbtSubmit.addActionListener(new ButtonListener()); // 为提交按钮添加监听器
        jpfPassword.addActionListener(new ButtonListener()); // 为密码输入框添加监听器
    }

    private class ButtonListener implements ActionListener { // 内部类，实现按钮监听器

        public void actionPerformed(ActionEvent e) { // 处理按钮点击事件
            jtaMessage.setText(""); // 清空消息显示区域
            char[] inputChars = jpfPassword.getPassword(); // 获取密码输入框的内容
            String inputStr = new String(inputChars); // 将密码转换为字符串
            try {
                P3_4_Password pw = new P3_4_Password(inputStr); // 创建密码对象
                jtaMessage.setForeground(Color.BLUE); // 设置消息显示区域的前景色为蓝色
                jtaMessage.setText("Congratulations! Your password is valid."); // 显示成功消息
            } catch (P3_4_InvalidPasswordException ex) { // 捕获无效密码异常
                jtaMessage.setForeground(Color.RED); // 设置消息显示区域的前景色为红色
                jtaMessage.setText(ex.getMessage()); // 显示错误消息
                jpfPassword.grabFocus(); // 将焦点设置到密码输入框
            }
        }
    }

    public static void main(String[] args) { // 主方法
        P3_4_EnterPasswordFrame frm = new P3_4_EnterPasswordFrame(); // 创建密码输入窗口
        frm.setTitle("Set Password"); // 设置窗口标题
        frm.pack(); // 调整窗口大小以适应内容
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭操作
        frm.setLocationRelativeTo(null); // 将窗口居中显示
        frm.setVisible(true); // 设置窗口可见
    }
}