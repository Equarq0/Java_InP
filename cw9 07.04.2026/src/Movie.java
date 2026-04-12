public class Movie {
    private int id;
    private String name;
    private String genre;
    private int year;
    private double rating;
    private int duration;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return name;
    }

    public Movie(int id, String name, String genre, int year, double rating, int duration) {
        this.name = name;
        this.id = id;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
    }
}
