package services;

import com.google.inject.Inject;

public class VisitorService {

    static final String NUMBER_OF_VISITORS = "visits";

    KeyValueStore keyValueStore;

    @Inject
    public VisitorService(KeyValueStore keyValueStore) {
        this.keyValueStore = keyValueStore;
    }

    public void increaseNumberOfVisits() {
        keyValueStore.incr(NUMBER_OF_VISITORS);
    }

    public Long numberOfVisits() {
        String numberOfVisitors = keyValueStore.get(NUMBER_OF_VISITORS);
        return Long.valueOf(numberOfVisitors);
    }
}
