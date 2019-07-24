package com.ceshi.test;

import java.util.HashSet;

public class StartUp {
    public HashSet<String> getFinishedID() {
        // �ж��Ƿ񵽴�Ŀ��״̬���ﵽ����������
        // �ﵽ������true
        HashSet<String> finished_ID = new HashSet<String>();
        String temp_string = "1234567812345678";
        String reverse = "8765432187654321";
        for (int i = 0; i < 8; i++) {
            finished_ID.add(temp_string.substring(i, i + 8));
            finished_ID.add(reverse.substring(i, i + 8));
        }
        return finished_ID;
    }

    public static void main(String[] args) {
        int[][]  start_matrix = {
                {2, 8, 3},
                {1, 6, 4},
                {7, 0, 5},
        };
        SSState state = new SSState(start_matrix, 2, 1);
        HashSet<String> finished_ID = new StartUp().getFinishedID();
        ThreeSolution three = new ThreeSolution();
        System.out.println("������ȱ���������" + three.BFS(state, finished_ID));
//      System.out.println("������ȱ���������" + three.DFS(state, finished_ID));
//      System.out.println("����ʽ����������" + three.Heuristic(state, finished_ID));
    }
}
