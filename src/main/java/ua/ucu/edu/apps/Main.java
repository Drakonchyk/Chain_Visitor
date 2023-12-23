package ua.ucu.edu.apps;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        int amount = 170;
        Map<Integer, Integer> result = atm.withdraw(amount);

        if (result == null || result.isEmpty()) {
            ErrorHandler.ErrorMsg("Not enough money or not possible to provide the needed amount.");
        } else {
            System.out.println("Withdrawal details:");
            for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
                System.out.println(entry.getKey() + " x " + entry.getValue());
            }
        }
    }
}
