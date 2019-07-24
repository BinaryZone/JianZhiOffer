package com.ceshi.test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ThreeSolution {
    // 输入3*3矩阵，元素为0-8
    // 分别用BFS、DFS和启发式算法单步移动
    // 输出结果矩阵：0在中间，1-8按顺序环绕
    // 输出步数

    public int BFS(SSState state, HashSet<String> finished_ID) {
        // 广度优先查找
        Queue<SSState> state_queue = new LinkedList<SSState>();
        HashSet<String> searched_ID = new HashSet<String>();
        int step = 0;
        System.out.println("深度优先遍历\n");
        state_queue.add(state);
        while(!state_queue.isEmpty()) {
            SSState cur_state = state_queue.poll();
            if (searched_ID.contains(cur_state.ID)) continue;
            System.out.println(cur_state);
            if (finished_ID.contains(cur_state.ID)) break;
            else {
                step++;
                searched_ID.add(cur_state.ID);
                SSState next = cur_state.upForward();
                if (next != null) state_queue.add(next);
                next = cur_state.downForward();
                if (next != null) state_queue.add(next);
                next = cur_state.leftForward();
                if (next != null) state_queue.add(next);
                next = cur_state.rightForward();
                if (next != null) state_queue.add(next);
            }
        }
        return step;
    }

    public int DFS(SSState state, HashSet<String> finished_ID) {
        // 深度优先查找
        Stack<SSState> state_stack = new Stack<SSState>();
        HashSet<String> searched_ID = new HashSet<String>();
        int step = 0;
        System.out.println("深度优先遍历\n");
        state_stack.add(state);
        while(!state_stack.isEmpty()) {
            SSState cur_state = state_stack.pop();
            if (searched_ID.contains(cur_state.ID)) continue;
            System.out.println(cur_state);
            if (finished_ID.contains(cur_state.ID)) break;
            else {
                step++;
                searched_ID.add(cur_state.ID);
                SSState next = cur_state.rightForward();
                if (next != null) state_stack.add(next);
                next = cur_state.leftForward();
                if (next != null) state_stack.add(next);
                next = cur_state.downForward();
                if (next != null) state_stack.add(next);
                next = cur_state.upForward();
                if (next != null) state_stack.add(next);
            }
        }
        return step;
    }

    public int Heuristic(SSState state, HashSet<String> finished_ID) {
        // 启发式算法
        PriorityQueue<SSState> state_queue = new PriorityQueue<SSState>(10,new MyComparator());
        HashSet<String> searched_ID = new HashSet<String>();
        int step = 0;
        state.setStepAndFinish(step, finished_ID);
        state_queue.add(state);
        while (!state_queue.isEmpty()) {
            SSState cur_state = state_queue.poll();
            if (searched_ID.contains(cur_state.ID)) continue;
            System.out.println(cur_state);
            if (finished_ID.contains(cur_state.ID)) break;
            else {
                step++;
                searched_ID.add(cur_state.ID);
                SSState next = cur_state.upForward();
                if (next != null) {
                    next.setStepAndFinish(step, finished_ID);
                    state_queue.add(next);
                }
                next = cur_state.downForward();
                if (next != null) {
                    next.setStepAndFinish(step, finished_ID);
                    state_queue.add(next);
                }
                next = cur_state.leftForward();
                if (next != null) {
                    next.setStepAndFinish(step, finished_ID);
                    state_queue.add(next);
                }
                next = cur_state.rightForward();
                if (next != null) {
                    next.setStepAndFinish(step, finished_ID);
                    state_queue.add(next);
                }
            }
        }
        return step;
    }
}

class MyComparator implements Comparator<SSState> {
    public int compare(SSState state1, SSState state2) {
        int v1 =  state1.getF();
        int v2 =  state2.getF();
        if (v1 > v2) {
            return 1;
        }
        else if (v1 == v2) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
