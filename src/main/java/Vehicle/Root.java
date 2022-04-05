package Vehicle;

import java.util.LinkedHashMap;
import java.util.Date;

public class Root
{
    private static Date date;
    private static LinkedHashMap<Long, Vehicle> root = new LinkedHashMap<>();

    public static Date getDate() {
        return Root.date;
    }

    public static void setDate( Date date) {
        Root.date = date;
    }

    public static LinkedHashMap<Long, Vehicle> getRoot() {
        return Root.root;
    }

    public static void setRoot( LinkedHashMap<Long, Vehicle> root) {
        Root.root = root;
    }

    public static void add( Long key,  Vehicle vehicle) {
        Root.root.put(key, vehicle);
    }

    public static String write( int in) {
        StringBuilder s = new StringBuilder();
        int i = 0;
        for ( Long ss : Root.root.keySet()) {
            ++i;
            if (in != 0) {
                s.append("\t <vehicle key=\"").append(ss).append("\"");
            }
            else {
                s.append("\t").append(ss).append(":");
            }
            s.append(Root.root.get(ss).write(in));
            if (i != Root.root.size()) {
                s.append("\n");
            }
        }
        return s.toString();
    }

}