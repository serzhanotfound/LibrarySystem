public class Reader {
    private final String id;
    private final String name;

    public Reader(String id, String name) {
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException("Id mustn't be Null");
        }

        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name mustn't be Null");
        }

        this.id = id.trim();
        this.name = name.trim();
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    
}
