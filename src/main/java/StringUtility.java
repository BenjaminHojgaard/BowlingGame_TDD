

public class StringUtility {


    public String reverse(String s) {
        StringBuilder builder = new StringBuilder();

        char[] arr = new char[s.length()];

        int j = 0;
        for (int i = s.length()-1; i != -1; i--) {
            arr[j] = s.charAt(i);
            j++;
        }

        for (char c : arr) {
            builder.append(c);
        }

        return builder.toString();
    }

    public String upperCase(String s) {
        return s.toUpperCase();
    }

    public String lowerCase(String s) {
        return s.toLowerCase();
    }

}
