package homework17;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> userMap = UserStream.streamUsers();

        System.out.println(userMap);
    }
}
