package ua.ucu.edu.apps;

import java.util.HashMap;
import java.util.Map;

public class ATM {
    private final Handler handlerChain;

    public ATM() {
        handlerChain = new CoinHandler(100, new CoinHandler(50, new CoinHandler(20, new CoinHandler(10, null))));
    }

    public Map<Integer, Integer> withdraw(int amount) {
        Map<Integer, Integer> result = new HashMap<>();
        boolean complete = false;
        if (amount > 0) {
            complete = handlerChain.handler(amount, result);
        }
        if(!complete)
            return null;
        return result;
    }
}
