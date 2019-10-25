package com.jijian.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

/**
 * @author chenchuan
 * @date 2019/10/25 11:39
 */
public class DirectoryUtil {
    private static String rootPathWithDate;
    private static String lastUpdateDay = "none";


    /**
     * 获取带日期的目录
     *
     * @return
     */
    public static String getRootPathWithDate() {
        Calendar calendar = Calendar.getInstance();
        String day = calendar.get(Calendar.DATE) + "";
        if (lastUpdateDay.equals(day)) {
            return rootPathWithDate;
        }

        String year = calendar.get(Calendar.YEAR) + "";
        String month = calendar.get(Calendar.MONTH) + 1 + "";

        Path path = Paths.get(year, month, day);
        File file = new File(path.toUri());
        if (file.isDirectory() || file.mkdirs()) {
            rootPathWithDate = path.toString();
            lastUpdateDay = day;
        }
        return rootPathWithDate;
    }

    /**
     * 获取带日期或不带日期的目录
     *
     * @return
     */
    public static void main(String[] args) {
        System.out.println(DirectoryUtil.getRootPathWithDate());
    }
}
