package com.code.practise.hackerrankproblems.algorithms.greedy.jim_and_ther_orders;

import java.util.*;

class Solution {

    /**
     * This is a solution which uses Greedy Method.
     *
     * @param orders -> the orders that jim gets
     * @return
     */
    public static List<Integer> jimOrders(List<List<Integer>> orders) {
        // Write your code here
        Map<Integer, Integer> customerVsServeTimeMap = new HashMap<>();
        List<Integer> serveOrder = new ArrayList<>();

        // Here the approach I followed is creating a hashmap with customer number as key and serve time as value.
        for(int i=1; i<=orders.size(); i++){
            List<Integer> order = orders.get(i-1);
            int serveTime = order.get(0) + order.get(1);
            customerVsServeTimeMap.put(i, serveTime);
        }

        // then sort the map by value
        customerVsServeTimeMap = sortByValues(customerVsServeTimeMap);

        // Then added the key of that map to a list and returned the list
        customerVsServeTimeMap.forEach((k, v) -> serveOrder.add(k));

        return serveOrder;

    }

    public static Map<Integer, Integer> sortByValues(Map<Integer, Integer> map) {
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        return sortedMap;
    }

    public static void main(String[] args){

        List<List<Integer>> orders = new ArrayList<>();
        orders.add(Arrays.asList(8, 1)); // customer #1
        orders.add(Arrays.asList(4, 2)); // customer #2
        orders.add(Arrays.asList(5, 6)); // customer #3
        orders.add(Arrays.asList(3, 1)); // customer #4
        orders.add(Arrays.asList(4, 3)); // customer #5

        List<Integer> servingOrderForCustomers = jimOrders(orders);
        servingOrderForCustomers.forEach(x->System.out.print(x+" "));

    }

}
