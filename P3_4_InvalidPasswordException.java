public class P3_4_InvalidPasswordException extends Exception { // 定义一个继承自Exception的类

    public P3_4_InvalidPasswordException() { // 无参构造函数
        super("Invalid Password Exception."); // 调用父类构造函数
    }

    public P3_4_InvalidPasswordException(String errMsg) { // 带参构造函数
        super(errMsg); // 调用父类构造函数
    }
}