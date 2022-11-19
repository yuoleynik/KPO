public class Main {
    public static void main(String[] args) {
        double[] arr = new double[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random();
        }
        double avg = 0;
        double max = arr[0];
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
            if (min > arr[i])
                min = arr[i];
            avg += arr[i]/arr.length;
        }
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        System.out.println("Avg = " + avg);
    }
}