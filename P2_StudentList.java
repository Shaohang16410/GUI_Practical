import java.awt.*; // 导入AWT包，用于图形用户界面
import javax.swing.*; // 导入Swing包，用于创建窗口和组件
import java.awt.event.*; // 导入AWT事件包，用于处理事件
import java.util.ArrayList; // 导入ArrayList类，用于存储学生列表

public class P2_StudentList {
    private ArrayList<String> studentList = new ArrayList<String>(); // 创建一个ArrayList来存储学生姓名
    private JButton btnCreate = new JButton("Create"); // 创建“Create”按钮
    private JButton btnGet = new JButton("Retrieve"); // 创建“Retrieve”按钮
    private JButton btnUpdate = new JButton("Update"); // 创建“Update”按钮
    private JButton btnDelete = new JButton("Delete"); // 创建“Delete”按钮
    private int currentArray = 0; // 用于跟踪当前操作的学生索引

    // 内部类，用于处理“Create”按钮的点击事件
    class CreateStudent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 弹出输入对话框，获取新学生姓名
            String studName = JOptionPane.showInputDialog(null, "Enter new student name: ");
            if (studName != "") { // 如果输入不为空
                studentList.add(studName); // 将新学生姓名添加到列表中
                JOptionPane.showMessageDialog(null, "Student " + studName + " added."); // 显示添加成功的消息
                currentArray = studentList.size() - 1; // 更新当前索引为最后一个学生
                
                // 调用RetrieveStudent的actionPerformed方法，显示更新后的学生列表
                RetrieveStudent retrieveStudent = new RetrieveStudent();
                retrieveStudent.actionPerformed(e);
            }
        }
    }

    // 内部类，用于处理“Retrieve”按钮的点击事件
    class RetrieveStudent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String studentListText = ""; // 创建一个空字符串，用于存储学生列表
            for (int i = 0; i < studentList.size(); i++) { // 遍历学生列表
                studentListText += i+1 + ". " + studentList.get(i) + "\n"; // 将每个学生姓名添加到字符串中
            }
            
            // 弹出消息对话框，显示学生列表
            JOptionPane.showMessageDialog(null, "Student List: \n" + studentListText);
        }
    }

    // 内部类，用于处理“Update”按钮的点击事件
    class UpdateStudent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            var studentName = studentList.get(currentArray); // 获取当前索引对应的学生姓名
            // 弹出输入对话框，获取新学生姓名
            String newStudentName = JOptionPane.showInputDialog(null,"Current student name is " + studentName + ". Enter new name: ");
            if (newStudentName != "") { // 如果输入不为空
                studentList.set(currentArray, newStudentName); // 更新学生姓名
                JOptionPane.showMessageDialog(null, "Student " + studentName + " updated to " + newStudentName); // 显示更新成功的消息
                // 调用RetrieveStudent的actionPerformed方法，显示更新后的学生列表
                RetrieveStudent retrieveStudent = new RetrieveStudent();
                retrieveStudent.actionPerformed(e);
            }
        }
    }

    // 内部类，用于处理“Delete”按钮的点击事件
    class DeleteStudent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            var studentName = studentList.get(currentArray); // 获取当前索引对应的学生姓名
            studentList.remove(currentArray); // 从列表中删除该学生
            JOptionPane.showMessageDialog(null, "Student " + studentName + " deleted."); // 显示删除成功的消息
            // 调用RetrieveStudent的actionPerformed方法，显示更新后的学生列表
            RetrieveStudent retrieveStudent = new RetrieveStudent();
            retrieveStudent.actionPerformed(e);
        }
    }

    // 构造函数，用于初始化窗口和组件
    public P2_StudentList() {
        JFrame frame = new JFrame("CRUD Array"); // 创建一个新的JFrame窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭操作
        frame.setLayout(new BorderLayout()); // 设置窗口布局为BorderLayout
        JPanel panel = new JPanel(); // 创建一个新的JPanel
        panel.setLayout(new FlowLayout()); // 设置JPanel的布局为FlowLayout
        panel.add(btnCreate); // 将“Create”按钮添加到面板
        panel.add(btnGet); // 将“Retrieve”按钮添加到面板
        panel.add(btnUpdate); // 将“Update”按钮添加到面板
        panel.add(btnDelete); // 将“Delete”按钮添加到面板
        frame.add(panel, BorderLayout.CENTER); // 将面板添加到窗口的中心位置
        frame.pack(); // 调整窗口大小以适应组件
        frame.setVisible(true); // 设置窗口可见
    }

    // main方法，程序的入口
    public static void main(String[] args) {
        P2_StudentList frame = new P2_StudentList(); // 创建P2_StudentList对象
        // 为每个按钮添加相应的ActionListener
        frame.btnCreate.addActionListener(frame.new CreateStudent());
        frame.btnGet.addActionListener(frame.new RetrieveStudent());
        frame.btnUpdate.addActionListener(frame.new UpdateStudent());
        frame.btnDelete.addActionListener(frame.new DeleteStudent());
    }
}     
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
