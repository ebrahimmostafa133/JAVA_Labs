public class lab2_1 {
    public static void main(String[] args) {

        String sentence = "ITI develops people and ITI house of developers and ITI fo people";
        String word = "ITI";

        // ---------- Using indexOf() ----------
        int count1 = 0;
        int index = 0;

        while ((index = sentence.indexOf(word, index)) != -1) {
            count1++;
            index = index + word.length();
        }

        System.out.println("Occurrences using indexOf(): " + count1);

        // ---------- Using split() ----------
        String[] parts = sentence.split(word);
        int count2 = parts.length - 1;

        System.out.println("Occurrences using split(): " + count2);
    }
}
//replace
//matches
//contains
