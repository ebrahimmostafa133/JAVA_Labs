package Utilities;

import java.util.concurrent.atomic.AtomicInteger;

// Requirement 4: Unique ID Management
public class IDGenerator {
    private static final AtomicInteger ITEM_ID_COUNTER = new AtomicInteger(100);
    private static final AtomicInteger CLIENT_ID_COUNTER = new AtomicInteger(1);

    public static int getNextItemId() {
        return ITEM_ID_COUNTER.incrementAndGet();
    }
    
    public static int getNextClientId() {
        return CLIENT_ID_COUNTER.incrementAndGet();
    }
}