package org.example.core.audit;

public class RequestContext {

    private static final ThreadLocal<RequestContext> CONTEXT = new ThreadLocal<>();

    private String username;
    private long timestamp;

    public static void init(String username) {
        RequestContext context = new RequestContext();
        context.username = username;
        context.timestamp = System.currentTimeMillis();
        CONTEXT.set(context);
    }

    public static RequestContext get() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }

    public String getUsername() {
        return username;
    }

    public long getTimestamp() {
        return timestamp;
    }


}
