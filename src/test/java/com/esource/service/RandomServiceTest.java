package com.esource.service;

import com.esource.model.RandomModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class RandomServiceTest {

    @Test
     void testMissingNumbers() {
        int[] array1 = {1,5,11,12,19,21,25,31,34,39,40,41,45,49,50};
        int[] array2 = {2,6,13,18,20,24,30,32,35,36,42,44,46,47,48};
        int[] array3 = {3,8,10,14,16,22,23,26,27,28,29,33,37,38,43};
        RandomService randomService = new RandomService();
        RandomModel randomModel = new RandomModel();
        List<Integer> missingList = new ArrayList<>(
                List.of(0,4,7,9,15,17));
        randomModel.setArray1(array1);
        randomModel.setArray2(array2);
        randomModel.setArray3(array3);
        List<Integer> accMissingList=randomService.getMissingNumbers(randomModel);
        assertEquals(missingList, accMissingList);
    }

    @Test
    void testGenerateRandomModel() {
        RandomService randomService = new RandomService();
        RandomModel randomModel = randomService.generateRandomModel();
        assertEquals(15,randomModel.getArray1().length);
        assertEquals(15,randomModel.getArray2().length);
        assertEquals(15,randomModel.getArray3().length);
    }
}
