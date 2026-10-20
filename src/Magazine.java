public class Magazine extends LibraryItem {
    private final int issueNumber;

    public Magazine(String code, String title, int issueNumber){
        super(code, title);

        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Issue Number must be greater than Zero");
        }

        this.issueNumber = issueNumber;
    }

    public int getIssueNumber(){
        return issueNumber;
    }
    
}
