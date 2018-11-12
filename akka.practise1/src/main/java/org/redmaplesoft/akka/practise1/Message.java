package org.redmaplesoft.akka.practise1;

import java.util.List;
import java.util.Map;

public final class Message {
    private final int visitCount;

    private final List<String>  usernames;

    private final Map<String, String> citys;

    public Message(int visitCount, List<String> usernames, Map<String, String> citys) {
        this.visitCount = visitCount;
        this.usernames = usernames;
        this.citys = citys;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public Map<String, String> getCitys() {
        return citys;
    }
}
