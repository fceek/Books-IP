public class TextBook
{
    private String bookTitle;
    private int bookLength;
    private int lastRead;
    
    public TextBook(String thisTitle, int thisLength) {
        bookTitle = thisTitle;
        bookLength = thisLength;
        lastRead = 0;
    }
    
    public String getTitle() {
        return bookTitle;
    }
    
    public void readNextChapter() {
        if (lastRead == bookLength) {
            System.out.println("End of book reached!");
        } else {
            lastRead++;
        }
    }
    
    public boolean isFinished() {
        return (lastRead == bookLength);
    }
    
    public void closeBook() {
        lastRead = 0;
    }
    
    public void describe() {
        System.out.println("Book title: " + bookTitle + "\nChapters left: " + (bookLength - lastRead));
    }
}
