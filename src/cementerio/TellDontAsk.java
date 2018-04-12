package cementerio;

import java.util.*;

public class TellDontAsk {

    interface MapSetter {
        public void setMap(Map map);
    }

    interface MapGiver {
        public void giveMap(MapSetter acceptMap);
    }

    public static void main(String[] args) {
        HashMap<String, Integer> people = new HashMap<String, Integer>();

        people.put("bob", 2);
        people.put("susan", 5);

        DataStorage ds = new DataStorage();
        ds.setMap(people);

        AnotherClass ac = new AnotherClass();
        ds.giveMap(ac);

        ac.displayMap();
    }

    public static class DataStorage implements MapSetter, MapGiver {
        private Map map;

        @Override
        public void setMap(Map map) {
            this.map = map;            
        }

        @Override
        public void giveMap(MapSetter acceptMap) {
            acceptMap.setMap(map);

        }
    }

    public static class AnotherClass implements MapSetter {
        private Map map;

        public void displayMap() {
            System.out.println(map);

        }

        @Override
        public void setMap(Map map) {
            this.map = map;            
        }  
    }
}
