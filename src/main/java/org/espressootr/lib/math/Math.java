package org.espressootr.lib.math;

import java.util.List;

public final class Math {

    public static int getMaxValue(int[] source) {
	int maxValue = Integer.MIN_VALUE;
	int size = source.length;
	
	for (int i = 0; i < size; i++) {

	    if (maxValue < source[i])
		maxValue = source[i];

	}

	return maxValue;

    }

    public static int getMaxValue(List<Integer> source) {
	int maxValue = Integer.MIN_VALUE;
	int size = source.size();
        for (int i = 0; i < size; i++) {
            if (maxValue < source.get(i))
		maxValue = source.get(i);

	}

	return maxValue;

    }

    public static int getMinValue(int[] source) {
	int minValue = Integer.MAX_VALUE;
	int size = source.length;
	for (int i = 0; i < size; i++) {
	    if (minValue > source[i])
		minValue = source[i];

	}

	return minValue;

    }

    public static int getMinValue(List<Integer> source) {
	int minValue = Integer.MAX_VALUE;
	int size = source.size();
	for (int i = 0; i < size; i++) {
	    if (minValue > source.get(i)) {
		minValue = source.get(i);
	    }

	}

	return minValue;

    }

}
