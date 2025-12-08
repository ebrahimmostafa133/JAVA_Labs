public class lab2_3 {

    public static boolean isValidIP(String ip) {
        String ipRegex =
            "^(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)" +
            "(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}$";

        return ip.matches(ipRegex);
    }
    public static String[] splitIP(String ip) {
        if (!isValidIP(ip)) {
            throw new IllegalArgumentException("Invalid IP Address");
        }
        return ip.split("\\.");
    }

    public static void main(String[] args) {
        String ip = "192.168.1";

        if (isValidIP(ip)) {
            String[] parts = splitIP(ip);
            System.out.println("Valid IP");
            for (String part : parts) {
                System.out.println(part);
            }
        } else {
            System.out.println("Invalid IP");
        }
    }

}
