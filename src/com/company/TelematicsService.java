package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static com.company.VehicleInfo.HTMLClose;
import static com.company.VehicleInfo.HTMLData;
import static com.company.VehicleInfo.HTMLText;


/**
 * Created by phillipdelia on 7/21/17.
 */
public class TelematicsService extends VehicleInfo{

    public void report(VehicleInfo vehicleInfo){


        ObjectMapper mapper = new ObjectMapper();

        String json;

        try {
            File newCarData = new File(vehicleInfo.getVIN() + ".json");
            json = mapper.writeValueAsString(vehicleInfo);
            FileWriter createFile = new FileWriter(newCarData);
            createFile.write(json);
            createFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 1. convert File back to java
        // 2.  create variables for the html / replace html
        //3. inject html back to page

        String htmlData = "";
        String htmlAVGdata = "";

        Integer count =0;

        double odometerSum = 0;
        double gasConsumptionSum = 0;
        double oilChangeMileageSum = 0;
        double engineSizeSum = 0;
        try {
            File file = new File(".");
            for (File f : file.listFiles()) {
                if (f.getName().endsWith(".json")) {

                    ObjectMapper mapper2 = new ObjectMapper();
                    VehicleInfo vi = mapper2.readValue(f, VehicleInfo.class);

                    count++;
                    odometerSum = odometerSum + vi.getOdometer();
                    gasConsumptionSum = gasConsumptionSum + vi.getGasConsumption();
                    oilChangeMileageSum = oilChangeMileageSum + vi.getOilChangeMileage();
                    engineSizeSum = engineSizeSum + vi.getEngineSize();

                    String  htmlData1 = changeHTML(HTMLData, vi.getVIN(), vi.getOdometer(), vi.getGasConsumption(), vi.getOilChangeMileage(), vi.getEngineSize());
                     htmlAVGdata = getAverage(HTMLText,  count,  odometerSum,  gasConsumptionSum,  oilChangeMileageSum,  engineSizeSum );

                    System.out.println(htmlData1);
                    System.out.println("---------------------------------");

                    htmlData+= htmlData1;

                    System.out.println(htmlData);
                }
            }

        } catch (IOException e){
        e.printStackTrace();
    }

        String html = htmlAVGdata  + htmlData  + HTMLClose;

        try{
            File htmlFile = new File("dashboard.html");
            FileWriter newFile = new FileWriter(htmlFile);

            newFile.write(html);
            newFile.close();


        } catch (IOException ex) {
            ex.printStackTrace();
        }

}


    public static String getAverage (String template, Integer count, double odometerSum, double gasConsumptionSum, double oilChangeMileageSum,double engineSizeSum ){

        double odometerAvg = (Math.round(((odometerSum/count)*10d)/10));
        double gasConsumptionAvg = (Math.round(((gasConsumptionSum/count)*10d)/10));
        double oilChangeMileageAvg = (Math.round(((oilChangeMileageSum/count)*10d)/10));
        double engineSizeAvg = (Math.round(((engineSizeSum/count)*10d)/10));


        String htmlAvg = template.replace("#1", Double.toString(odometerAvg));
         htmlAvg = htmlAvg.replace("#2", Double.toString(gasConsumptionAvg));
         htmlAvg = htmlAvg.replace("#3", Double.toString(oilChangeMileageAvg));
         htmlAvg = htmlAvg.replace("#4", Double.toString(engineSizeAvg));
         htmlAvg = htmlAvg.replace("#",Integer.toString(count));

        return htmlAvg;
    }

    public static String changeHTML (String template, int VIN, double odometer, double gasConsumption, double oilChangeMileage, double engineSize) {

           // String html = template;
           String html = template.replace("#5", Integer.toString(VIN));
            html = html.replace("#6", Double.toString(odometer));
            html = html.replace("#7", Double.toString(gasConsumption));
            html = html.replace("#8", Double.toString(oilChangeMileage));
            html = html.replace("#9", Double.toString(engineSize));

        return html;
    }






    }

