package com.tonio.packages;

public class Series {
        public static int nSum(int n){
            if(n < 0)return -1;

            int result = 0;
            for(int i = 0; i <= n; i++){
                result += i;
            }
            return result;
        }

        public static int factorial(int n){
            if(n < 0) return -1;

            int res = 1;
            for (int i = 1; i <= n; i++){
                res *= i;
            }
            return res;
        }

        public static int fibonacci(int n){
            if(n < 0) return -1;
            if(n == 0) return 0;
            if(n == 1) return 1;
            return fibonacci(n-1) + fibonacci(n - 2);
        }

}
