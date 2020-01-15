public class Library
{
    static int LIMIT = 5;
    static int CHAPTER = 4;
    
    private TextBook[] bookShelf;
    private int nextBook;
    private int cardsIssued;
    
    public Library(int shelfCapacity) {
        bookShelf = new TextBook[shelfCapacity + 1];
        nextBook = 0;
        cardsIssued = 0;
        for (int i = 0; i < shelfCapacity; i++) {
            bookShelf[i] = new TextBook("TextBook No." + i, CHAPTER);
        }
    }

    public LibraryCard issueCard() {
        LibraryCard thisCard = new LibraryCard(LIMIT, cardsIssued);
        cardsIssued++;
        return thisCard;
    }
    
    public TextBook borrowBook(LibraryCard card) {
        if (card == null) {
            System.out.println("You have to bring your card!");
            return null;
        }
        
        if (bookShelf[nextBook] != null && !card.expired()) {
            nextBook++;
            card.swipe();
            return bookShelf[nextBook -1];
        } else if (card.expired()) {
            card.swipe();
            return null;
        } else {
            System.out.println("Bookshelf is empty!");
            return null;
        }
    }
    
    public void returnBook(TextBook book) {
        if (nextBook == 0) {
            System.out.println("Bookshelf is full! Where did you get extra books!?");
            return;
        }
        
        nextBook--;
        bookShelf[nextBook] = book;
        
    }
    
    public void describe() {
        System.out.println("Books left: " + (bookShelf.length - nextBook -1) + "\nCards issued: " + cardsIssued);
    }
}
