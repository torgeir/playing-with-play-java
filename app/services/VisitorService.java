package services;

import com.google.inject.Inject;

public class VisitorService {

    static final String NUMBER_OF_VISITORS = "visits";

    Redis redis;

    @Inject
    public VisitorService(Redis redis) {
        this.redis = redis;
    }

    public void increaseNumberOfVisits() {
        redis.incr(NUMBER_OF_VISITORS);
    }

    public Long numberOfVisits() {
        String numberOfVisitors = redis.get(NUMBER_OF_VISITORS);
        return Long.valueOf(numberOfVisitors);
    }
}
