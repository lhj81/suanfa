package edu.lihj;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * @Author: lihj <lhjbpqbfq@163.com>
 * @Date: 2020-05-12 20:57
 */
public class 两数之和 {

    int[] result = new int[2];

    //方式一：暴力方法
    public int[] twoSum(int[] nums, int target) {
        //todo 获取比目标值小的数组值
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    //方式二：两遍方法
    public int[] twoSum2(int[] nums, int target) {
        //todo 获取比目标值小的数组值
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            if (map.containsKey(complement) && map.get(complement) != j) {
                return new int[]{j, map.get(complement)};
            }
        }

        return result;
    }

    //方式三：一遍方法
    public int[] twoSum3(int[] nums, int target) {
        //todo 获取比目标值小的数组值
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
        for (int z = 0; z < nums.length; z++) {
            int complement = target - nums[z];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), z};
            }
            map.put(nums[z], z);
        }
        throw new IllegalArgumentException("无解");
    }





    public static void main(String[] args) {
        int[] nums = {-2, -7, -11, -15};
        int target = -9;
        两数之和 a = new 两数之和();
        int[] returnVal = a.twoSum3(nums, target);
        System.out.println("[" + returnVal[0] + "," + returnVal[1] + "]");

    }
}