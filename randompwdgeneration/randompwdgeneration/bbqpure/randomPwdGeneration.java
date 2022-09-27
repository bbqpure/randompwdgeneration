package bbqpure;

import java.security.SecureRandom;

public class randomPwdGeneration {

    final static String lowerStr = "abcdefghijklmnopqrstuvwxyz";
    final static String upperStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static String specialStr = "~!@#$%^&*()_+/-=[]{};:'<>?.";
    final static String numStr = "0123456789";

    public static String generatePwd(int length) {
        SecureRandom random = new SecureRandom();
        String pwd = "";
        if (length < 4) {
            System.out.println("The length is too short");
        } else {

            pwd += lowerStr.charAt(random.nextInt(lowerStr.length()));
            pwd += numStr.charAt(random.nextInt(numStr.length()));
            pwd += upperStr.charAt(random.nextInt(upperStr.length()));
            pwd += specialStr.charAt(random.nextInt(specialStr.length()));

            for (int i = 0; i < length - 4; i++) {
                int rInt = random.nextInt(4);
                if (rInt == 0) {
                    pwd += lowerStr.charAt(random.nextInt(lowerStr.length()));
                } else if (rInt == 1) {
                    pwd += numStr.charAt(random.nextInt(numStr.length()));
                } else if (rInt == 2) {
                    pwd += upperStr.charAt(random.nextInt(upperStr.length()));
                } else {
                    pwd += specialStr.charAt(random.nextInt(specialStr.length()));
                }
            }
        }
        return restoreString(pwd);
    }

    public static String restoreString(String s) {
        SecureRandom random = new SecureRandom();
        int len = s.length();
        char[] chars = s.toCharArray();
        char temp;
        for (int i = 0; i < len; i++) {
            int index = random.nextInt(len);
            temp = chars[i];
            chars[i] = chars[index];
            chars[index] = temp;
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        int len = 10;
        int times = 10;
        for (int i = 0; i < times; i++) {
            System.out.println(generatePwd(len));
        }


    }


}
