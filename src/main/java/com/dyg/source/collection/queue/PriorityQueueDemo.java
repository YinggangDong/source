package com.dyg.source.collection.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * PriorityQueueDemo 类是 优先级队列
 *
 * @author dongyinggang
 * @date 2021-01-06 16:51
 **/
public class PriorityQueueDemo {
    public static void main(String[] args) {
//        init();
        quickSort();
    }

    private static void init(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3, Comparator.reverseOrder());
        priorityQueue.offer(1);
        priorityQueue.offer(4);
        priorityQueue.offer(3);
        while(priorityQueue.peek()!=null){
            System.out.print(priorityQueue.poll());
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>(k);
        if(input.length<=k||k==0){
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,(o1,o2)->o2.compareTo(o1));
        for(int i=0;i<input.length;i++){
            if(maxHeap.size()!=k){
                maxHeap.offer(input[i]);
            }else if(maxHeap.peek()>input[i]){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        while(maxHeap.peek()!=null){
            res.add(maxHeap.poll());
        }
        return res;
    }

    private static void quickSort(){
        int[] arr = {1,2,5,8,0};
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quick(int[] arr,int left,int right){
        if(left<right){
            int m = partition(arr,left,right);
            quick(arr,left,m);
            quick(arr,m+1,right);
        }
    }

    private static int partition(int[] arr,int left,int right){
        int x = arr[left];
        while(left<right){
            //从右侧开始找到第一个小于基准元素的元素
            while(arr[right]>=x&&left <right){
                right--;
            }
            //把该元素赋值给当前左指针指向的位置
            arr[left] = arr[right];
            //从左侧开始找第一个大于基准元素的元素
            while(arr[left]<x&&left<right){
                left++;
            }
            //把该元素赋值给右指针指向的位置
            //如果是left<right不满足,此时right=left,互换无所谓
            arr[right]=arr[left];
        }
        //上述遍历完成后,就实现了基准元素左侧全不大于它，右侧全不小于它
        //此时,将基准元素设置给遍历重叠时的位置
        arr[left]=x;
        //返回此次的基准元素值
        return left;
    }
}
