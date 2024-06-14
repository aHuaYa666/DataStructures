package com.atguigu.recursion;

public class Maze {
    public static void main(String[] args) {
        int[][] map = new int[8][7];

        // top row and bottom row are all 1
        for(int i = 0; i < 7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // left and right column are all 1
        for(int i = 0; i < 8; i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // set stocks
        map[3][1] = 1;
        map[3][2] = 1;

        //print out the map
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 7; j ++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        //
        // setWay(map, 1 , 1);
        setWay2(map, 1 , 1);

        System.out.println("after the ball passing through");
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 7; j ++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    //use recursion to find paths for the ball
    //Instruction:
    //1. map stands for the map of the ball
    //2. i,j stands for the starting point (1, 1)
    //3. if the ball can arrive the final stop (6,5), it means it got the right way
    //4. Rules: if map[i][j] = 0: ball not passes through it yet; map[i][j] = 3: ball passes through it already, but can't arrive the final stop
    //          map[i][j] = 1: stack not for passing; map[i][j] = 2: passable way
    //5. strategy: down-right-up-left, if it didn't work, backtracking

    /**
     *
     * @param map stands for map of the ball
     * @param i and j stand for the starting point
     * @return if the ball arrive the final stop, return true, or return false
     */
    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][5] ==2){
            return true;
        } else {
            if(map[i][j] == 0){ //ball not passes through it yet
                // following the strategy down-right-up-left
               map[i][j] = 2;
                if(setWay(map, i +1, j)){
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;

                } else{
                    map[i][j] = 3;
                    return false;
                }
            }
            else { // if map[i][j] != 0, it can be 1, 2, 3
                return false;
            }
        }

    }

    public static boolean setWay2(int[][] map, int i, int j){
        if(map[6][5] ==2){
            return true;
        } else {
            if(map[i][j] == 0){ //ball not passes through it yet
                // following the strategy up-right-down-left
                map[i][j] = 2;
                if(setWay2(map, i - 1, j)){
                    return true;
                } else if (setWay2(map, i, j + 1)) {
                    return true;
                } else if (setWay2(map, i + 1, j)) {
                    return true;
                } else if (setWay2(map, i, j - 1)) {
                    return true;

                } else{
                    map[i][j] = 3;
                    return false;
                }
            }
            else { // if map[i][j] != 0, it can be 1, 2, 3
                return false;
            }
        }

    }
}
