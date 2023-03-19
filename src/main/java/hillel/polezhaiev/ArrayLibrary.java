package hillel.polezhaiev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLibrary {
    public int[] getArrAfterLast4(int [] arr){
        if(arr == null || arr.length == 0){
            return null;
        }

        if(!Arrays.stream(arr).anyMatch(n -> n == 4)){
            throw new RuntimeException();
        }

        List<Integer> list = new ArrayList<>();
        Arrays.stream(arr).forEach(e -> list.add(e));

        int i = list.lastIndexOf(4);

        List<Integer> result = list.subList(i + 1, arr.length);
        int[] resultArr = new int[result.size()];

        for (int j = 0; j < resultArr.length; j++) {
            resultArr[j] = result.get(j);
        }

        return resultArr;
    }

    public boolean checkFor_1_and_4(int [] arr){
        if (arr.length == 0 || arr == null){
            return false;
        }

        return Arrays.stream(arr).anyMatch(n -> n == 1) && Arrays.stream(arr).anyMatch(n -> n == 4);
    }
}
