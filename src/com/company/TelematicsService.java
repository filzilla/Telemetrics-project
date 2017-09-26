package com.company;



import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Created by phillipdelia on 7/21/17.
 */
public class TelematicsService {

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

        ArrayList<VehicleInfo> vehicleList = new ArrayList<>();


        try {
            File file = new File(".");
            for (File f : file.listFiles()) {
                if (f.getName().endsWith(".json")) {
                    String jsonRead = null;
                    jsonRead = new String(Files.readAllBytes(Paths.get(f.getPath())));
                    ObjectMapper mapper2 = new ObjectMapper();
                    VehicleInfo vehicleInfoRead = mapper2.readValue(jsonRead, VehicleInfo.class);
                    vehicleList.add(vehicleInfoRead);
                }
            }

        } catch (IOException e){
        e.printStackTrace();
    }

                System.out.println(vehicleList);
        System.out.println(vehicleList.toString());


        }





    }

