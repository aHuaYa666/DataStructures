package com.atguigu.recursion;

public class Queen8 {
    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {

        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("We got %d methods in total", count);
    }

    //a method to put queen n
    private void check(int n){
        if(n == max){ // n = 8
            print();
            return;
        }
        for(int i = 0; i < max; i ++){
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }

    }

    //check if the position is ok or not for the queen we are about to set
    private boolean judge(int n){
        for(int i = 0; i < n; i ++ ){
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }
    //method printing the position of all queen
    private void print(){
        count++;
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
