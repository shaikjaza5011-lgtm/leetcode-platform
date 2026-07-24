import java.util.*;

class UndergroundSystem {

    // Stores id -> (stationName, checkInTime)
    Map<Integer, Pair> checkInMap;

    // Stores route -> (totalTime, count)
    Map<String, int[]> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        Pair p = checkInMap.get(id);

        String route = p.station + "-" + stationName;
        int timeTaken = t - p.time;

        routeMap.putIfAbsent(route, new int[2]);

        routeMap.get(route)[0] += timeTaken; // total time
        routeMap.get(route)[1] += 1;         // count

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "-" + endStation;
        int[] data = routeMap.get(route);

        return (double) data[0] / data[1];
    }

    class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}
