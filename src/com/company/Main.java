package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        VehicleInfo carData = new VehicleInfo();


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your vehicle VIN number.");
        int VIN = scanner.nextInt();
        carData.setVIN(VIN);

        System.out.println("Please enter your vehicle's odometer reading");
        double odometer = scanner.nextDouble();
        carData.setOdometer(odometer);

        System.out.println("Please enter your vehicle's gas consumption.");
        double gasConsumption = scanner.nextDouble();
        carData.setGasConsumption(gasConsumption);

        System.out.println("Please enter your vehicle's odometer reading from your last oil change.");
        double oilChangeMileage = scanner.nextDouble();
        carData.setOilChangeMileage(oilChangeMileage);

        System.out.println("Please enter your vehicle's engine size.");
        double engineSize = scanner.nextDouble();
        carData.setEngineSize(engineSize);


        System.out.println(carData.getVIN());
        System.out.println(carData.getOdometer());
        System.out.println(carData.getGasConsumption());
        System.out.println(carData.getOilChangeMileage());
        System.out.println(carData.getEngineSize());

        TelematicsService serviceCall = new TelematicsService();


        serviceCall.report(carData);
    }
}
