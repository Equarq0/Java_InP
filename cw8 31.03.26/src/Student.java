import java.util.List;

public class Student {
    private String name;
    private Integer age;
    private String language;
    private Double rating;
    private List<String> hobbies;

    public Student(String name, Integer age, String language, Double rating, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.language = language;
        this.rating = rating;
        this.hobbies = hobbies;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public Double getRating() {
        return rating;
    }

    public List<String> getHobbies() {
        return hobbies;
    }


}
