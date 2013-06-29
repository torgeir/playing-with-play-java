package services;

public class VisitorService {

    private static final String NUMBER_OF_VISITORS = "visits";

    public static void increaseNumberOfVisits() {
        Redis.incr(NUMBER_OF_VISITORS);
    }

    public static Long numberOfVisits() {
        String numberOfVisitors = Redis.get(NUMBER_OF_VISITORS);
        return Long.valueOf(numberOfVisitors);
    }
}
