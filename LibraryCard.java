public class LibraryCard
{
    private int borrowLimit;
    private int borrowCount;
    private String cardRef;
    
    public LibraryCard(int thisLimit, int thisRefNumber) {
        borrowLimit = thisLimit;
        borrowCount = 0;
        cardRef = "CardID " + thisRefNumber;
    }
    
    public void swipe() {
        if (borrowCount == borrowLimit) {
            System.out.println("Cannot borrow more books!");
        } else {
            borrowCount++;
        }
    }
    
    public boolean expired() {
        return (borrowCount == borrowLimit);
    }
    
    public String getCardRef() {
        return cardRef;
    }
    
    public void describe() {
        System.out.println("Card ID: " + cardRef + "\nBorrows left: " + (borrowLimit - borrowCount));
    }
}
