package zuochengyun.chapter01.practice07;

import java.util.LinkedList;

public class MaxWindow {
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // 判断新来的数据和队列尾端数据的大小关系
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            // 新数据入队
            qmax.addLast(arr[i]);
            // 队列头数据过期出队
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            // 到窗口最后一个值的时候记录窗口数据
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
