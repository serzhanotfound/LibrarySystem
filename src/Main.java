public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book = new Book("B001", "Хоббит", "Дж. Р. Р. Толкин");
        book.addGenre("Фэнтези");
        book.addGenre("Приключения");
        book.addGenre("Фэнтези");

        Magazine magazine = new Magazine("M001", "National Geographic", 12);

        library.addItem(book);
        library.addItem(magazine);

        Reader reader = new Reader("R001", "Сержан");
        library.registerReader(reader);

        System.out.println("=== Поиск издания ===");
        LibraryItem found = library.findItem("B001");

        if (found != null) {
            System.out.println("Найдено: " + found.getTitle());
        }

        System.out.println("Жанры: " + book.getGenres());
        System.out.println("Количество жанров: " + book.getGenres().size());

        System.out.println("\n=== Выдача книги ===");
        library.borrowItem("B001", "R001");
        System.out.println("Статус книги: " + book.getStatus());

        System.out.println("\n=== Попытка повторной выдачи ===");
        try {
            library.borrowItem("B001", "R001");
        } catch (IllegalStateException exception) {
            System.out.println("Ошибка: " + exception.getMessage());
        }

        System.out.println("\n=== Возврат книги ===");
        library.returnItem("B001", "R001");
        System.out.println("Статус книги: " + book.getStatus());

        System.out.println("\n=== Выдача и возврат журнала ===");
        library.borrowItem("M001", "R001");
        System.out.println("Статус журнала: " + magazine.getStatus());

        library.returnItem("M001", "R001");
        System.out.println("После возврата: " + magazine.getStatus());

        System.out.println("\n=== Потеря книги ===");
        library.markItemAsLost("B001");
        System.out.println("Статус книги: " + book.getStatus());

        try {
            library.borrowItem("B001", "R001");
        } catch (IllegalStateException exception) {
            System.out.println("Ошибка: " + exception.getMessage());
        }
    }
}