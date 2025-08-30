import java.util.*;

public class Anna {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String line = "____________________________________________________________";
    int len = line.length();
    System.out.println(line);
    System.out.println("Hello! I'm Anna!");
    System.out.println("What can i do for you?");
    System.out.println(line);
    int c = 0;
    String[] list = new String[100];
    for (int i = 0; i <= 100; i++) {
    String word = in.nextLine();
    c = c + 5;
    if(word.equals("bye")) {
    break;
    }
    else {
        if((c%len) >= (len-5)) {
            c = 0;
        }
        System.out.println(line.substring(0,c) + "(._.)" + line.substring(c+5,len));
        if(word.equals("list")) {
            for(int j=0;j<i;j++) {
                System.out.println(j+". " + list[j]);
            }
            i = i - 1;
        }
        else{
            list[i] = word;
            System.out.println("added: " + list[i]);
        }
        System.out.println(line.substring(0,c) + "(._.)" + line.substring(c+5,len));
    }
    }
    System.out.println(line);
    System.out.println("Bye. Hope to see you again soon!");
    System.out.println(line);
    }
}
