public abstract class LibraryItem{
    private final String code;
    private final String title;
    private ItemStatus status;

    protected LibraryItem(String code, String title){
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Code mustn't be Null");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title mustn't be Null");
        }

        this.code = code.trim();
        this.title = title.trim();
        this.status = ItemStatus.AVAILABLE;
    }

    public void borrow() {
    if (status != ItemStatus.AVAILABLE) {
        throw new IllegalStateException("Издание недоступно для выдачи");
    }

    status = ItemStatus.BORROWED;
}

    public void returnItem() {
    if (status != ItemStatus.BORROWED) {
        throw new IllegalStateException("Издание не находится на руках");
    }

    status = ItemStatus.AVAILABLE;
    }

    public void markAsLost() {
    if (status != ItemStatus.AVAILABLE) {
        throw new IllegalStateException(
            "Отметить потерянным можно только доступное издание"
        );
    }

    status = ItemStatus.LOST;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public ItemStatus getStatus() {
        return status;
    }
}