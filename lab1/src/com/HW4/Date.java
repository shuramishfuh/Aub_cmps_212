package com.HW4;

import java.util.TimeZone;

public class Date {
    private int year;
    private int month;
    private int day;
    private int daysSinceStart=0;
    private static final String[] Days = new String[]{ "Thursday", "Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday"};
    private static final int dayInMonth[] = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    private static final int[] months = new int[]{-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};// pass test

    public Date(int year, int month, int day) {
        this.day = day;
        this.year = year;
        this.month = month;
    }

        public Date() {
        int daysSinceEpoch = (int) ((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);
        this.daysSinceStart= daysSinceEpoch;
        int count = 1;
        this.year = 1970;
        this.month=1;
        while (daysSinceEpoch>=365) {
            //leap year
            if (this.year % 400 == 0 || this.year % 4 == 0 && this.year % 100 != 0) {

                if ((daysSinceEpoch - 366) > 0) {
                    this.year++;
                    daysSinceEpoch -= 366;
                }
            }
            // non leap
            else if ((daysSinceEpoch - 365) > 0) {
                this.year++;
                daysSinceEpoch -= 365;
            }
        }
            // set months
            while (daysSinceEpoch>27) {
                if (this.year % 400 == 0 || this.year % 4 == 0 && this.year % 100 != 0) {
                    for (int month : dayInMonth) {
                        if (daysSinceEpoch > month) {
                            daysSinceEpoch -= month;
                            this.month++;
                            if (this.month == 2) {
                                daysSinceEpoch -= 1;
                            }
                        } else {
                            this.day =daysSinceEpoch;
                            break;
                        }
                    }
                } else {
                    for (int month : dayInMonth) {
                        if (daysSinceEpoch > month) {
                            daysSinceEpoch -= month;
                            this.month++;
                        } else {
                            this.day =daysSinceEpoch;
                            break;
                        }
                    }
                }
            }
    }

        public int getDay () {
            return this.day;
        }
        public int getYear () {
            return this.year;
        }
        public int getMonth () {
            return this.month;
        }
        public String toString () {
            return this.year + "/" + this.month + "/" + this.day;
        }
        public String getDayOfWeek () {
            if (this.daysSinceStart == 0)
                return Days[((int) ((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24) % 7)];
            else {
                int count = 1;

                for (TeacherDate temp = new TeacherDate(1753, 1, 1); !temp.equals(this); count = (count + 1) % 7) {
                    temp.nextDay();
                }
                return Days[count];
            }
        }
        public boolean isLeapYear() {
        return this.year % 400 == 0 || this.year % 4 == 0 && this.year % 100 != 0;
    }
        private int getTotalDaysInMonths() {
        int result = months[this.month];
        if (this.month == 2 && this.isLeapYear()) {
            ++result;
        }
            return result;
    }

        public void nextDay(){
        ++this.day;
        if (this.day > this.getTotalDaysInMonths()) {
            ++this.month;
            this.day = 1;
            if (this.month > 12) {
                ++this.year;
                this.month = 1;
            }
        }

    }


    }
