import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) {

        ArraySort fst;
        ArraySort snd;
        long start;
        long end;

        fst = new ArraySort(6);
        fst.initArrayRand();
        fst.array[2].setId(20);
        fst.array[4].setId(20);
        fst.printArray();
       
        System.out.println("\n\n");
        fst = fst.countSort();
        fst.printArray();


        // for (int len = 10; len < 10000; len *= 2) {
        //     fst = new ArraySort(len);
        //     fst.initArrayRand();
        //     snd = new ArraySort(fst);

        //     // calculate the corresponding time for the bubble sort
        //     start = System.nanoTime();
        //     fst.bubbleSort();
        //     end = System.nanoTime();

        //     // write the diffrence into a file
        //     try {
        //         Files.writeString(Path.of("bubbleSortOutput.txt"),
        //                 String.valueOf(len) + "," + String.valueOf(end - start) + "\n",
        //                 StandardOpenOption.CREATE,
        //                 StandardOpenOption.APPEND);

        //     } catch (Exception excep) {
        //     }

        //     snd.initArrayRand();
        //     // calculate the corresponding time for the bubble sort
        //     start = System.nanoTime();
        //     snd.quickSort(0, len - 1);
        //     end = System.nanoTime();

        //     // write the diffrence into a file
        //     try {
        //         Files.writeString(Path.of("quickSortOutput.txt"),
        //                 String.valueOf(len) + "," + String.valueOf(end - start) + "\n",
        //                 StandardOpenOption.CREATE,
        //                 StandardOpenOption.APPEND);

        //     } catch (Exception excep) {
        //     }

        // }


    }
}