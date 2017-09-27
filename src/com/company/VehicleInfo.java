package com.company;

/**
 * Created by phillipdelia on 7/21/17.
 */
public class VehicleInfo {

   public int VIN;
   public double odometer;
   public double gasConsumption;
   public double oilChangeMileage;
   public double engineSize;


    public void vehicleInfo(){

    }


    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getGasConsumption() {
        return gasConsumption;
    }

    public void setGasConsumption(double gasConsumption) {
        this.gasConsumption = gasConsumption;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public double getOilChangeMileage() {
        return oilChangeMileage;

    }

    @Override
    public String toString() {

        return (" VIN: " + getVIN() + " Odometer: " + getOdometer() + " LastOilChange: " + getOilChangeMileage() + " Engine: " + getEngineSize());
    }

    public void setOilChangeMileage(double oilChangeMileage) {
        this.oilChangeMileage = oilChangeMileage;
    }



        public static final String HTMLText= "<html>"
    + "<title>Vehicle Telematics Dashboard</title>"
    + "<body>"
    + "<h1 align=\"center\">Averages for # vehicles</h1>"
    + "<table align=\"center\">"
    + "<tr>"
    + "<th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>"
    + "</tr>"
    + "<tr>"
        + "<td align=\"center\">#1</td><td align=\"center\">#2</td><td align=\"center\">#3</td align=\"center\"><td align=\"center\">#4</td>"
    + "</tr>"
    + "</table>"
    + "<h1 align=\"center\">History</h1>"
    + "<table align=\"center\" border=\"1\">"
    + "<tr>"
        + "<th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>"
    + "</tr>";

    public static final String HTMLData =  "<tr>"
       + "<td align=\"center\">#5</td><td align=\"center\">#6</td><td align=\"center\">#7</td><td align=\"center\">#8</td align=\"center\"><td align=\"center\">#9</td>"
            + "</tr>";

    public static final String HTMLClose =
    "</table>"
    + "</body>"
    + "</html>";


}




