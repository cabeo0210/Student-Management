package labjava.pkg500loc;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeManager {
    ArrayList<Grade> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    StudentManager listStudent;
    SubjectManager listSubject;

    public GradeManager( StudentManager listStudent, SubjectManager listSubject ) {
        this.listStudent = listStudent;
        this.listSubject = listSubject;
    }

    public void addGrade() {
        String studentID;
        String subjectID;
        System.out.print("Enter the id of student: ");
        studentID = scanner.nextLine();
        System.out.print("Enter the id of subject: ");
        subjectID = scanner.nextLine();
        if (listStudent.checkDuplicate(studentID) && listSubject.checkDuplicateSubject(subjectID)) {
            double labs=0,progressTest = 0,finalExam=0;
            boolean check;
            boolean checkAll =true;
            for (Grade grade:list) {
                if (grade.getStudentID().equals(studentID) && grade.getSubjectID().equals(subjectID) && (grade.getLabs()>-1)) {
                    checkAll = false;
                    System.out.println("Do you want to overwrite the mark? (Yes/No)");
                    String answer =scanner.nextLine();
                    if (answer.equals("Yes")) {
                        System.out.println("Press ENTER if you don't want to overwrite!");
                        do {
                            System.out.print("Enter labs mark: ");
                            try {
                                String labsStr = scanner.nextLine();
                                if (labsStr.equals("")) {
                                    check = false;
                                    break;
                                }
                                labs = Double.parseDouble(labsStr);
                                check = true;
                            } catch (Exception e) {
                                check = false;
                                System.out.println("Mark must be double!");
                            }
                        } while (!check);
                        if (check) {
                            grade.setLabs(labs);
                        }
                        do {
                            System.out.print("Enter progress tests mark: ");
                            try {
                                String progressTestStr = scanner.nextLine();
                                if (progressTestStr.equals("")) {
                                    check = false;
                                    break;
                                }
                                progressTest = Double.parseDouble(progressTestStr);
                                check = true;
                            } catch (Exception e) {
                                check = false;
                                System.out.println("Mark must be double!");
                            }
                        } while (!check);
                        if (check) {
                            grade.setProgressTest(progressTest);
                        }
                        do {
                            System.out.print("Enter final test mark: ");
                            try {
                                String finalExamStr = scanner.nextLine();
                                if (finalExamStr.equals("")) {
                                    check = false;
                                    break;
                                }
                                finalExam = Double.parseDouble(finalExamStr);
                                check = true;
                            } catch (Exception e) {
                                System.out.println("Mark must be double!");
                                check = false;
                            }
                        } while (!check);
                        if (check) {
                            grade.setFinalExam(finalExam);
                        }
                        break;
                    }
                    else {
                        System.out.println("===NOTHING HAPPENED===\n");
                    }
                    break;
                }
            }
            if (checkAll) {
                do {
                    System.out.print("Enter labs mark: ");
                    try {
                        labs = Double.parseDouble(scanner.nextLine());
                        check = true;
                    } catch (Exception e) {
                        check = false;
                        System.out.println("Mark must be double!");
                    }
                } while (!check);
                do {
                    System.out.print("Enter progress tests mark: ");
                    try {
                        progressTest = Double.parseDouble(scanner.nextLine());
                        check = true;
                    } catch (Exception e) {
                        check = false;
                        System.out.println("Mark must be double!");
                    }
                } while (!check);
                do {
                    System.out.print("Enter final test mark: ");
                    try {
                        finalExam = Double.parseDouble(scanner.nextLine());
                        check = true;
                    } catch (Exception e) {
                        System.out.println("Mark must be double!");
                        check = false;
                    }
                } while (!check);
                Grade grade = new Grade(studentID, subjectID, labs, progressTest, finalExam);
                list.add(grade);
                System.out.println("===ADD SUCCESSFULLY===\n");
            }
        }
    }

    public void studentReportGrade() {
        System.out.print("Enter the ID of student: ");
        String studentID = scanner.nextLine();
        if (!listStudent.checkDuplicate(studentID)){
            System.out.println("Student does not exist");
        } else {
            System.out.println("- Student ID: " + studentID);
            System.out.println("- Student name: "+ listStudent.get(studentID).getFirstName()+" "+listStudent.get(studentID).getLastName());
            System.out.println("List of subject sort by Subject Name: ");
            System.out.printf("%9s%30s%25s%25s\n","| ++ No ++ |"," +++++++ Subject name +++++++ ","| +++ Average mark +++ |"," +++ Status +++ |");
            ArrayList<Grade> listResult = new ArrayList<>();
            for (Grade grade:list) {
                if (grade.getStudentID().equals(studentID)) {
                    listResult.add(grade);
                }
            }
            printStudentReport(listResult);
        }
    }

    public void printStudentReport(ArrayList<Grade> listGrade) {
        for (int i=0;i<listGrade.size();i++) {
            for (int j =i+1;j<listGrade.size();j++){
                Grade grade1 = listGrade.get(i);
                Grade grade2 = listGrade.get(j);
                if (listSubject.get(grade1.getSubjectID()).getSubjectName().compareTo(listSubject.get(grade2.getSubjectID()).getSubjectName())>0) {
                    Grade grade = grade1;
                    grade1 = grade2;
                    grade2 = grade;
                }
            }
        }

        int i =0;
        for (Grade grade: listGrade){
            Subject subject = listSubject.get(grade.getSubjectID());
            i++;
            double averageMark = grade.getFinalExam()*0.4+grade.getLabs()*0.3+grade.getProgressTest()*0.3;
            String status;
            if (averageMark<=4)
                status = "Not Pass";
            else
                status = "Pass";
            System.out.printf("%9s%30s%25s%25s\n",(i+"     "),(subject.getSubjectName()+"        "),(averageMark+"        "),(status+"         "));
        }
    }

    public void subjectReportGrade() {
        System.out.print("Enter the ID of subject: ");
        String subjectID = scanner.nextLine();
        if (!listSubject.checkDuplicateSubject(subjectID)) {
            System.out.println("Subject does not exist");
        } else {
            System.out.println("- Subject ID: "+subjectID);
            System.out.println("- Subject name: "+listSubject.get(subjectID).getSubjectName());
            System.out.println("List of student sort by Student Name: ");
            System.out.printf("%20s%30s%25s%25s\n","| ++ Student ID ++ |"," +++++++ Student name +++++++ ","| +++ Average mark +++ |"," +++ Status +++ |");
            ArrayList<Grade> listResult = new ArrayList<>();
            for (Grade grade: list) {
                if (grade.getSubjectID().equals(subjectID)) {
                    listResult.add(grade);
                }
            }

            printSubjectReport(listResult);
        }
    }

    public void printSubjectReport(ArrayList<Grade> listGrade) {
        for (int i =0;i<listGrade.size();i++) {
            for (int j=i+1;j<listGrade.size();j++) {
                Grade grade1 = listGrade.get(i);
                Grade grade2 = listGrade.get(j);
                if (listStudent.get(grade1.getStudentID()).getFirstName().compareTo(listStudent.get(grade2.getStudentID()).getFirstName())>0) {
                    Grade grade = grade1;
                    grade1 = grade2;
                    grade2 = grade;
                }
            }
        }

        for (Grade grade: listGrade) {
            Student student = listStudent.get(grade.getStudentID());
            double averageMark = grade.getFinalExam()*0.4+grade.getLabs()*0.3+grade.getProgressTest()*0.3;
            String status;
            if (averageMark<=4)
                status = "Not Pass";
            else
                status = "Pass";
            System.out.printf("%20s%30s%25s%25s\n",(student.getStudentID()+"       "),(student.getFirstName()+" "+student.getLastName()+"          "),(averageMark+"       "),(status+"       "));
        }
    }
}
