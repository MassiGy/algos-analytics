import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) {

        ArraySort fst;
        ArraySort snd;
        ArraySort thrd;
        long start;
        long end;

        for (int len = 10; len < 100000; len *= 2) {

            fst = new ArraySort(len);
            fst.initArrayRand();
            snd = new ArraySort(fst);
            thrd = new ArraySort(fst);

            // calculate the corresponding time for the bubble sort
            start = System.nanoTime();
            fst.bubbleSort();
            end = System.nanoTime();

            // write the diffrence into a file
            try {
                Files.writeString(Path.of("bubbleSortOutput.txt"),
                        String.valueOf(len) + "," + String.valueOf(end - start) + "\n",
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);

            } catch (Exception excep) {
                System.out.println("Error payload is set to " + excep.getMessage());
            }

            // calculate the corresponding time for the bubble sort
            start = System.nanoTime();
            snd.quickSort(0, len - 1);
            end = System.nanoTime();

            // write the diffrence into a file
            try {
                Files.writeString(Path.of("quickSortOutput.txt"),
                        String.valueOf(len) + "," + String.valueOf(end - start) + "\n",
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);

            } catch (Exception excep) {
                System.out.println("Error payload is set to " + excep.getMessage());
            }

            // calculate the corresponding time for the bubble sort
            start = System.nanoTime();
            thrd.countSort();
            end = System.nanoTime();

            // write the diffrence into a file
            try {
                Files.writeString(Path.of("countSortOutput.txt"),
                        String.valueOf(len) + "," + String.valueOf(end - start) + "\n",
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);

            } catch (Exception excep) {
                System.out.println("Error payload is set to " + excep.getMessage());
            }
        }

    }
}