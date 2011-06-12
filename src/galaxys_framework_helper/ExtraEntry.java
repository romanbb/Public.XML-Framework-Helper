/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package galaxys_framework_helper;

/**
 *
 * @author roman
 */
public class ExtraEntry {
        String type;
        String name;

        public ExtraEntry(String line) {
            String[] split = line.split("\\s");
            type = split[0];
            name = split[1];
        }

    }
