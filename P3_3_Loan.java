public class P3_3_Loan { // 定义贷款类

    private double annualInterestRate; // 年利率
    private int numberOfYears; // 贷款年限
    private double loanAmount; // 贷款金额

    public P3_3_Loan(double annualInterestRate, int numberOfYears, double loanAmount) { // 构造函数
        this.annualInterestRate = annualInterestRate; // 初始化年利率
        this.numberOfYears = numberOfYears; // 初始化贷款年限
        this.loanAmount = loanAmount; // 初始化贷款金额
    }

    public double getMonthlyPayment() { // 计算月供的方法
        double monthlyInterestRate = annualInterestRate / 1200; // 计算月利率
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12))); // 计算月供
        return monthlyPayment; // 返回月供
    }

    public double getTotalPayment() { // 计算总还款金额的方法
        return getMonthlyPayment() * numberOfYears * 12; // 返回总还款金额
    }
}