package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            wheels = new ArrayList<>();
            Wheel[] array = Wheel.values();


            for (String wheel: loadWheelNamesFromDB()) {
                Wheel w = null;
                for (int i = 0; i < array.length; i++) {
                    if (array[i].toString().equals(wheel)) {
                        w = array[i];
                        break;
                    }
                }
                if (w != null) {
                    wheels.add(w);
                } else {
                    throw new Exception();
                }
            }

            if (wheels.size() != 4) { throw new Exception(); }
         }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car();
        System.out.println(car.wheels);
    }
}
