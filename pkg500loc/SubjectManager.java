
package labjava.pkg500loc;

import java.util.ArrayList;
import java.util.Scanner;

public class SubjectManager {
    ArrayList<Subject> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public boolean checkDuplicateSubject(String subjectID) {
        for (Subject subject: list) {
            if (subject.getSubjectID().equals(subjectID)){
                return true;
            }
        }
        return false;
    }

    public void  addSubject() {
        String subjectID;
        String subjectName;
        int credit = 0;
        boolean check;
        do {
            System.out.print("Enter the ID of new Subject: ");
            subjectID = scanner.nextLine();
            check = true;
            if (checkDuplicateSubject(subjectID)) {
                check = false;
                System.out.println("This ID is duplicated!");
            }
        } while (!check);
        System.out.print("Enter the name of new subject: ");
        subjectName = scanner.nextLine();
        do {
            try {
                System.out.print("Enter the credit of subject: ");
                credit = Integer.parseInt(scanner.nextLine());
                check = true;
            } catch (Exception e) {
                check = false;
                System.out.println("CREDIT must be integer!");
            }
            if (credit<=0) {
                System.out.println("CREDIT must be positive integer");
                check = false;
            }
        } while (!check);
        Subject subject = new Subject(subjectID,subjectName,credit);
        list.add(subject);
        System.out.println("===ADD SUBJECT SUCCESSFULLY===");
    }

    public void updateSubject() {
        System.out.print("Enter the subject ID to be updated: ");
        String subjectID = scanner.nextLine();
        if (!checkDuplicateSubject(subjectID)) {
            System.out.println("This Subject does not exist!");
        } else {
            int choice = 0;
            do {
                System.out.println("===UPDATE SUBJECT====");
                System.out.println("1. Update");
                System.out.println("2. Delete");
                System.out.println("3. Back to main menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:{
                        System.out.println("Just press ENTER, then system will not change old information!");
                        Subject subject = null;
                        for (Subject subject1: list) {
                            if (subject1.getSubjectID().equals(subjectID)) {
                                subject = subject1;
                                break;
                            }
                        }
                        String subjectName;
                        int credit = 0;
                        boolean check;
                        System.out.print("Enter the new name of this subject: ");
                        subjectName = scanner.nextLine();
                        if (!subjectName.equals("")){
                            assert subject != null;
                            subject.setSubjectName(subjectName);
                        }
                        do {
                            try {
                                System.out.print("Enter the new credit of this subject: ");
                                String creditStr = scanner.nextLine();
                                credit = Integer.parseInt(creditStr);
                                check = true;
                                if (creditStr.equals("")) {
                                    check = false;
                                    break;
                                }
                            } catch (Exception e) {
                                check = false;
                                System.out.println("CREDIT must be integer!");
                            }
                            if (credit<=0) {
                                System.out.println("CREDIT must be positive integer");
                                check = false;
                            }
                        } while (!check);
                        if (!check) {
                            assert subject != null;
                            subject.setCredit(credit);
                        }
                        System.out.println("===UPDATE SUCCESSFULLY===\n");
                        break;
                    }

                    case 2: {
                        System.out.println("Do you want to delete this subject? (Yes/No)");
                        System.out.print("Answer: ");
                        String answer =scanner.nextLine();
                        if (answer.equals("Yes")) {
                            list.removeIf(subject -> subject.getSubjectID().equals(subjectID));
                            System.out.println("===DELETE SUCCESSFULLY===\n");
                        } else {
                            System.out.println("===DELETE FAIL===\n");
                        }
                        break;
                    }

                    default:{
                        System.out.println("You make a wrong choice!");
                    }
                }
            } while (choice!=3);
        }
    }

    public Subject get(String subjectID) {
        for (Subject subject: list) {
            if (subject.getSubjectID().equals(subjectID))
                return subject;
        }
        return null;
    }
}

