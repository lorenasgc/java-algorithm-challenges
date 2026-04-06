package io.github.lorenasgc.math;

/*
Exercise: Angle between hands of the clock
Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
Answers within 10-5 of the actual value will be accepted as correct.
 */

public class AngleBetweenHandsOfClock {
    public static void main(String[] args) {
        double angle = getAngle(3, 30);
        System.out.println("The angle is: " + angle);
    }

    public static double getAngle (int hour, int minutes){
        //First, we calculate the angle of the minute handle
        int calc_minutes = 360 / 60;
        System.out.println("calc_minutes: " + calc_minutes);
        double angle_minutes = minutes * calc_minutes;

        //Next, we calculate the angle of the hour handle, taking into account that it is not always on O'clock.
        double calc_hour = 360 / 12;
        System.out.println("calc_hour: " + calc_hour);
        double calc_extra_hour = calc_hour / 60;
        System.out.println("calc_extra : " + calc_extra_hour);
        //We use % to calculate 12:00 as 0
        double angle_hora = (hour % 12) * calc_hour + (minutes * calc_extra_hour);
        //We calculate the absolute difference between the two handles
        double angle = Math.abs(angle_hora - angle_minutes);

        //We return the smallest angle (always <= 180)
        return Math.min(360 - angle, angle);
    }
}
