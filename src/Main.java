/** AUTHOR: David Faulkner
 *  CREATED: 18 June 2024
 *  MODIFIED: 20 June 2024
 *  This file can also be downloaded as a complete IntelliJ project at
 *  https://github.com/davo-faulkner/study_com_cs_201_assignment.
 *  Note that the TreeMap warning exists because the specifications never
 *  required anything to be done with the TreeMap, only that it is used to
 *  sort the HashMap which is done automatically with the `putAll()` method.
 *  The `main()` method in the `Main` class contains all method calls listed
 *  in the specifications, in order. The `BinaryTree` and `Node` classes are
 *  located in the `BinaryTree.java` file. The Binary Search Tree was
 *  populated using the `statesAndCapitalsHashMap` rather than the
 *  `statesAndCapitalsTreeMap` since ordered arrays created unbalanced Binary
 *  Search Trees, thus negating the performance increase of a Binary Search
 *  Tree.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    // Declare all global variables
    private static final Scanner inputScanner = new Scanner(System.in);
    private static boolean isFirstAnswerCorrect = false;
    private static int correctAnswers = 0;
    private static final Map<String, String> statesAndCapitalsHashMap =
            new HashMap<>();
    private static final Map<String, String> statesAndCapitalsTreeMap =
            new TreeMap<>();
    private static final BinaryTree binaryTree = new BinaryTree();
    private static final String[][] statesAndCapitalsArray = {
            {"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"},
            {"California", "Sacramento"},
            {"Colorado", "Denver"},
            {"Connecticut", "Hartford"},
            {"Delaware", "Dover"},
            {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},
            {"Hawaii", "Honolulu"},
            {"Idaho", "Boise"},
            {"Illinois", "Springfield"},
            {"Indiana", "Indianapolis"},
            {"Iowa", "Des Moines"},
            {"Kansas", "Topeka"},
            {"Kentucky", "Frankfort"},
            {"Louisiana", "Baton Rouge"},
            {"Maine", "Augusta"},
            {"Maryland", "Annapolis"},
            {"Massachusetts", "Boston"},
            {"Michigan", "Lansing"},
            {"Minnesota", "Saint Paul"},
            {"Mississippi", "Jackson"},
            {"Missouri", "Jefferson City"},
            {"Montana", "Helena"},
            {"Nebraska", "Lincoln"},
            {"Nevada", "Carson City"},
            {"New Hampshire", "Concord"},
            {"New Jersey", "Trenton"},
            {"New Mexico", "Santa Fe"},
            {"New York", "Albany"},
            {"North Carolina", "Raleigh"},
            {"North Dakota", "Bismarck"},
            {"Ohio", "Columbus"},
            {"Oklahoma", "Oklahoma City"},
            {"Oregon", "Salem"},
            {"Pennsylvania", "Harrisburg"},
            {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"},
            {"Tennessee", "Nashville"},
            {"Texas", "Austin"},
            {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"},
            {"Washington", "Olympia"},
            {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"},
            {"Wyoming", "Cheyenne"}
    };

    public static void main(String[] args) {

        quizCapitalForAlabama();

        printArray();

        bubbleSortArray();

        quizOnCapitalsArray();

        convertArrayToHashMap();

        printHashMap();

        sortHashMapUsingTreeMap();

        convertHashMapToBinaryTree();

        searchBinaryTreeForCapital();
    }

    /* Search Binary Search Tree for a capital using the state as a key.
       User input is case-insensitive.
     */
    private static void searchBinaryTreeForCapital() {
        String inputString = "";

        System.out.println();

        // Keeps asking the user for input if user just hits `Enter`
        while (inputString.isEmpty()) {
            System.out.println("Please enter a state to search: ");

            inputString = inputScanner.nextLine();
        }

        /* Trims and matches the case of the data in the user input to match
           the case of the data in the Binary Search Tree
         */
        inputString = capitalizeFirstLetter(inputString.trim().toLowerCase());

        // Assign the returned Node from search to `resultNode`
        Node resultNode = binaryTree.searchNode(inputString);

        // Success path printing capital of the search state
        if (resultNode != null) {
            System.out.println("\nThe capital of " + inputString + " is " +
                    resultNode.capital + ".");
        // Fail path if the capital wasn't found
        } else {
            System.out.println("\nThe capital of " + inputString +
                    " was not found.");
        }
    }

    /* Helper method to capitalize first letter of each word in capitals
       when returning search results from Binary Search Tree
     */
    private static String capitalizeFirstLetter(String input) {
        return Arrays.stream(input.split("\\s+"))
                .map(word -> word.substring(0, 1).toUpperCase() +
                        word.substring(1)).collect(
                        Collectors.joining(" "));
    }

    // Convert the `statesAndCapitalsHashMap` to a Binary Search Tree
    private static void convertHashMapToBinaryTree() {
        statesAndCapitalsHashMap.forEach(binaryTree::insertNode);
    }

    /* Sort the `statesAndCapitalsHashMap` automatically by converting it
       to a `statesAndCapitalsTreeMap`
     */
    private static void sortHashMapUsingTreeMap() {
        statesAndCapitalsTreeMap.putAll(statesAndCapitalsHashMap);
    }

    // Convert the `statesAndCapitalsArray` to a `statesAndCapitalsHashMap`
    private static void convertArrayToHashMap() {
        for (String[] stateAndCapital : statesAndCapitalsArray) {
            statesAndCapitalsHashMap.put(stateAndCapital[0],
                    stateAndCapital[1]);
        }
    }

    // Print the `statesAndCapitalsHashMap`
    private static void printHashMap() {
        System.out.println("\nStates and capitals HashMap contents:");

        statesAndCapitalsHashMap.forEach((state, capital) ->
                System.out.println(state + ": " + capital));
    }

    /* Quiz user on the capital of each state and print the total number
       of correct answers
     */
    private static void quizOnCapitalsArray() {
        System.out.println();

        for (String[] stateAndCapital : statesAndCapitalsArray) {
            System.out.println("What is the capital of " +
                    stateAndCapital[0] + "?");

            String inputString = inputScanner.nextLine();

            if (inputString.trim().equalsIgnoreCase(stateAndCapital[1])) {
                correctAnswers++;
            }
        }

        System.out.println("Correct Answers : " + correctAnswers);
    }

    // Print the original `statesAndCapitalsArray` sorted by state
    private static void printArray() {
        System.out.println("States and capitals array sorted by state:");

        for (String[] stateAndCapital : statesAndCapitalsArray) {
            System.out.println(stateAndCapital[0] + ": " + stateAndCapital[1]);
        }
    }

    // Request capital for a state (Alabama)
    private static void quizCapitalForAlabama() {
        System.out.println("What is the capital of " +
                statesAndCapitalsArray[0][0] + "?");

        String inputString = inputScanner.nextLine();

        if (inputString.trim().equalsIgnoreCase(statesAndCapitalsArray[0][1])) {
            isFirstAnswerCorrect = true;
        }

        if (isFirstAnswerCorrect) {
            System.out.println("\nCorrect!\n");
        } else {
            System.out.println("\nSorry, but the capital of " +
                    statesAndCapitalsArray[0][0] + " is " +
                    statesAndCapitalsArray[0][1] + ".\n");
        }
    }

    // Perform bubble sort on `statesAndCapitalsArray` in-place.
    private static void bubbleSortArray() {
        for (int i = 0; i < statesAndCapitalsArray.length - 1; i++) {
            for (int j = 0; j < statesAndCapitalsArray.length - 1 - i; j++) {
                if (statesAndCapitalsArray[j][1].compareTo(
                        statesAndCapitalsArray[j + 1][1]) > 0) {
                    String[] temp = statesAndCapitalsArray[j];
                    statesAndCapitalsArray[j] = statesAndCapitalsArray[j + 1];
                    statesAndCapitalsArray[j + 1] = temp;
                }
            }
        }
    }
}
