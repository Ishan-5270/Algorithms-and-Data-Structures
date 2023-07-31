    package Hashing;

    import java.util.HashMap;

    public class PrintItenary {
        public static String getStart(HashMap<String, String> tickets){
            HashMap<String, String> reverseMap = new HashMap<>();
            for (String keys : tickets.keySet()) {
                reverseMap.put(tickets.get(keys) , keys);
            }

            for(String keys : tickets.keySet()){
                if (!reverseMap.containsKey(keys)){
                    return keys; 
                }
        }
        return null;
    }

        public static void main(String[] args) {
            HashMap<String, String> tickets = new HashMap<>();
            tickets.put("Chennai", "Bengaluru");
            tickets.put("Mumbai", "Delhi");
            tickets.put("Goa", "Chennai");
            tickets.put("Delhi", "Goa");

            String start = getStart(tickets);

            while(tickets.containsKey(start)){
                System.out.println(start);
                start = tickets.get(start);
            }
            System.out.println(start);
        }
    }
        
