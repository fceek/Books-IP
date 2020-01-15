/**
 * A hard-working student in some college.
 *
 * @author Chen FAN
 * @version 1.0 6/12/2019
 */
public class Student
{
    private String name;
    private Library library;
    private LibraryCard libraryCard;
    private TextBook textBook;

    /**
     * Default Constructor
     * Constructs a student with initial name and library.
     * 
     * @param name name of the student
     * @param library the library which the student uses
     */
    public Student(String name, Library library) {
        this.name = name;
        this.library = library;
        this.libraryCard = library.issueCard();
        this.textBook = null;
    }

    /**
     * Check if the student has finished study.
     *
     * @return  true if the student's study is finished
     */
    public boolean finishedStudies() {
        return (textBook == null && libraryCard.expired());
    }
    
    /**
     * Getter for name.
     * 
     * @return name of the student
     */
    public String getName() {
        return name;
    }
    
    /**
     * Execute one step of study action.
     */
    public void study() {
        if (!finishedStudies()) {
            if (textBook == null) {
                textBook = library.borrowBook(libraryCard);
            } else if (!textBook.isFinished()) {
                textBook.readNextChapter();
            } else {
                textBook.closeBook();
                library.returnBook(textBook);
                textBook = null;
            }
        } else {
            System.out.println("This student finished study!");
        }
    }
    
    /**
     * Print current status of this student.
     */
    public void describe() {
        if (textBook == null) {
            System.out.println("Student " + name + " doesn't have a book.");
        } else {
            System.out.println("Student " + name + " is studying a book:");
            textBook.describe();
        }
        libraryCard.describe();
        if (finishedStudies()) {
            System.out.println("This student finished study.");
        }
    }
}
