package com.belyf;

class Leap {

    boolean isLeapYear(int year) {
        year = year % 100 == 0 ? year / 100 : year;
        return year % 4 == 0;
    }

}
