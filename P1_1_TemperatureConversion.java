import javax.swing.JOptionPane;  // 导入JOptionPane类，用于显示对话框

public class P1_TemperatureConversion {

    public static void main (String[] args) {
       int option = JOptionPane.YES_OPTION;  // 初始化选项变量，设置为YES_OPTION，表示用户选择“是”
       do {
            String inputStr = JOptionPane.showInputDialog(null, "Enter a temperature in Fahrenheit:");// 显示输入对话框，提示用户输入华氏温度
            double fahrenheit = Double.parseDouble(inputStr);// 将用户输入的字符串转换为double类型的浮点数
            double celsius = 5.0/9.0  * (fahrenheit - 32);// 根据华氏温度计算摄氏温度，公式为：C = 5/9 * (F - 32)
            JOptionPane.showMessageDialog(null, "Temperature converted to Celsius: " + celsius);// 显示消息对话框，输出转换后的摄氏温度
            option = JOptionPane.showConfirmDialog(null, "Enter another temperature?");// 显示确认对话框，询问用户是否继续输入另一个温度
            
       } while(option == JOptionPane.YES_OPTION);  // 如果用户选择“是”，则继续循环
    }

}
