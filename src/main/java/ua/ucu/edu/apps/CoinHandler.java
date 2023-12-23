package ua.ucu.edu.apps;

import java.util.Map;

public class CoinHandler implements Handler {

    private final int denomination;
    private final Handler nextHandler;

    public CoinHandler(int denomination, Handler nextHandler) {
        this.denomination = denomination;
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handler(int amount, Map<Integer, Integer> result) {
        if (amount >= denomination) {
            int count = amount / denomination;
            result.put(denomination, count);
            amount -= count * denomination;
        }
        if (amount > 0 && nextHandler != null) {
            return nextHandler.handler(amount, result);
        }
        return amount <= 0;
    }
}
