package com.ceshi.test;

import java.util.HashSet;
import java.util.Iterator;

public class SSState {
    // ״̬�ռ�
    int zeroX;  // 0�������
    int zeroY;  // 0��������
    int[][] state_matrix;  // ����
    String ID = "";  // Ψһ��ʶ��
    int step;  // ����
    HashSet<String> finished_ID;  // Ŀ��ID
    int f;  // ����ʽ�㷨Ŀ�꺯��ֵ

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
        // ��ȡID��������ǰ������
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
        // �ڻ�ȡ��һ���ƶ��ľ���ʱ�����Ƶ�ǰ����
        int[][] matrix = new int[3][3];
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                matrix[m][n] = state_matrix[m][n];
            }
        }
        return matrix;
    }

    public SSState upForward() {
        // 0������
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
        // 0������
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
        // 0������
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
        // 0������
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
        System.out.println("ԭ����");
        SSState state = new SSState(start_matrix, 2, 1);
        System.out.println(state);
        System.out.println("��������");
        System.out.println(state.upForward());
        System.out.println(state.upForward().upForward());
        System.out.println(state.upForward().upForward().leftForward());
//      System.out.println("��������");
//      System.out.println(state.down.ID);
//      System.out.println("��������");
//      System.out.println(state.left.ID);
//      System.out.println("��������");
//      System.out.println(state.right.ID);
    }
}
