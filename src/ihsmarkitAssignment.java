import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ihsmarkitAssignment {
    private static List<String[]> palindromeSubstring(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<String[]> list = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int left = i - 1, right = i + 1, len = 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) { //Retrieving all the odd-length substring
                String[] palSub = new String[3];
                palSub[0] = s.substring(left, right + 1);
                palSub[1] = String.valueOf(left);
                palSub[2] = String.valueOf(right - left + 1);

                list.add(palSub);

                left -= 1;
                right += 1;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) { //Retrieving all the even-length substring
                String[] palSub = new String[3];
                palSub[0] = s.substring(left, right + 1);
                palSub[1] = String.valueOf(left);
                palSub[2] = String.valueOf(right - left + 1);

                list.add(palSub);

                left -= 1;
                right += 1;
            }
        }
        list.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o2[2]) - Integer.parseInt(o1[2]);
            }
        });
        return list;
    }

    public static void main(String[] args) {
        System.out.println("Please enter 1 or 2 for testing the code, 1 for using the default testing cases, 2 for inputting the string yourself.");
        System.out.println("Press 0 for exit and input 'log' for all the input you have given to the program.");
        LinkedList<String> inputs = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {

            String strInput = sc.nextLine();
            inputs.add(strInput);
            switch (strInput) {
                case "1": {
                    String input = "ABCBAHELLOHOWRACECARAREYOUILOVEUEVOLIIAMAIDOINGGOOD";

                    List<String[]> list = palindromeSubstring(input);
                    for (String[] palindrome : list) {
                        System.out.println(palindrome[0] + "  " + palindrome[1] + "  " + palindrome[2]);
                    }
                    break;
                }
                case "2": {
                    System.out.println("Please enter the input string: \n");
                    String input = sc.nextLine();

                    if (input == null || input.length() == 0) {
                        System.out.println("Input cannot be null or empty. ");
                    }

                    List<String[]> list = palindromeSubstring(input);
                    for (String[] palindrome : list) {
                        System.out.println(palindrome[0] + "  " + palindrome[1] + "  " + palindrome[2]);
                    }
                    break;
                }
                case "log":
                    inputs.removeLast();
                    System.out.println("The inputs are: ");
                    for (String s : inputs) System.out.println(s);
                    System.out.println("");
                    System.out.println("Please press 2 for arbitrary input. ");
                    break;
                case "0":
                    System.exit(0);
                case "reset":
                    inputs.clear();
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
        sc.close();
    }
}

