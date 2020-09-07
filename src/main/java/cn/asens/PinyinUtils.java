package cn.asens;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * @author Asens
 * create 2020-09-08 7:14
 **/

public class PinyinUtils {
    public static String toPinyin(String words){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < words.length(); i++) {
            String[] t = PinyinHelper.toHanyuPinyinStringArray(words.charAt(i));
            if(t==null || t.length==0){
                continue;
            }
            str.append(t[0], 0, t[0].length()-1).append(" ");
        }
        return str.toString();
    }
}
