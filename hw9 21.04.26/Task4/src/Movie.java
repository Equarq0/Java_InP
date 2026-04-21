import java.util.Objects;

class Movie {
    int id;
    String title;
    int year;
    double rating;
    int directorId;

    public Movie(int id, String title, int year, double rating, int directorId) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.directorId = directorId;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public double getRating() { return rating; }
    public int getDirectorId() { return directorId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && year == movie.year && Double.compare(rating, movie.rating) == 0 && directorId == movie.directorId && Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, rating, directorId);
    }

    @Override
    public String toString() {
        return "Movie{title='" + title + "', rating=" + rating + "}";
    }
}