import java.util.ArrayList;
import java.util.Random;
/**
 * A college with students enrolled to study in.
 *
 * @author Chen FAN
 * @version 1.0 6/12/2019
 */
public class College
{
    private ArrayList<Student> students;
    private Library library;
    private Random randomGenerator;

    /**
     * Default Constructor
     * Constructs a college with initial number of students and number of books in the college's library.
     * 
     * @param studentNumber number of students
     * @param bookNumber number of books in the library
     */
    public College(int studentNumber, int bookNumber) {
        this.library = new Library(bookNumber);
        this.students = new ArrayList<Student>();
        for (int i = 0; i < studentNumber; i++) {
            students.add(new Student("Student"+i, this.library));
        }
        this.randomGenerator = new Random();
    }

    /**
     * Print current status of the whole college.
     */
    public void describe() {
        System.out.println("This college currently has " + students.size() + " hard-working students.");
        System.out.println("Library status:");
        library.describe();
    }
    
    /**
     * Execute one step of the college routine.
     */
    private void nextStep() {
        if (students.size() == 0) {
            System.out.println("Now everything has gone quiet");
        } else {
            int studentCount = randomGenerator.nextInt(students.size());
            Student thisStudent = students.get(studentCount);
            if (thisStudent.finishedStudies()) {
                students.remove(studentCount);
                System.out.println(thisStudent.getName() + " has graduated and left.");
            } else {
                thisStudent.study();
            }
        }
    }
    
    /**
     * Make the college run by given number of steps.
     * 
     * @param nSteps number of steps for the college to run
     */
    public void runCollege(int nSteps) {
        if (nSteps < 1) {
            System.out.println("Invalid input!");
            return;
        }
        for (int i = 0; i < nSteps; i++) {
            System.out.println("Now : Step " + (i+1));
            describe();
            nextStep();
            System.out.println(" ================");
        }
    }
    
    public static void main(String[] args) {
        int studentNum = 4;
        int bookNum = 10;
        int stepNum = 150;
        try {
            studentNum = Integer.parseInt(args[0]);
            bookNum = Integer.parseInt(args[1]);
            stepNum = Integer.parseInt(args[2]);
        } catch (Exception e) {
            System.out.println("Default input applied!");
        }
        College thisCollege = new College(studentNum, bookNum);
        thisCollege.runCollege(stepNum);
    }
}
