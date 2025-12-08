public class lab1_1 {
    public static void main(String[] args) {
        // 1
        System.out.println("Hello");


        // 2 - text to repeat
        String name = args[0]; // first argument is the text
        System.out.println(name);
        // 3 - number of repetitions
        int num = 0;
        
        try {
            num = Integer.parseInt(args[1]); 
        } catch (NumberFormatException e) {
            System.out.println("Invalid number: " + args[1]);
            return;
        }

        for (int i = 0; i < num; i++) {
            System.out.println(name);
        }
    }
}

