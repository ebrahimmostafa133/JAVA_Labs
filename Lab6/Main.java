import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Main {

    static Map<Character, Set<String>> dictionary = new TreeMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1: Add word");
            System.out.println("2: List all words");
            System.out.println("3: Search for a word");
            System.out.println("4: Exit");

            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }

            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    System.out.print("Enter the word: ");
                    String newWord = scanner.nextLine();
                    addWord(newWord);
                    break;

                case 2:
                    listDictionary();
                    break;

                case 3:
                    System.out.print("Enter the word: ");
                    String wordToSearch = scanner.nextLine();
                    searchWord(wordToSearch);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static boolean isEnglishWord(String word) {
        return word.matches("[a-zA-Z]+");
    }

    static void addWord(String word) {
        if (word == null || word.isEmpty()) {
            System.out.println("Invalid input: empty word.");
            return;
        }
        if (!isEnglishWord(word)) {
            System.out.println("Invalid input: word must contain only English letters (A–Z).");
            return;
        }
        word = word.toLowerCase();
        char firstLetter = word.charAt(0);
        dictionary.computeIfAbsent(firstLetter, key -> new TreeSet<>()).add(word);
        System.out.println("Word added successfully.");
    }

    static void listDictionary() {
        if (dictionary.isEmpty()) {
            System.out.println("Dictionary is empty.");
            return;
        }
        dictionary.forEach((letter, wordSet) ->System.out.println(letter + ": " + wordSet));
    }

    static void searchWord(String wordToFind) {
        if (wordToFind == null || wordToFind.isEmpty()) {
            System.out.println("Not Found");
            return;
        }
        if (!isEnglishWord(wordToFind)) {
            System.out.println("Invalid search: only English letters allowed.");
            return;
        }
        wordToFind = wordToFind.toLowerCase();
        char firstLetter = wordToFind.charAt(0);

        if (dictionary.containsKey(firstLetter)&& dictionary.get(firstLetter).contains(wordToFind)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}
