package Problems;


import java.util.Arrays;

@SuppressWarnings("ALL")
public class SumArray {
    public static void main(String[] args) {
        int[] integers = new int[100];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = i;
        }
        System.out.println(Arrays.toString(integers));


        int total = sum(integers);
        System.out.println(total);
        //answer should be 4950 ((last * last + 1) / 2)
    }

    private static int sum(int[] array) {
      // I don't know how to do any of this and we did not get time to go over it so I'll see you in office hours
    	
   

        return 0;
    }
}
