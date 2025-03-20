import java.awt.*; // 导入AWT包
import java.awt.event.*; // 导入AWT事件包
import javax.swing.*; // 导入Swing包
import javax.swing.border.*; // 导入Swing边框包

public class P3_3_LoanCalculator extends JFrame { // 定义一个继承自JFrame的类

    private JTextField jtfAnnualInterestRate = new JTextField(); // 创建年利率输入框
    private JTextField jtfNumberOfYears = new JTextField(); // 创建贷款年限输入框
    private JTextField jtfLoanAmount = new JTextField(); // 创建贷款金额输入框
    private JTextField jtfMonthlyPayment = new JTextField(); // 创建月供显示框
    private JTextField jtfTotalPayment = new JTextField(); // 创建总还款金额显示框
    private JButton jbtComputeLoan = new JButton("Compute Payment"); // 创建计算按钮

    public P3_3_LoanCalculator() { // 构造函数
        JPanel p1 = new JPanel(new GridLayout(5, 2)); // 创建面板，使用5行2列的网格布局
        p1.add(new JLabel("Annual Interest Rate")); // 添加年利率标签
        p1.add(jtfAnnualInterestRate); // 添加年利率输入框
        p1.add(new JLabel("Number of Years")); // 添加贷款年限标签
        p1.add(jtfNumberOfYears); // 添加贷款年限输入框
        p1.add(new JLabel("Loan Amount")); // 添加贷款金额标签
        p1.add(jtfLoanAmount); // 添加贷款金额输入框
        p1.add(new JLabel("Monthly Payment")); // 添加月供标签
        p1.add(jtfMonthlyPayment); // 添加月供显示框
        p1.add(new JLabel("Total Payment")); // 添加总还款金额标签
        p1.add(jtfTotalPayment); // 添加总还款金额显示框
        p1.setBorder(new TitledBorder("Enter loan amount, interest rate, and year")); // 设置面板边框

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // 创建底部面板，使用右对齐布局
        p2.add(jbtComputeLoan); // 添加计算按钮
        add(p1, BorderLayout.CENTER); // 将面板添加到窗口的中央
        add(p2, BorderLayout.SOUTH); // 将底部面板添加到窗口的南部

        jbtComputeLoan.addActionListener(new ButtonListener()); // 为计算按钮添加监听器
    }

    private class ButtonListener implements ActionListener { // 内部类，实现按钮监听器

        public void actionPerformed(ActionEvent e) { // 处理按钮点击事件
            try {
                double interest = Double.parseDouble(jtfAnnualInterestRate.getText()); // 获取年利率
                int year = Integer.parseInt(jtfNumberOfYears.getText()); // 获取贷款年限
                double loanAmount = Double.parseDouble(jtfLoanAmount.getText()); // 获取贷款金额

                if (interest <= 0 || year <= 0 || loanAmount <= 0) { // 如果输入值不合法
                    throw new IllegalArgumentException("Input values must be greater than zero."); // 抛出异常
                }

                P3_3_Loan loan = new P3_3_Loan(interest, year, loanAmount); // 创建贷款对象

                jtfMonthlyPayment.setText(String.format("%.2f", loan.getMonthlyPayment())); // 显示月供
                jtfTotalPayment.setText(String.format("%.2f", loan.getTotalPayment())); // 显示总还款金额
            } catch (NumberFormatException ex) { // 捕获数字格式异常
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values.", "ERROR", JOptionPane.ERROR_MESSAGE); // 显示错误消息
            } catch (IllegalArgumentException ex) { // 捕获非法参数异常
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); // 显示错误消息
            }
        }
    }

    public static void main(String[] args) { // 主方法
        P3_3_LoanCalculator frame = new P3_3_LoanCalculator(); // 创建贷款计算器窗口
        frame.setTitle("Loan Calculator"); // 设置窗口标题
        frame.setSize(400, 250); // 设置窗口大小
        frame.setLocationRelativeTo(null); // 将窗口居中显示
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭操作
        frame.setVisible(true); // 设置窗口可见
    }
}