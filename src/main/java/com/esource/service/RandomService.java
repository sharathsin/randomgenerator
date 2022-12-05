package com.esource.service;

import com.esource.model.RandomModel;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomService {
    public RandomModel generateRandomModel() {
        RandomModel randomModel = new RandomModel();
        final Random random = new Random();
        randomModel.setArray1(random.ints(15, 0, 50).toArray());
        randomModel.setArray2(random.ints(15, 0, 50).toArray());
        randomModel.setArray3(random.ints(15, 0, 50).toArray());

        return randomModel;
    }

    public List<Integer> getMissingNumbers(RandomModel randomModel) {
        Arrays.sort(randomModel.getArray1());
        Arrays.sort(randomModel.getArray2());
        Arrays.sort(randomModel.getArray3());
        ArrayList<Integer> missingNumbers = new ArrayList<>();
        Integer counter1 = 0;
        Integer counter2 = 0;
        Integer counter3 = 0;
        for (int i = 0; i <= 50; i++) {
            boolean found;
            Pair<Integer, Boolean> result = checkNumberExists(randomModel.getArray1(), counter1, false, i);
            counter1 = result.getLeft();
            found = result.getRight();
            result = checkNumberExists(randomModel.getArray2(), counter2, found, i);
            counter2 = result.getLeft();
            found = result.getRight();

            result = checkNumberExists(randomModel.getArray3(), counter3, found, i);
            counter3 = result.getLeft();
            found = result.getRight();

            if (!found) {
                missingNumbers.add(i);
            }
        }

        return missingNumbers;
    }
    public int getLargestPrimeNumber(Integer[] array) {
        Arrays.sort(array);
        for(int i= array.length-1; i>=0;i--) {
            if(isPrime(array[i])) {
                return array[i];
            }
        }
        return 0;
    }
    private   boolean isPrime(int num)
    {
        if(num<=1)
        {
            return false;
        }
        for(int i=2;i<=num/2;i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;
    }
    private Pair<Integer, Boolean> checkNumberExists(int[] array, int counter, boolean found, int index) {
        if (array[counter] != index) {
            if (array[counter] < index) {
                if (counter < 14) {
                    counter++;
                }
            }
        } else {
            if (counter < 14) {
                counter++;
            }
            found = true;
        }

        return new ImmutablePair<>(counter, found);
    }

}
