import java.util.ArrayList;

public class bookmain {

    public static void main(String[] args) {

        ArrayList<book> bookList = new ArrayList<>();

        try {
            book b1 = new book("The Alchemist", "Paulo Coelho", "Fiction", 500);
            book b2 = new book("Clean Code", "Robert Martin", "Programming", 750);
            book b3 = new book("Harry Potter", "J.K. Rowling", "Fiction", 650);

            bookList.add(b1);
            bookList.add(b2);
            bookList.add(b3);

            // Trying to create a book with negative price
            book b4 = new book("Invalid Book", "Unknown", "Fiction", -200);
            bookList.add(b4);

        } catch (InvalidPriceException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Display all books
        System.out.println("\nAll Books:");
        double totalPrice = 0;

        for (book book : bookList) {
            System.out.println(book);
            totalPrice += book.getPrice();
        }

        // Calculate average price
        if (bookList.size() > 0) {
            double average = totalPrice / bookList.size();
            System.out.println("\nAverage Price of Books: " + average);
        }

        // Print books of genre "Fiction" using forEach()
        System.out.println("\nFiction Books:");
        bookList.forEach(book -> {
            if (book.getGenre().equalsIgnoreCase("Fiction")) {
                System.out.println(book);
            }
        });
    }
}