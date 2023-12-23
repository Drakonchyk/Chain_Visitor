package ua.ucu.edu.apps;

import java.util.Map;

public interface Handler {
    boolean handler(int amount, Map<Integer, Integer> result);
}
