package me.learning.javabasic.excercise9;

public class DateUtil {

    private final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",

            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday",

            "Thursday", "Friday", "Saturday"};
    private final int[] nonLeapYearMonthNumbers = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};


    private final int[] leapYearMonthNumbers = {6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};

    public static void main(String[] args) {
        DateUtil dateUtil = new DateUtil();
//        System.out.println(dateUtil.getDayOfWeek(2012, 2, 17));
//        if (dateUtil.isValidDate(2012, 12, -1)) {
//            System.out.println(dateUtil.toString(2012, 2, 17));
//        } else {
//            System.out.println("Date not valid");
//        }
        System.out.println(dateUtil.isLeapYear(2011));
        System.out.println(dateUtil.isValidDate(2012, 2, 29));  // true
        System.out.println(dateUtil.isValidDate(2011, 2, 29));  // false
        System.out.println(dateUtil.isValidDate(2099, 12, 31)); // true
        System.out.println(dateUtil.isValidDate(2099, 12, 32)); // false


    }

    /**
     * returns true if the given year is a leap year.
     *
     * @param year
     * @return
     */
    public boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year / 4 != 100) || year % 400 == 0);
    }

    /**
     * returns true if the given year, month and day constitute a given date
     */
    public boolean isValidDate(int year, int month, int day) {
        return (1 < year && year < 9999) && (1 <= month && month <= 12)
                && ((1 <= day && day <= 28) || (1 <= day && day <= 29)
                || (1 <= day && day <= 30) || (1 <= day && day <= 31));
    }

    /**
     * returns the day of the week,
     */
    public int getDayOfWeek(int year, int month, int day) {
        int numberCentury = 6 - 2 * (year / 100 % 4);
        int numberDay = 0;
        int digitsNumber = year % 100;
        if (isLeapYear(year)) {
            numberDay = leapYearMonthNumbers[month - 1];
        } else {
            numberDay = nonLeapYearMonthNumbers[month - 1];
        }
        int dayOfWeek = (numberCentury + digitsNumber + digitsNumber / 4 + numberDay + day) % 7;
        System.out.println(numberCentury + " " + digitsNumber + " " + digitsNumber + " " + numberDay);
        return dayOfWeek;
    }

    /**
     * prints the given date in the format "xxxday d mmm yyyy", e.g., "Tuesday 14 Feb 2012".
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public String toString(int year, int month, int day) {
        int dayOfWeek = getDayOfWeek(year, month, day);
        return days[dayOfWeek] + " " + day + " " + months[month - 1] + " " + year;
    }
}
