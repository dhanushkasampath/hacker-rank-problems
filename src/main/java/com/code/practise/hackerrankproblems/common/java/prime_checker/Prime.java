package com.code.practise.hackerrankproblems.common.java.prime_checker;

class Prime{
    public void checkPrime(int... nums){
        for(int num : nums){
            if(isPrime(num)){
                System.out.print(num + " ");
            }
        }
        // this is to go to a new line
        System.out.println();
    }

    private boolean isPrime(int num){
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(num); i = i + 6){
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}