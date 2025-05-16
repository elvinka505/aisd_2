package aisd.lab03.hometask.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    public static int[] findingCommonElements(int[] nums1, int[] nums2) {
        //1) хэшмап чтобы считать частоты элементов в первом массиве
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        }
        List<Integer> resultList = new ArrayList<>();

        //2) проверим элементы второго массива
        for (int num : nums2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                resultList.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        //3) список - в массив
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {4, 3, 3, 0};
        int[] result = findingCommonElements(nums1, nums2);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}