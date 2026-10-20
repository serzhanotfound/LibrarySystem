import java.util.HashSet;
import java.util.Set;

public class Book extends LibraryItem{
    private final String author;
    private final Set<String> genres = new HashSet<>();

    public Book(String code, String title, String author) {
        super(code, title);

        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author mustn't be Null");
        }

        this.author = author.trim();
    }

    public void addGenre(String genre) {
    if (genre == null || genre.isBlank()) {
        throw new IllegalArgumentException("Жанр не должен быть пустым");
    }

    genres.add(genre.trim());
    }

    public Set<String> getGenres() {
        return Set.copyOf(genres);
    }
    
    public String getAuthor(){
        return author;
    }
}