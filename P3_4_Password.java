public class P3_4_Password { // 定义密码类

    private String passwordStr; // 密码字符串

    public P3_4_Password(String passwordStr) throws P3_4_InvalidPasswordException { // 构造函数
        if (passwordStr == null || passwordStr.equals("")) { // 如果密码为空或空字符串
            throw new P3_4_InvalidPasswordException("Invalid password: password cannot be null or an empty string."); // 抛出异常
        } else {
            int countDigits = 0; // 数字计数器
            int countLetters = 0; // 字母计数器

            for (int i = 0; i < passwordStr.length(); ++i) { // 遍历密码字符串
                char ch = passwordStr.charAt(i); // 获取当前字符
                if (Character.isDigit(ch)) // 如果字符是数字
                    countDigits++; // 数字计数器加1
                else if (Character.isLetter(ch)) // 如果字符是字母
                    countLetters++; // 字母计数器加1
            }
            int countAlphaNumeric = countDigits + countLetters; // 计算字母和数字的总数

            String errMsg = ""; // 错误消息
            if (countDigits == 0) // 如果数字数量为0
                errMsg += "Your password should have at least 1 digit.\n"; // 添加错误消息
            if (countLetters == 0) // 如果字母数量为0
                errMsg += "Your password should have at least 1 letter.\n"; // 添加错误消息
            if (countAlphaNumeric < 7) // 如果字母和数字的总数小于7
                errMsg += "Your password should have at least 7 alpha-numeric characters.\n"; // 添加错误消息

            if (!errMsg.equals("")) // 如果有错误消息
                throw new P3_4_InvalidPasswordException(errMsg); // 抛出异常
        }
        this.passwordStr = passwordStr; // 初始化密码字符串
    }
}