package com.code.practise.hackerrankproblems.common.java.lambda_expressions;

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Write your code here
    // This is a method which return a lambda expression
    PerformOperation isOdd(){
        return (n)->n%2 == 0 ? false:true;
    }

    PerformOperation isPrime(){
        return (n)->{
            if (n <= 1) return false;

            if (n == 2 || n == 3) return true;

            if (n % 2 == 0 || n % 3 == 0) return false;

            for (int i = 5; i <= Math.sqrt(n); i = i + 6){
                if (n % i == 0 || n % (i + 2) == 0) return false;
            }
            return true;
        };
    }

    PerformOperation isPalindrome(){
        return (n)->{
            String str=String.valueOf(n);
            int len = str.length();
            for(int i = 0; i < len / 2; i++)
            {
                if (str.charAt(i) != str.charAt(len - i - 1))
                    return false;
            }
            return true;
        };
    }

}