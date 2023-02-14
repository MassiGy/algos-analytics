import java.util.Scanner;

public class ArraySort {

    public int size;
    public Element[] array;

    public ArraySort() {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Please, choose the size of the array : ");
            this.size = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong entry, default value : 10 !");
            this.size = 10;
        }

        this.array = new Element[this.size];
        sc.close();
    }

    public ArraySort(int size) {
        this.size = size;
        this.array = new Element[size];
    }

    public ArraySort(ArraySort list) {
        this.size = list.size;
        this.array = new Element[this.size];

        for (int i = 0; i < this.size; i++) {
            this.array[i] = new Element(list.array[i].content);
            this.array[i].id = list.array[i].id;
        }
    }

    public void initArrayRand() {

        for (int i = 0; i < this.size; i++) {
            /**
             * NOTE: do not make the random numbers interval huge when using the
             * countingSort
             * to avoid having to declare and occurence store with a huge length
             */
            this.array[i] = new Element((Double) (Math.random() * 1000));
        }
    }

    /**
     * Bubble Sort
     * 
     * 
     * @description
     *              This bubbleSort impelemntation is optemized twice.
     * 
     *              the first optimisation is done with the swap flag
     * 
     *              the second is done by reducing the lenght of the
     *              array to sort by tracking the lastChangeIndex, which
     *              is exactly the index that will define the new limit
     *              for our walkthrough
     * 
     * @param void
     */
    public void bubbleSort() {

        boolean swap = true;
        int j = 0;
        Element temp;
        int lastSwapIndex = this.size - 1;
        int swapIndex = -1;

        for (int i = 0; i < this.size && swap; i++) {
            swap = false;
            j = 0;
            swapIndex = -1;

            while (j < lastSwapIndex) {

                if (this.array[j + 1].id < this.array[j].id) {
                    // swap them
                    temp = this.array[j + 1];
                    this.array[j + 1] = this.array[j];
                    this.array[j] = temp;

                    // set the swap flag to true
                    swap = true;
                    // set the change index to j
                    swapIndex = j;
                }
                j++;
            }
            // at the end, after the last swap, update the last swap index
            lastSwapIndex = swapIndex;
        }
    }

    /**
     * Quick Sort
     * 
     * 
     * @param start - start index of the current partition to sort.
     * @param end   - end index of the current partition to sort.
     * 
     * @description
     *              This quickSort implementation is recursive, and
     *              uses a helper function to do the partitionning
     *              work.
     * 
     * 
     */
    public void quickSort(int start, int end) {
        // base case
        if (end <= start)
            return;

        // calculate the next pivot index
        int pivot = partition(start, end);

        // recursively handle the two partitions
        quickSort(start, pivot - 1);
        quickSort(pivot + 1, end);
    }

    /**
     * 
     * @param start - start index of the current partition to sort.
     * @param end   - end index of the current partition to sort.
     * @return {Int} - the next pivot index
     * 
     * @description
     *              This helper function will iteratively walktrough the partition
     *              determined by the start and end indecies, and rearrange the
     *              elements by comparing them to the choosed pivot. In this flavor
     *              the pivot is choosed to be the first element of the partition.
     */
    public int partition(int start, int end) {

        int i = end + 1;
        int j = end;
        Element temp;

        for (; j > start; j--) {

            if (this.array[j].id > this.array[start].id) {
                // decrement the i index
                i--;
                // swap them
                temp = this.array[j];
                this.array[j] = this.array[i];
                this.array[i] = temp;
            }

        }
        // decrement the i index
        i--;

        // swap the pivot to the right place
        temp = this.array[i];
        this.array[i] = this.array[start];
        this.array[start] = temp;

        // return the new index of our pivot
        return i;
    }

    /**
     * Counting Sort
     * 
     * @param void
     * 
     * @description
     *              we will iterate through all the elements set to:
     *              Find out the max.
     *              Declare an occurence array of ints (since our comparison is
     *              based on the key values which are ints),
     *              with a length equal to the max value
     * 
     *              Iterate through our set of elements and calculate the
     *              occurences.
     * 
     *              Reiterate through the occurence array to progressivly complement
     *              the slots using the following schema:
     * 
     *              on slot N, the occurence will be equal to the value of the slot
     *              N- 1 + thecoccurence of the value N on the elements set.
     * 
     * @note
     *       using large values along side the countingSort, since this
     *       ake the auxilary space higher.
     * 
     */
    public ArraySort countSort() {
        // we only calculate the max, since the ids are supposed to be positive
        int max = this.array[0].id;

        for (int i = 0; i < this.size; i++) {
            if (this.array[i].id > max)
                max = this.array[i].id;
        }
        // create our occurences list, the length is equal to max + 1, since the
        // max should be on the occurenceStore
        int[] occurenceStore = new int[max + 1];
        // create our result list
        ArraySort res = new ArraySort(this.size);

        // calculate the occurences
        for (int i = 0; i < this.size; i++) {
            occurenceStore[this.array[i].id]++;
        }

        // complementation
        for (int i = 1; i < max + 1; i++) {
            occurenceStore[i] += occurenceStore[i - 1];
        }

        // create the res list which will be sorted
        Element el;
        // iterate from the end, to make the sort stable
        for (int i = this.size - 1; i >= 0; i--) {

            // create an element with the correct content to make the sorting
            // stable
            el = new Element(this.array[i].content);
            // set the correct id
            el.id = this.array[i].id;

            // populate the right slot on the res array
            res.array[occurenceStore[this.array[i].id] - 1] = el;

            // decrement the occurence of the element, since
            // we can have multiple occurences, and by doing so, we
            // automaticlly calculate the right index for the next occurence.
            occurenceStore[this.array[i].id]--;
        }

        return res;
    }

    void printArray() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.array[i].toString());
        }
    }
}
