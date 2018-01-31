package com.oleamedical;

public final class Combine {

    public final static Object[][] combine(Object[][] data) {
        int[] indexes = new int[data.length];
        int lines = computeResultLength(data);
        Object[][] result = new Object[lines][];

        for(int i=0;i<lines;i++) {
            result[i] = getResult(indexes, data);
            if(i!=lines-1) {
                increment(indexes, data.length-1, data);
            }
        }

        return result;
    }

    private static Object[] getResult(int[] indexes, Object[][] data) {
        Object[] line = new Object[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            line[i] = data[i][indexes[i]];
        }
        return line;
    }

    private static void increment(int[] indexes, int rank, Object[][] data) {
        if(indexes[rank]<data[rank].length-1) {
            indexes[rank]++;
        } else {
            indexes[rank] = 0;
            increment(indexes, rank-1,data);

        }
    }

    private static int computeResultLength(Object[][] data) {
        int length = 1;
        for(Object[] array : data) {
            length *= array.length;
        }
        return length;
    }

}
