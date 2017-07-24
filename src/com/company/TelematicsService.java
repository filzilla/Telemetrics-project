package com.company;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

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

        File file = new File(“.”);
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(“.json”)) {


            }
        }

        VehicleInfo vi = mapper.readValue(json, VehicleInfo.class);

        System.out.println(vi);




    } catch (IOException e) {


        e.printStackTrace();
    }








    };
}
