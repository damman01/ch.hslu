package ch.hslu.ad.sw08;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortDurationDisplay {

    private static final boolean CREATE_NEW_ARRAY = false;
    private static final String BIG_INT_ARRAY_TXT = "BigIntArray.txt";
    private static final int RANDOM_INT_MAX = Integer.MAX_VALUE;
    private static final Random RANDOM = new Random();
    private static final int[] ARRAY_TEST_SIZES = { 5_000_001, 10_000_001, 20_000_001 };
    private static final String[] TEST_TYPES = { "RANDOM", "SORTED", "REVERSED" };

    private static final Map<String, Consumer<int[]>> SORT_ALGOS = new HashMap<>();
    static {
        // SORT_ALGOS.put("Insertion", Sort::insertionSort);
        // SORT_ALGOS.put("Selection", Sort::selectionSort);
        // SORT_ALGOS.put("Bubble", Sort::bubbleSort);
        // SORT_ALGOS.put("Shell", Sort::shellSort);
        // SORT_ALGOS.put("QuickSort", Sort::quickSort);
        SORT_ALGOS.put("QuickISort", Sort::quickInsertionSort);
        // SORT_ALGOS.put("HeapSort", Sort::heapSort);
        // SORT_ALGOS.put("QSHSLU", Sort::quickSortHSLU);
        // SORT_ALGOS.put("QSHSLUMedian", Sort::quickSortHSLUMedianPivot);
        // SORT_ALGOS.put("MERGE_T25", Sort::mergeSortT25);
        // SORT_ALGOS.put("MERGE_T50", Sort::mergeSortT50);
        // SORT_ALGOS.put("MERGE_T100", Sort::mergeSortT100);
        // SORT_ALGOS.put("MERGE_T200", Sort::mergeSortT200);
        // SORT_ALGOS.put("MERGE_REC", Sort::mergeSortRec);
        // SORT_ALGOS.put("MERGE_T1.25k", Sort::mergeSortT1k25);
        SORT_ALGOS.put("MERGE_O", Sort::mergeSort);
        SORT_ALGOS.put("QS_Foked", Sort::quickSortForked);
        SORT_ALGOS.put("JAVA_SORT", Arrays::sort);
    }

    private static final Map<String, Map<Integer, List<Duration>>> TEST_RESULT = new HashMap<>();

    public static void main(String[] args) throws IOException, URISyntaxException {
        // generate new random int array and store it
        Path pathToNumbers = getPathToArrayFile();
        if (!Files.exists(pathToNumbers) || CREATE_NEW_ARRAY) {
            log.info("generating numbers and storing them into {}", pathToNumbers.toUri());
            createRandomIntArrayResource();
        }

        // fetch array from storage
        int[] fullArray = null;
        try (Stream<String> lines = Files.lines(getPathToArrayFile())) {
            fullArray = lines.mapToInt(Integer::parseInt).toArray(); // fetch stored numbers
        } catch (IOException ex) {
            log.error("failed to load numbers", ex);
        }

        // run tests
        for (Entry<String, Consumer<int[]>> algo : SORT_ALGOS.entrySet()) {
            TEST_RESULT.put(algo.getKey(), new HashMap<>());
            Map<Integer, List<Duration>> algoResults = TEST_RESULT.get(algo.getKey());
            log.info("*".repeat(44));
            log.info("Testing {} sort performance", algo.getKey());

            for (int j = 0; j < ARRAY_TEST_SIZES.length; j++) {
                int arraySize = ARRAY_TEST_SIZES[j];
                int previousArraySize = j == 0 ? 0 : ARRAY_TEST_SIZES[j - 1];
                List<Duration> algoTestSizeResult = new ArrayList<>();
                algoResults.put(arraySize, algoTestSizeResult);

                int[] testArray = Arrays.copyOfRange(fullArray, previousArraySize, arraySize + previousArraySize); // Prepare
                                                                                                                   // Array
                log.info("Testing speed for a {} sized int array", testArray.length);
                algoTestSizeResult.add(sort(algo.getValue(), testArray)); // Sorting random array
                algoTestSizeResult.add(sort(algo.getValue(), testArray)); // Sorting sorted array
                ArrayUtils.reverse(testArray);
                algoTestSizeResult.add(sort(algo.getValue(), testArray)); // Sorting reversed sorted array
            }
        }

        // log result summary
        for (Entry<String, Map<Integer, List<Duration>>> result : TEST_RESULT.entrySet()) {
            System.out.println(String.format("%12s", result.getKey())
                    + Stream.of(TEST_TYPES).map(i -> String.format("%12s", i)).collect(Collectors.joining()));
            for (int testSize : ARRAY_TEST_SIZES) {
                List<Duration> durations = result.getValue().get(testSize);
                System.out.println(String.format("%12d", testSize) + durations.stream()
                        .map(d -> String.format("%12d", d.toMillis())).collect(Collectors.joining()));
            }
        }
    }

    private static void createRandomIntArrayResource() throws IOException, URISyntaxException {
        int[] result = getRandomIntArray(IntStream.of(ARRAY_TEST_SIZES).sum());
        Files.write(getPathToArrayFile(),
                Arrays.stream(result).mapToObj(i -> String.valueOf(i)).collect(Collectors.toList()),
                Charset.defaultCharset());

    }

    private static Path getPathToArrayFile() throws URISyntaxException {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        URL url = cl.getResource(BIG_INT_ARRAY_TXT);
        return Paths.get(url.toURI());
    }

    private static Duration sort(Consumer<int[]> method, int[] testArray) {
        Instant start = Instant.now();
        method.accept(testArray);
        Instant end = Instant.now();

        return Duration.between(start, end);
    }

    private static int[] getRandomIntArray(int size) {
        return IntStream.generate(SortDurationDisplay::getRandomBoundedInt).limit(size).toArray();
    }

    private static Integer getRandomBoundedInt() {
        return RANDOM.nextInt(RANDOM_INT_MAX) * (RANDOM.nextBoolean() ? -1 : 1);
    }
}
