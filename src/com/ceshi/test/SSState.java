package com.ceshi.test;

import java.util.HashSet;
import java.util.Iterator;

public class SSState {
    // 状态空间
    int zeroX;  // 0点横坐标
    int zeroY;  // 0点纵坐标
    int[][] state_matrix;  // 矩阵
    String ID = "";  // 唯一标识符
    int step;  // 步长
    HashSet<String> finished_ID;  // 目标ID
    int f;  // 启发式算法目标函数值

    public SSState() {
        zeroX = 0;
        zeroY = 0;
        state_matrix = null;
        ID = "";
    }

    public SSState(int[][] matrix, int x, int y) {
        zeroX = x;
        zeroY = y;
        state_matrix = matrix;
        ID = getID(matrix);
    }

    public void setStepAndFinish(int s, HashSet<String> finished) {
        step = s;
        finished_ID = finished;
    }

    public int getF() {
        Iterator<String> iter = finished_ID.iterator();
        int f = 8;
        while (iter.hasNext()) {
            int diff = 0;
            String next = iter.next();
            for (int i = 0; i < 8; i++) {
                if (next.charAt(i) != ID.charAt(i)) diff++;
            }
            if (f >= diff) f = diff;
        }
        f = f + step;
        return f;
    }

    private String getID(int[][] matrix) {
        // 获取ID，即矩阵当前的样子
        String tempID = "";
        tempID += matrix[0][0];
        tempID += matrix[0][1];
        tempID += matrix[0][2];
        tempID += matrix[1][2];
        tempID += matrix[2][2];
        tempID += matrix[2][1];
        tempID += matrix[2][0];
        tempID += matrix[1][0];
        return tempID;
    }

    private int[][] copyOfMatrix() {
        // 在获取下一步移动的矩阵时，复制当前矩阵
        int[][] matrix = new int[3][3];
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                matrix[m][n] = state_matrix[m][n];
            }
        }
        return matrix;
    }

    public SSState upForward() {
        // 0点上移
//      SSState next = new SSState();
        if (state_matrix != null && zeroX != 0) {
            int x = zeroX - 1;
            int y = zeroY;
            int[][] matrix = copyOfMatrix();
            matrix[x][y] = state_matrix[zeroX][zeroY];
            matrix[x + 1][y] = state_matrix[zeroX - 1][zeroY];
            SSState next = new SSState(matrix, x, y);
//          next.zeroX = x;
//          next.zeroY = y;
//          next.state_matrix = matrix;
//          next.ID = getID(matrix);
            return next;
        }
        else return null;
    }

    public SSState downForward() {
        // 0点下移
//      SSState next = new SSState();
        if (state_matrix != null && zeroX != 2) {
            int x = zeroX + 1;
            int y = zeroY;
            int[][] matrix = copyOfMatrix();
            matrix[x][y] = state_matrix[zeroX][zeroY];
            matrix[x - 1][y] = state_matrix[zeroX + 1][zeroY];
            SSState next = new SSState(matrix, x, y);
//          next.zeroX = x;
//          next.zeroY = y;
//          next.state_matrix = matrix;
//          next.ID = getID(matrix);
            return next;
        }
        else return null;
    }

    public SSState leftForward() {
        // 0点左移
//      SSState next = new SSState();
        if (state_matrix != null && zeroY != 0) {
            int x = zeroX;
            int y = zeroY - 1;
            int[][] matrix = copyOfMatrix();
            matrix[x][y] = state_matrix[zeroX][zeroY];
            matrix[x][y + 1] = state_matrix[zeroX][zeroY - 1];
            SSState next = new SSState(matrix, x, y);
//          next.zeroX = x;
//          next.zeroY = y;
//          next.state_matrix = matrix;
//          next.ID = getID(matrix);
            return next;
        }
        else return null;
    }

    public SSState rightForward() {
        // 0点右移
//      SSState next = new SSState();
        if (state_matrix != null && zeroY != 2) {
            int x = zeroX;
            int y = zeroY + 1;
            int[][] matrix = copyOfMatrix();
            matrix[x][y] = state_matrix[zeroX][zeroY];
            matrix[x][y - 1] = state_matrix[zeroX][zeroY + 1];
            SSState next = new SSState(matrix, x, y);
//          next.zeroX = x;
//          next.zeroY = y;
//          next.state_matrix = matrix;
//          next.ID = getID(next.state_matrix);
            return next;
        }
        else return null;
    }

    public String toString() {
        String rs = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rs += state_matrix[i][j];
                rs += "  ";
            }
            rs += "\n";
        }
        rs += "-------\n";
        return rs;
    }

    public static void main(String[] args) {
        int[][]  start_matrix = {
                {2, 8, 3},
                {1, 6, 4},
                {7, 0, 5},
        };
        System.out.println("原矩阵");
        SSState state = new SSState(start_matrix, 2, 1);
        System.out.println(state);
        System.out.println("测试上移");
        System.out.println(state.upForward());
        System.out.println(state.upForward().upForward());
        System.out.println(state.upForward().upForward().leftForward());
//      System.out.println("测试下移");
//      System.out.println(state.down.ID);
//      System.out.println("测试左移");
//      System.out.println(state.left.ID);
//      System.out.println("测试右移");
//      System.out.println(state.right.ID);
    }
}
