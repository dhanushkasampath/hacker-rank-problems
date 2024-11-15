package com.code.practise.hackerrankproblems.data_structures.graph.adjacency_list_representation;

import java.util.List;

public class Demo {

    //This method will add edge between two vertices
    public static void addEdge(List<List<Integer>> adjacencyList, int i, int j){
        adjacencyList.get(i).add(j);
        adjacencyList.get(j).add(i);
    }

    public static void displayAdjacencyList(List<List<Integer>> adjacencyList){
        for(int i=0; i < adjacencyList.size(); i++){
            System.out.print(i + ": ");
            for(int j : adjacencyList.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
