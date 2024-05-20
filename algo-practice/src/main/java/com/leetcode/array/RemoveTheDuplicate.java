package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class RemoveTheDuplicate {
    public static List<Integer> findDuplicate(int nums[]){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            System.out.println(index);
            if(nums[index]<0){
                list.add(Math.abs(nums[i]));
            }else{
                nums[index]=-1*nums[i];
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int arr[]={2,4,5,7,2,4,3};
        System.out.println(findDuplicate(arr));
    }
}
