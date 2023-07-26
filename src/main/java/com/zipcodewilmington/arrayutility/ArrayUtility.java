package com.zipcodewilmington.arrayutility;



import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class  ArrayUtility<T> {

    private T[] array;

    public ArrayUtility(T[] inputArray) {
        array = inputArray;
    }

    // assign parameter array to filed array to use/access throughout this class
    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        // make a new array to merge two arrays together
        T[] newArr = (T[]) Array.newInstance(valueToEvaluate.getClass(), array.length + arrayToMerge.length);
        int mergeCtr = 0;

        //merge!!!
        for (int i = 0; i < array.length ; i++) {
            newArr[i] = array[i];
        }
        for (int i = array.length; i < arrayToMerge.length + array.length; i++) {
            newArr[i] = arrayToMerge[mergeCtr];
            mergeCtr++;
        }
        // count valueToEvaluate
       this.array = newArr;
        int dupe = getNumberOfOccurrences(valueToEvaluate);

        //
        return dupe ;

    }







    public T getMostCommonFromMerge(T[] arrayToMerge) {
        return null;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int ctr = 0;                                 // keeps track of how many occurences
        for (int i = 0; i < array.length; i++) {    // go through the array
            if (array[i] == valueToEvaluate) {       // counter will go up if valueToEvaluate matches
                ctr++;
            }
        }
        return ctr;
    }

    public T[] removeValue(T valueToRemove) {
        int sizeMod = getNumberOfOccurrences(valueToRemove);
        T[] newArr = (T[]) Array.newInstance(valueToRemove.getClass(), array.length - sizeMod);
        int newArrIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                newArr[newArrIdx] = array[i];
            newArrIdx++;
            }

        }
        return newArr;
    }
}
