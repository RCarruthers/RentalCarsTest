package com.ryan.uom.RentalCarsTest.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SippMap {

    static Map<Character, String> carTypeMap = new HashMap<Character, String>();
    static Map<Character, String> carDoorsMap = new HashMap<Character, String>();
    static Map<Character, String> transmissionMap = new HashMap<Character, String>();
    static Map<Character, String> fuelAcMap = new HashMap<Character, String>();

    public static String getCarType(Character c) {
        return carTypeMap.get(c);
    }

    public static String getCarDoors(Character c) {
        return carDoorsMap.get(c);
    }

    public static String getTransmission(Character c) {
        return transmissionMap.get(c);
    }

    public static String getFuel(Character c) {
        return fuelAcMap.get(c).split("/")[0];
    }

    public static String getAc(Character c) {
        return fuelAcMap.get(c).split("/")[1];
    }


    static {
        carTypeMap.put('M', "Mini");
        carTypeMap.put('E', "Economy");
        carTypeMap.put('C', "Compact");
        carTypeMap.put('I', "Intermediate");
        carTypeMap.put('S', "Standard");
        carTypeMap.put('F', "Full Size");
        carTypeMap.put('P', "Premium");
        carTypeMap.put('L', "Luxury");

        carDoorsMap.put('B', "2 doors");
        carDoorsMap.put('C', "4 doors");
        carDoorsMap.put('D', "5 doors");
        carDoorsMap.put('W', "Estate");
        carDoorsMap.put('T', "Convertible");
        carDoorsMap.put('F', "SUV");
        carDoorsMap.put('P', "Pick up");
        carDoorsMap.put('V', "Passenger Van");
        carDoorsMap.put('X', "Special");

        transmissionMap.put('M', "Manual");
        transmissionMap.put('A', "Automatic");

        fuelAcMap.put('N', "Petrol/no AC");
        fuelAcMap.put('R', "Petrol/AC");
    }

}
