package homework16;

public enum CategoryName {

    PROGRAMMING("Програмування"), TESTING("Тестування"),
    MANAGEMENT("Менеджмент"), MARKETING("Маркетинг"),
    DESIGN("Дизайн"), KIDS("Дитячі курси");

    private String title;

    CategoryName(String title) {
        this.title = title;
    }
}
