package labjava.pkg500loc;
import java.util.Scanner;

public class mainClass {

    public static Scanner scanner = new Scanner(System.in);

    public static int menu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Add new student");
        System.out.println("2. Update student");
        System.out.println("3. Add new subject");
        System.out.println("4. Update subject");
        System.out.println("5. Enter Grade");
        System.out.println("6. Display Student Grade Report");
        System.out.println("7. Display Subject Grade Report");
        System.out.println("Others- Quit Program");
        System.out.print("Enter your choice: ");
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("=== Goodbye ===");
            System.exit(0);
        }
        return choice;
    }

    public static void main( String[] args ) {
        int choice;
        StudentManager studentManager = new StudentManager();
        SubjectManager subjectManager = new SubjectManager();
        GradeManager gradeManager = new GradeManager(studentManager,subjectManager);
        do {
            choice = menu();
            switch (choice) {
                case 1:{
                    String move;
                    do {
                        studentManager.addStudent();
                        System.out.println("\nDo you want to continue? (Yes/No)");
                        move = scanner.nextLine();
                    } while (move.equals("Yes"));
                    break;
                }

                case 2:{
                    studentManager.updateStudent();
                    break;
                }

                case 3:{
                    String move;
                    do {
                        subjectManager.addSubject();
                        System.out.println("\nDo you want to continue? (Yes/No)");
                        move = scanner.nextLine();
                    } while (move.equals("Yes"));
                    break;
                }

                case 4:{
                    subjectManager.updateSubject();
                    break;
                }

                case 5:{
                    String move;
                    do {
                        gradeManager.addGrade();
                        System.out.println("\nDo you want to continue? (Yes/No)");
                        move = scanner.nextLine();
                    } while (move.equals("Yes"));
                    break;
                }

                case 6:{
                    gradeManager.studentReportGrade();
                    break;
                }

                case 7: {
                    gradeManager.subjectReportGrade();
                    break;
                }
            }
        } while (choice>=1 && choice<=7);

    }
}
