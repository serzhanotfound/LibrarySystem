import java.util.HashMap;
import java.util.Map;

public class Library{
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Reader> readers = new HashMap<>();
    private final Map<String, String> loans = new HashMap<>();

    public void addItem(LibraryItem item){
        if(item == null){
            throw new IllegalArgumentException("Издание не должно быть null");
        }

        String code = item.getCode();

        if(items.containsKey(code)) {       // Есть ли уже такой ключ?
            throw new IllegalArgumentException("Издание с кодом " + code + "уже существует");
        }

        items.put(code, item);
    }

    public void borrowItem(String code, String readerId) {
    LibraryItem item = items.get(code);

    if (item == null) {         //Находим издание.
        throw new IllegalArgumentException("Издание не найдено");
    }

    Reader reader = readers.get(readerId);

    if (reader == null) {          //Проверяем читателя.
        throw new IllegalArgumentException("Читатель не зарегистрирован");
    }

    item.borrow();   // Вызываем item.borrow(), который проверяет статус и меняет его.
    loans.put(code, readerId);   //Записываем выдачу.
}

public void returnItem(String code, String readerId) {
    LibraryItem item = items.get(code);

    if (item == null) {
        throw new IllegalArgumentException("Издание не найдено");
    }

    String borrowerId = loans.get(code);

    if (borrowerId == null) {
        throw new IllegalStateException("Это издание не выдавалось");
    }

    if (!borrowerId.equals(readerId)) {
        throw new IllegalArgumentException(
            "Издание выдано другому читателю"
        );
    }

    item.returnItem();
    loans.remove(code);
    }

    public void markItemAsLost(String code) {
    LibraryItem item = items.get(code);

    if (item == null) {
        throw new IllegalArgumentException("Издание не найдено");
    }

    item.markAsLost();
}

    public LibraryItem findItem(String code){
        return items.get(code);
    }

    public void registerReader(Reader reader){
        if(reader == null){
            throw new IllegalArgumentException("Читатель не должн быть null");
        }
        
        String id = reader.getId();

        if(readers.containsKey(id)){
            throw new IllegalArgumentException("Читатель с номером " + id + " уже зарегистрирован");
        }
        
        readers.put(id, reader);
    }

    public Reader findReader(String id){
        return readers.get(id);
    }
}