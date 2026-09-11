public class Book {

    final String Author;
    final String Title;
    final String isbn;
    int id;
    Member borrowedBy;


    public Book(final String Author, final String Title, final String isbn, int id){
        this.Author = Author;
        this.Title = Title;
        this.isbn = isbn;
        this.id = id;

    }
    public String toString(){
        String status = isAvailable() ? "På hylden" : "Udlånt by " + borrowedBy ;
        return String.format("""
                            Name: %s
                            Title: %s
                            Isbn: %s
                            id: %d
                            %s
                           """, Author, Title, isbn, id, status);

    }
    public boolean loanBook(Member member) {
        if (isAvailable()) {
            borrowedBy = member;
            return true;
        }
        return false;
    }

    public void returnBook() {
        if (isAvailable()) {
            IO.println("");
        }
    }
    public boolean isAvailable() {
        return borrowedBy == null; // bogen er ledig og true returnere også. hvis den retunere false så har en lånt bogen.
    }

}
