package day09;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DaysBetweenDates {
    /*
        请你编写一个程序来计算两个日期之间隔了多少天。
        日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
        示例 1：
                输入：date1 = "2019-06-29", date2 = "2019-06-30"
                输出：1
        示例 2：
                输入：date1 = "2020-01-15", date2 = "2019-12-31"
                输出：15
     */
    public static void main(String[] args) {
        String date1 = "2020-01-15", date2 = "2019-12-31";
        System.out.println(daysBetweenDates(date1, date2));
    }

    // 方法一：
    public static int daysBetweenDates(String date1, String date2) {
        // 将字符串解析为 LocalDate
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);

        // 计算日期之间的天数
        return Math.abs((int) ChronoUnit.DAYS.between(d1, d2));
    }

    // 方法二：
    public static int daysBetweenDates1(String date1, String date2) {
        int[] d1 = toInt(date1);
        int[] d2 = toInt(date2);
        return Math.abs(dateToInt(d1[0], d1[1], d1[2]) - dateToInt(d2[0], d2[1], d2[2]));
    }

    // 将日期转换为天数（自 1971-01-01 起算）
    public static int dateToInt(int year, int month, int day) {
        int[] monthLength = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = day - 1; // 减去1是因为要算当月的天数
        while (month > 0) {
            month--;
            days += monthLength[month];
            if (month == 2 && leapYear(year)) // 闰年且当前月份为2月
                days++;
        }
        // 加上年份的天数
        days += 365 * (year - 1971);
        days += (year - 1) / 4 - 1971 / 4; // 加上闰年天数
        days -= (year - 1) / 100 - 1971 / 100; // 减去非闰年天数
        days += (year - 1) / 400 - 1971 / 400; // 再加上每400年的闰年天数
        return days;
    }

    // 将日期字符串转换为整数数组
    public static int[] toInt(String date) {
        String[] parts = date.split("-");
        return new int[]{
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2])
        };
    }

    // 判断是否为闰年
    public static boolean leapYear(int year) {
        return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }
}
