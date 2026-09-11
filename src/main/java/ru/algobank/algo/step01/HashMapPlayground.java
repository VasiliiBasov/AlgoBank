package ru.algobank.algo.step01;

import java.util.HashMap;

public class HashMapPlayground {

    private HashMap<String, Long> balance =  new HashMap<>();

    public static void main(String[] args) {
        HashMapPlayground mp = new HashMapPlayground();
        mp.seedBalance();
        mp.searchBalanceOfClient("alice");
        mp.searchBalanceOfClient("bob");
        mp.updateBalance("alice", 200_000_00L);
        mp.printAllClientsWithBalance();
        mp.deleteClient("eve");
    }

    public void seedBalance() {
        balance.put("alice", 150_000_00L);
        balance.put("bob", 45_000_00L);
        balance.put("carol", 1_200_000_00L);
        balance.put("dave", 0L);
        balance.put("eve", 999_999_99L);
    }

    public void searchBalanceOfClient(String clientName) {
        Long bal = balance.get(clientName);
        System.out.printf("%s: %.2f RUB%n", clientName, bal/100.0);
    }

    public void updateBalance(String clientName, Long newBalance) {
        balance.put(clientName, newBalance);
        Long bal = balance.get(clientName);
        System.out.printf("%s: %.2f RUB%n", clientName, bal/100.0);
    }

    public void printAllClientsWithBalance() {
        balance.forEach((name, bal) -> System.out.printf("%s: %.2f RUB%n", name, bal/100.0));
    }

    public void deleteClient(String clientName) {
        System.out.println(balance.size() + " - количество клиентов до удаления");
        balance.remove(clientName);
        System.out.println(balance.size() + " - количество клиентов после удаления");
    }
}
