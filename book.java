public class book {

    private String title;
    private String author;
    private String genre;
    private double price;

    // Default constructor
    public book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.genre = "Unknown";
        this.price = 0.0;
    }

    // Parameterized constructor
    public book(String title, String author, String genre, double price) 
            throws InvalidPriceException {

        if (price < 0) {
            throw new InvalidPriceException("Price cannot be negative!");
        }

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    // toString() method
    @Override
    public String toString() {
        return "Title: " + title +
               ", Author: " + author +
               ", Genre: " + genre +
               ", Price: " + price;
    }
}