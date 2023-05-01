package homework17;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {
    private final String name;
    private final int age;
    private final String email;
    private final String gender;

    public User(String name, int age, String email, String gender) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }
    @Override
    public String toString() {
        return name;
    }
}

class UserCreator {
    private static final String[] MALE_NAMES =
            {"John", "Bill", "Bob", "Tom", "Jim", "Jack", "Harry", "Sam", "Max", "Alex", "Ron", "Philipp"};
    private static final String[] FEMALE_NAMES =
            {"Clara", "Kate", "Monica", "Lena", "Olivia", "Emily", "Sophia", "Emma", "Ava", "Mia", "Laura"};
    private static final String[] EMAIL_DOMAINS =
            {"gmail.com", "yahoo.com", "hotmail.com", "example.com", "outlook.com"};

    public static User createUser() {
        String name, email, gender;
        int age;

        Random random = new Random();
        gender = random.nextBoolean() ? "male" : "female";
        name = gender.equals("male") ? MALE_NAMES[random.nextInt(MALE_NAMES.length)] :
                FEMALE_NAMES[random.nextInt(FEMALE_NAMES.length)];
        age = random.nextInt(50) + 10;
        email = name.toLowerCase() + System.currentTimeMillis() + "@" +
                EMAIL_DOMAINS[random.nextInt(EMAIL_DOMAINS.length)];

        return new User(name, age, email, gender);
    }
}

class UserStream {
    public static Map<String, List<String>> streamUsers() {
        Stream<User> userStream = Stream.generate(UserCreator::createUser);

        return userStream
                .limit(20)
                .filter(user -> user.getAge() > 18)
                .sorted(Comparator.comparing(User::getName))
                .filter(user -> !user.getEmail().isEmpty())
                .collect(Collectors.groupingBy(User::getGender, LinkedHashMap::new,
                        Collectors.mapping(User::getName, Collectors.toList())));
    }
}
