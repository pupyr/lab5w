package Vehicle.command;

import Vehicle.*;

import java.util.*;

public class sort {

    static LinkedHashMap<Long, Vehicle> map=new LinkedHashMap<>();
    static Long lll;

    public static void sorting(boolean b){
        if(!Root.getRoot().isEmpty()) {
            ArrayList<Long> arrayList = new ArrayList<>(Root.getRoot().keySet());
            Collections.sort(arrayList);
            for (Long l : arrayList) {
                for (Long ll : Root.getRoot().keySet()) {
                    if (l.equals(ll)) {
                        lll = ll;
                        break;
                    }
                }
                map.put(l, Root.getRoot().get(lll));
                if (!b) {
                    System.out.println("\t"+l+":"+map.get(l).write(0));
                }
            }
            if(b) {
                Root.setRoot(map);
                IO.save();
            }
        }
    }
}
