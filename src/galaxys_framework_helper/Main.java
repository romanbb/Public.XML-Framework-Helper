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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private static final String OUTPUT_NAME = "public.xml";
    private static final String OUTPUT_NAME_BACKUP = "public.xml.original";
    static int numberOfBatteryImages;
    static int numberOfChargingImages;
    static int lastAttr;
    static int lastId;
    static int lastStyle;
    static int lastString;
    static int lastDimen;
    static int lastColor;
    static int lastArray;
    static int lastDrawable;
    static int lastLayout;
    static int lastAnim;
    static int lastXml;
    static int lastRaw;
    static int lastBool;
    static int lastInteger;
    static int lastPlurals;
    static ArrayList<ExtraEntry> extras;
    public static final String[] types = {"attr", "id", "style", "string", "dimen", "color", "array", "drawable", "layout", "anim", "xml", "raw", "bool", "integer", "plurals"};

    /**
     * @param args the command lastDrawableInstance arguments
     * [0] - public.xml file
     * [1] - number of battery images to add
     * [2] - number of charging battery images to add
     */
    public static void main(String[] args) throws FileNotFoundException {

        String lastDrawableInstance = "";
        numberOfBatteryImages = Integer.parseInt(args[1]);
        numberOfChargingImages = Integer.parseInt(args[2]);
        boolean hasDrawable = false;

        FileOutputStream fos = null;
        PrintWriter out = null;

        //rename input to backup name
        if (args[0].equals(OUTPUT_NAME)) {
            System.out.println("Renaming " + OUTPUT_NAME + " to " + OUTPUT_NAME_BACKUP);
            File backupFile = new File(OUTPUT_NAME_BACKUP);

            //delete old one if it exists
            if (backupFile.exists()) {
                System.out.println("deleting old " + OUTPUT_NAME_BACKUP);
                backupFile.delete();
                backupFile = new File(OUTPUT_NAME_BACKUP);

            }


            //args[0] = OUTPUT_NAME_BACKUP;
            (new File(OUTPUT_NAME)).renameTo(new File(OUTPUT_NAME_BACKUP));
        }

        Scanner input = new Scanner(new File(OUTPUT_NAME_BACKUP));
        extras = getExtraEntries(new File(args[3]));
        idMap = getHexIDs(OUTPUT_NAME_BACKUP);

        try {
            fos = new FileOutputStream(new File("./" + OUTPUT_NAME));
            out = new PrintWriter(fos);
        } catch (FileNotFoundException ex) {
        }

        /*
         * loop through the line and handle everything!
         */
        String lastLine = "";
        while (input.hasNextLine()) {
            String currentLine = input.nextLine();


            for (int i = 1; i < types.length; i++) {

                //write custom entries
                if (currentLine.contains("type=\"" + types[i] + "\"") && lastLine.contains("type=\"" + types[i - 1] + "\"")) {
                    //handle attrs
                    hex = getHex(lastLine);

                    for (ExtraEntry extra : extras) {
                        if (extra.type.equals(types[i - 1])) {
                            //String lhex = getCurrentHex();
                            hex = getNextFreeHex();
                            idMap.put(hex, extra.name);
                            String xmlLine = "\t<public type=\"" + extra.type + "\" name=\"" + extra.name + "\" id=\"" + getCurrentHex() + "\" />";
                            out.println(xmlLine);
                        }
                    }
                    //break;
                }

            }

            //write batteries
            if (currentLine.contains("type=\"layout\"") && lastLine.contains("type=\"drawable\"")) {
                hex = getHex(lastLine);
                for (int j = 1; j <= numberOfBatteryImages; j++) {
                    String name = "stat_sys_battery_" + j;
                    boolean unique = !idMap.containsValue(name);

                    System.out.println("Got a new hex: " + getNextFreeHex());
                    if (unique) {
                        //name = "name=\"stat_sys_battery_" + j + "\"";
                        String xmlLine = "\t<public type=\"drawable\" name=\"" + name + "\" id=\"" + getCurrentHex() + "\" />";
                        out.println(xmlLine);
                        idMap.put(hex, name);

                    }
                }

                for (int j = 0; j < numberOfChargingImages; j++) {
                    String name = "stat_sys_battery_charge_anim" + j;
                    boolean unique = !idMap.containsValue(name);

                    System.out.println("Got a new hex: " + getNextFreeHex());
                    if (unique) {
                        //name = "name=\"stat_sys_battery_" + j + "\"";
                        String xmlLine = "\t<public type=\"drawable\" name=\"" + name + "\" id=\"" + getCurrentHex() + "\" />";
                        out.println(xmlLine);
                        idMap.put(hex, name);

                    }
                }
            }

            out.println(currentLine);
            lastLine = currentLine;

        }
        
        input.close();
        out.close();
        try {
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
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
            //String hexS = formatHex(Integer.toString(hex, 16));
            if (idMap.containsKey(hex)) {
//                System.out.println(hexS + " was found, adding one");
                hex++;
                System.out.println("idmap contains " + hex + ", incrementing");
            } else {
                System.out.println("Free hex: " + Integer.toString(hex, 16));
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

    private static int getHex(String line) {
        int hexLoc = line.indexOf("id=\"");
        int endHexLoc = line.indexOf("\"", hexLoc + 4);
        String stringHex = line.substring(hexLoc + 6, endHexLoc);

        System.out.println(stringHex + " getHex(): " + Integer.parseInt(stringHex, 16));
        return Integer.parseInt(stringHex, 16);
    }

    private static ArrayList<ExtraEntry> getExtraEntries(File f) throws FileNotFoundException {
        ArrayList l = new ArrayList<ExtraEntry>();
        if (f.exists()) {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                l.add(new ExtraEntry(s.nextLine()));
            }
            return l;
        }
        return null;

    }
}
