package com.demo.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * com.demo.utils
 *
 * @author caofengnian
 * @Date 2019-10-16
 */
public class CheckStrengthUtil {
    private static final int NUM = 1;
    private static final int SMALL_LETTER = 2;
    private static final int CAPITAL_LETTER = 3;
    private static final int OTHER_CHAR = 4;
    /**
     * Simple password dictionary
     *
     * @author sunmj
     * @date 2019/7/26
     */
    private final static String[] DICTIONARY = {"password", "abc123", "iloveyou", "adobe123", "123123", "sunshine",
            "1314520", "a1b2c3", "123qwe", "aaa111", "qweasd", "admin", "passwd","passwd123"};

    /**
     * Check character's type, includes num, capital letter, small letter and other character.
     *
     * @author sunmj
     * @date 2019/7/26
     */
    private static int checkCharacterType(char c) {
        if (c >= 48 && c <= 57) {
            return NUM;
        }
        if (c >= 65 && c <= 90) {
            return CAPITAL_LETTER;
        }
        if (c >= 97 && c <= 122) {
            return SMALL_LETTER;
        }
        return OTHER_CHAR;
    }

    /**
     * Count password's number by different type
     *
     * @author sunmj
     * @date 2019/7/26
     */
    private static int countLetter(String passwd, int type) {
        int count = 0;
        if (null != passwd && passwd.length() > 0) {
            for (char c : passwd.toCharArray()) {
                if (checkCharacterType(c) == type) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Check password's strength
     *
     * @author sunmj
     * @date 2019/7/26
     */
    public static int checkPasswordStrength(String passwd) {
        if (StringUtils.isBlank(passwd)) {
            throw new IllegalArgumentException("password is empty");
        }
        int len = passwd.length();
        int level = 0;

        // increase points
        if (countLetter(passwd, NUM) > 0) {
            //密码中包含数字
            level++;
        }
        if (countLetter(passwd, SMALL_LETTER) > 0) {
            //密码中包含小写字母
            level++;
        }
        if (len > 4 && countLetter(passwd, CAPITAL_LETTER) > 0) {
            //密码中包含大写字母
            level++;
        }
        if (len > 6 && countLetter(passwd, OTHER_CHAR) > 0) {
            //密码中包含特殊字符
            level++;
        }

        //数字、小写字母、大写字母、特殊字符两两组合
        if (len > 4 && countLetter(passwd, NUM) > 0 && countLetter(passwd, SMALL_LETTER) > 0
                || countLetter(passwd, NUM) > 0 && countLetter(passwd, CAPITAL_LETTER) > 0
                || countLetter(passwd, NUM) > 0 && countLetter(passwd, OTHER_CHAR) > 0
                || countLetter(passwd, SMALL_LETTER) > 0 && countLetter(passwd, CAPITAL_LETTER) > 0
                || countLetter(passwd, SMALL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0
                || countLetter(passwd, CAPITAL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0) {
            level++;
        }

        //数字、小写字母组合、大写字母、特殊字符三三组合
        if (len > 6 && countLetter(passwd, NUM) > 0 && countLetter(passwd, SMALL_LETTER) > 0
                && countLetter(passwd, CAPITAL_LETTER) > 0 || countLetter(passwd, NUM) > 0
                && countLetter(passwd, SMALL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0
                || countLetter(passwd, NUM) > 0 && countLetter(passwd, CAPITAL_LETTER) > 0
                && countLetter(passwd, OTHER_CHAR) > 0 || countLetter(passwd, SMALL_LETTER) > 0
                && countLetter(passwd, CAPITAL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0) {
            level++;
        }

        //数字、小写字母组合、大写字母、特殊字符全组合
        if (len > 8 && countLetter(passwd, NUM) > 0 && countLetter(passwd, SMALL_LETTER) > 0
                && countLetter(passwd, CAPITAL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0) {
            level++;
        }

        //数字、小写字母组合、大写字母、特殊字符两两组合 并出现三次以上
        if (len > 6 && countLetter(passwd, NUM) >= 3 && countLetter(passwd, SMALL_LETTER) >= 3
                || countLetter(passwd, NUM) >= 3 && countLetter(passwd, CAPITAL_LETTER) >= 3
                || countLetter(passwd, NUM) >= 3 && countLetter(passwd, OTHER_CHAR) >= 2
                || countLetter(passwd, SMALL_LETTER) >= 3 && countLetter(passwd, CAPITAL_LETTER) >= 3
                || countLetter(passwd, SMALL_LETTER) >= 3 && countLetter(passwd, OTHER_CHAR) >= 2
                || countLetter(passwd, CAPITAL_LETTER) >= 3 && countLetter(passwd, OTHER_CHAR) >= 2) {
            level++;
        }

        //数字、小写字母组合、大写字母、特殊字符三三组合 并出现两次以上
        if (len > 8 && countLetter(passwd, NUM) >= 2 && countLetter(passwd, SMALL_LETTER) >= 2
                && countLetter(passwd, CAPITAL_LETTER) >= 2 || countLetter(passwd, NUM) >= 2
                && countLetter(passwd, SMALL_LETTER) >= 2 && countLetter(passwd, OTHER_CHAR) >= 2
                || countLetter(passwd, NUM) >= 2 && countLetter(passwd, CAPITAL_LETTER) >= 2
                && countLetter(passwd, OTHER_CHAR) >= 2 || countLetter(passwd, SMALL_LETTER) >= 2
                && countLetter(passwd, CAPITAL_LETTER) >= 2 && countLetter(passwd, OTHER_CHAR) >= 2) {
            level++;
        }

        //数字、小写字母组合、大写字母、特殊字符全组合 并出现两次以上
        if (len > 10 && countLetter(passwd, NUM) >= 2 && countLetter(passwd, SMALL_LETTER) >= 2
                && countLetter(passwd, CAPITAL_LETTER) >= 2 && countLetter(passwd, OTHER_CHAR) >= 2) {
            level++;
        }

        //特殊字符出现三次以上
        if (countLetter(passwd, OTHER_CHAR) >= 3) {
            level++;
        }

        //特殊字符出现六次以上
        if (countLetter(passwd, OTHER_CHAR) >= 6) {
            level++;
        }

        //长度
        if (len > 12) {
            level++;
            if (len >= 16) {
                level++;
            }
        }

        /* 以下为弱密码 */
        // decrease points
        if ("abcdefghijklmnopqrstuvwxyz".indexOf(passwd) > 0 || "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(passwd) > 0) {
            level--;
        }
        if ("qwertyuiop".indexOf(passwd) > 0 || "asdfghjkl".indexOf(passwd) > 0 || "zxcvbnm".indexOf(passwd) > 0) {
            level--;
        }
       /* if (StrUtils.isNumeric(passwd) && ("01234567890".indexOf(passwd) > 0 || "09876543210".indexOf(passwd) > 0)) {
            level--;
        }
*/
        if (countLetter(passwd, NUM) == len || countLetter(passwd, SMALL_LETTER) == len
                || countLetter(passwd, CAPITAL_LETTER) == len) {
            level--;
        }

        /* 重复字符 */
        if (len % 2 == 0) { // aaabbb
            String part1 = passwd.substring(0, len / 2);
            String part2 = passwd.substring(len / 2);
            if (part1.equals(part2)) {
                level--;
            }
            /*if (StrUtils.isCharEqual(part1) && StrUtils.isCharEqual(part2)) {
                level--;
            }*/
        }
        if (len % 3 == 0) { // ababab
            String part1 = passwd.substring(0, len / 3);
            String part2 = passwd.substring(len / 3, len / 3 * 2);
            String part3 = passwd.substring(len / 3 * 2);
            if (part1.equals(part2) && part2.equals(part3)) {
                level--;
            }
        }
        /* 弱密码字典 */
        if (null != DICTIONARY && DICTIONARY.length > 0) {// dictionary
            for (int i = 0; i < DICTIONARY.length; i++) {
                if (passwd.equals(DICTIONARY[i]) || DICTIONARY[i].indexOf(passwd) >= 0) {
                    level--;
                    break;
                }
            }
        }

        if (len <= 6) {
            level--;
            if (len <= 4) {
                level--;
                if (len <= 3) {
                    level = 0;
                }
            }
        }

       /* if (StrUtils.isCharEqual(passwd)) {
            level = 0;
        }*/

        if (level < 0) {
            level = 0;
        }

        return level;
    }

    /**
     * Get password strength level, includes easy, midium, strong, very strong, extremely strong
     *
     * @param passwd
     * @return
     */
    public static LEVEL getPasswordLevel(String passwd) {
        int level = checkPasswordStrength(passwd);
        switch (level) {
            case 0:
            case 1:
            case 2:
            case 3:
                return LEVEL.EASY;
            case 4:
            case 5:
            case 6:
                return LEVEL.MIDIUM;
            case 7:
            case 8:
            case 9:
                return LEVEL.STRONG;
            case 10:
            case 11:
            case 12:
                return LEVEL.VERY_STRONG;
            default:
                return LEVEL.EXTREMELY_STRONG;
        }
    }

    /**
     * 输出连续的三个数字字符
     *
     * @author sunmj
     * @date 2019/7/26
     */
    private static String continuityNum3(int c, String sort) {

        StringBuffer stringBuffer = new StringBuffer();
        if (sort.equals("asc")) {
            stringBuffer.append(new Character((char) (c + '0')).toString())
                    .append(new Character((char) ((c + 1) + '0')).toString())
                    .append(new Character((char) ((c + 2) + '0')).toString());
        } else if (sort.equals("desc")) {
            stringBuffer.append(new Character((char) (c + '0')).toString())
                    .append(new Character((char) ((c - 1) + '0')).toString())
                    .append(new Character((char) ((c - 2) + '0')).toString());
        }

        return stringBuffer.toString();
    }

    /**
     * 获取数字弱密码组合
     *
     * @author sunmj
     * @date 2019/7/26
     */
    private static String[] getNumDictionary() {
        String[] numArray = new String[14];

        int index = 0;
        for (int i = 1; i < 8; i++) {
            numArray[index++] = continuityNum3(i, "asc");
        }

        for (int i = 9; i > 2; i--) {
            numArray[index++] = continuityNum3(i, "desc");
        }
        return numArray;
    }

    /**
     * 匹配弱密码与连续数字组合
     *
     * @author sunmj
     * @date 2019/8/5
     */
    private static boolean matchingWeakPassword(String passwd) {
        String[] numDictionary = getNumDictionary();
        /* 弱密码字典 */
        if (null != DICTIONARY && DICTIONARY.length > 0) {
            // dictionary
            for (int i = 0; i < DICTIONARY.length; i++) {
                if (passwd.equals(DICTIONARY[i])) {
                    return true;
                }
                if (passwd.indexOf(DICTIONARY[i]) == 0) {
                    //有且只匹配到一个弱密码，匹配组合是否存在数字组合
                    String[] split = passwd.split(DICTIONARY[i]);
                    if (split.length > 1) {

                        boolean oneEmpty = false;//一个是空
                        boolean oneNum = false;//一个是连续数字

                        for (int c = 0; c < split.length; c++) {
                            if (StrUtils.isBlank(split[c])) {
                                oneEmpty = true;
                                continue;
                            }
                            for (int j = 0; j < numDictionary.length; j++) {
                                split[c].equals(numDictionary[j]);
                                oneNum = true;
                                break;
                            }
                        }

                        if (oneEmpty && oneNum) {//弱密码加上连续数字组合或者两个都是空
                            return oneEmpty;
                        }

                    }

                }
            }
        }
        return false;
    }

    /**
     * 不能全是相同的数字或者字母（如：000000、111111、aaaaaa）
     * @param numOrStr str.length()>0
     * @return 全部相同返回true
     */
    public static boolean equalStr(String numOrStr){
        boolean flag = true;
        char str = numOrStr.charAt(0);
        for (int i = 0; i < numOrStr.length(); i++) {
            if (str != numOrStr.charAt(i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        String passwd = "2hAj5#mne-ix.86H";
//		System.out.println(CheckStrengthUtil.checkPasswordStrength(passwd));

//		System.out.println("");

//		System.out.println("passwd123".indexOf("passwd"));

        boolean b = matchingWeakPassword("1111");
        System.out.println(CheckStrengthUtil.checkPasswordStrength("2hAj5#mne-ix.86H"));
        System.out.println(equalStr("112"));
    }


    public enum LEVEL {
        EASY, MIDIUM, STRONG, VERY_STRONG, EXTREMELY_STRONG
    }
}