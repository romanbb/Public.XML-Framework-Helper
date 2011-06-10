/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxys_framework_helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roman
 */
public class Main {

    static HashMap<Integer, String> idMap;
    static int hex;

    /**
     * @param args the command lastDrawableInstance arguments
     * [0] - public.xml file
     * [1] - number of battery images to add
     * [2] - number of charging battery images to add
     */
    public static void main(String[] args) throws FileNotFoundException {

        String lastDrawableInstance = "";
        int numberOfBatteryImages = Integer.parseInt(args[1]);
        int numberOfChargingImages = Integer.parseInt(args[2]);
        boolean hasDrawable = false;

        FileOutputStream fos = null;
        PrintWriter out = null;

        if(args[0].equals("public.xml")) {
            System.out.println("Renaming public.xml to public_original.xml");
            File f = new File(args[0]);
            args[0] = "public_original.xml";
            f.renameTo(new File(args[0]));
        }
        Scanner input = new Scanner(new File(args[0]));


        idMap = getHexIDs(args[0]);
//        System.out.println(idMap.get("wifi_available_detailed"));

        try {
            fos = new FileOutputStream(new File("./public.xml"));
            out = new PrintWriter(fos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (input.hasNextLine()) {
            String currentLine = input.nextLine();

            if (currentLine.contains("type=\"drawable\"")) {
                lastDrawableInstance = currentLine;
                hasDrawable = true;
            } else {
                if (hasDrawable) {
//                        System.out.println("Last line before break was: " + currentLine);
                    break;
                }
            }
            out.println(currentLine);
        }

        //find and convert the next hex to use
        int hexLoc = lastDrawableInstance.indexOf("id=\"");
        int endHexLoc = lastDrawableInstance.indexOf("\"", hexLoc + 4);
        String stringHex = lastDrawableInstance.substring(hexLoc + 6, endHexLoc);
        //System.out.println(stringHex);
        hex = Integer.parseInt(stringHex, 16);
        //hex = getNextFreeHex();
//        System.out.println(Integer.toString(hex, 16));
//        System.out.println(idMap.containsValue(hex));

        //add custom strings before battery mod
        if (args.length == 4) {
            Scanner customStrings = new Scanner(new File(args[3]));
            while (customStrings.hasNextLine()) {
                String line = customStrings.nextLine();

                int nameLoc = line.indexOf("name=\"");
                int endNameLoc = line.indexOf("\"", nameLoc + 4);

                String name = line.substring(nameLoc + 6, endNameLoc);
                boolean unique = !idMap.containsValue(name);
                if (!unique) {
                    continue;
                }
                idMap.put(getNextFreeHex(), name);
                name = "name=\"" + name + "\"";


                String hexString = getCurrentHex();

                //boolean unique = !containsName(args[0], name);
                if (unique) {
                    String xmlLine = "\t<public type=\"drawable\" " + name + " id=\"" + hexString + "\" />";
                    out.println(xmlLine);
                }
            }
        }

        for (int i = 1; i <= numberOfBatteryImages; i++) {
            String name = "stat_sys_battery_" + i;
            boolean unique = !idMap.containsValue(name);
            name = "name=\"stat_sys_battery_" + i + "\"";
            if (!unique) {
                continue;
            }
            if (idMap.containsValue(getCurrentHex())) {
//                System.out.println("contains: " + Integer.toString(hex, 16));
            }
            idMap.put(getNextFreeHex(), "stat_sys_battery_" + i);

            String hexString = getCurrentHex();
//            System.out.println(hexString);

            if (unique) {
                String xmlLine = "\t<public type=\"drawable\" " + name + " id=\"" + hexString + "\" />";
                out.println(xmlLine);
            }
        }

        for (int i = 0; i < numberOfChargingImages; i++) {
            String name = "stat_sys_battery_charge_anim" + i;
            boolean unique = !idMap.containsValue(name);
            name = "name=\"stat_sys_battery_charge_anim" + i + "\"";
            if (!unique) {
                continue;
            }
            idMap.put(getNextFreeHex(), "stat_sys_battery_" + i);

            String hexString = getCurrentHex();
//            System.out.println(hexString);
            if (unique) {
                String xmlLine = "\t<public type=\"drawable\" " + name + " id=\"" + hexString + "\" />";
                out.println(xmlLine);
            }
        }



        while (input.hasNextLine()) {
            String line = input.nextLine();
            out.println(line);
        }


        input.close();
        out.close();
        try {
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Done! Look for a new public.xml file");
    }

    public static boolean containsName(String fileName, String name) throws FileNotFoundException {
        File f = new File(fileName);
        Scanner search = new Scanner(f);

        while (search.hasNextLine()) {
            String line = search.nextLine();
            if (line.contains(name)) {
                return true;
            }

        }

        return false;
    }

    private static HashMap<Integer, String> getHexIDs(String filename) {
        HashMap<Integer, String> ids = new HashMap<Integer, String>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(new File(filename)));
        } catch (IOException e) {
        }
        String currentLineString = null;
        int currentLine = 0;
        while (true) {
            currentLine++;
            try {
                currentLineString = in.readLine();
            } catch (IOException e) {
                break;
            }
            if (currentLineString == null) {
                break;
            }
            if (currentLineString.indexOf("id=\"") == -1) {
                continue;
            } else {
//                System.out.println(currentLineString);
                int nameLoc = currentLineString.indexOf("name=\"");
                int endNameLoc = currentLineString.indexOf("\"", nameLoc + 6);
//                System.out.println(nameLoc + " " + endNameLoc);
                String name = currentLineString.substring(nameLoc + 6, endNameLoc);


                int hexLoc = currentLineString.indexOf("id=\"");
                int endHexLoc = currentLineString.indexOf("\"", hexLoc + 4);
                String stringHex = currentLineString.substring(hexLoc + 7, endHexLoc);
//                System.out.println("Scanning: " + name + ", " + stringHex);


                ids.put(Integer.parseInt(stringHex, 16), name);

            }
        }
        try {
            in.close();
        } catch (IOException ioe) {
        }

        return ids;
    }

    private static int getNextFreeHex() {
        do {
            String hexS = formatHex(Integer.toString(hex, 16));
            if (idMap.containsKey(hex)) {
//                System.out.println(hexS + " was found, adding one");
                hex++;

            } else {
//                System.out.println("Free hex: " + Integer.toString(hex, 16));
                if (idMap.containsKey(hex)) {
                    System.out.println("SOMETHING IS FUCKED BRO");
                }
//                System.out.println(hexS + " is free");
                return hex;
                //return hex;
            }
        } while (true);
    }

    private static String formatHex(String h) {
        String hexString = h;
        if (hexString.length() == 7) {
            return "0x0" + hexString;
        } else if (hexString.length() == 10) {
            return h;
        } else {
            return "0x" + hexString;
        }
    }

    private static String getCurrentHex() {
        return formatHex(Integer.toString(hex, 16));
    }
}
