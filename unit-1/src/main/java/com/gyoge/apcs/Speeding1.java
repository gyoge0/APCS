// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class Speeding1 {

    public static int caughtSpeeding(int speed, boolean isBirthday) {
        if (isBirthday && speed > 85 || !isBirthday && speed > 80) return 2;
        if (isBirthday && speed > 65 || !isBirthday && speed > 60) return 1;
        return 0;
    }
}
