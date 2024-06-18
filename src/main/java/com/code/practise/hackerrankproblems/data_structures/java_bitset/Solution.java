package com.code.practise.hackerrankproblems.data_structures.java_bitset;

import java.util.*;

public class Solution {

    public static void NoOfSetBits(int bitSetLength, BitSet s1, BitSet s2){
        System.out.println(s1.cardinality() + " " + s2.cardinality());
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int bitSetLength = s.nextInt();
        int NoOfOperations = s.nextInt();
        BitSet[] bitset = new BitSet[]{new BitSet(bitSetLength),new BitSet(bitSetLength)};

        while(NoOfOperations-- > 0){

            String operation = s.next();
            int bitset1= s.nextInt()-1;
            int index = s.nextInt();
            int bitset2 = index-1;

            if(operation.equals("SET")){

                bitset[bitset1].set(index);

                Solution.NoOfSetBits(bitSetLength, bitset[0], bitset[1]);

            } else if(operation.equals("FLIP")){

                bitset[bitset1].flip(index);

                Solution.NoOfSetBits(bitSetLength, bitset[0], bitset[1]);

            } else if(operation.equals("AND")){

                bitset[bitset1].and(bitset[bitset2]);

                Solution.NoOfSetBits(bitSetLength, bitset[0], bitset[1]);

            } else if(operation.equals("OR")){

                bitset[bitset1].or(bitset[bitset2]);

                Solution.NoOfSetBits(bitSetLength, bitset[0], bitset[1]);

            } else if(operation.equals("XOR")){

                bitset[bitset1].xor(bitset[bitset2]);

                Solution.NoOfSetBits(bitSetLength, bitset[0], bitset[1]);

            }
        }
        s.close();
    }

}


//input
//
//5 4
//AND 1 2
//SET 1 4
//FLIP 2 2
//OR 2 1