package com.ds.java.search;

//
// SORTED ARRAY SEARCH
public class BinarySearch {
    public static void main(String[] args) {
        int a[] = { -7,  5, 6, 8, 10, 14, 17, 21, 28, 33, 39, 400, 2323, 2649};
        int res = binarySearch(a, -7, 0, a.length - 1);
        if(res == -1)
            System.out.println("Not Found");
        else
            System.out.println("Found //" + res + ":" + a[res]);
    }

    /**
     * The search starts with the full array:
     *      low = 0, high = 14, mid = 7.
     * Value at index 7 is 17, but 6 < 17, so the search continues in the left half.
     * The next step is:
     *      low = 0, high = 6, mid = 3.
     * Value at index 3 is 6, which matches the key.
     * The algorithm terminates, and the result is that the key 6 is found at index 3.
     *
     */
    public static int binarySearch(int[] elements, int key, int low, int high) {
        // Base case: if low index exceeds high, element is not found
        if (low > high ) {
            return -1;
        }

        int mid = (low + high) / 2;
        System.out.println("----"+low+ ":"+ elements[low] + "/" + high + ":" + elements[high]);


        // Check if the key is at mid
        if (elements[mid] == key)
            return mid;             // If key is greater, search the right half
        else if (key > elements[mid])
            low = mid + 1;          // If key is smaller, search the left half
        else
            high = mid - 1;

        System.out.println(low+  "/" + high);
        return binarySearch(elements, key, low, high);
    }
    // TODO: Length even/odd-> before first, after last, mid, random mid left, mid right,
}
