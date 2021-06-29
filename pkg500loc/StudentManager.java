package labjava.pkg500loc;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StudentManager {
    ArrayList<Student> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        String studentID;
        String firstName;
        String lastName;
        String email;
        String phoneNumber;
        String gender;
        String dateOfBirth;
        boolean check = true;
        do {
            System.out.print("Enter the ID of new student: ");
            studentID = scanner.nextLine();
            check = true;
            if (checkDuplicate(studentID)){
                check = false;
                System.out.println("This ID is duplicated! Please enter AGAIN!");
            }
        } while (!check);
        System.out.print("Enter the first name of new student: ");
        firstName = scanner.nextLine();
        System.out.print("Enter the last name of new student: ");
        lastName = scanner.nextLine();
        do {
            System.out.print("Enter the email of new student: ");
            email = scanner.nextLine();
            check = true;
            if (!email.matches("[0-9a-zA-Z]{6,30}@[0-9a-z]{3,15}([.][a-z]{2,15}){1,2}")) {
                check = false;
                System.out.println("Invalid email! Format [abcderf@abc.com(.asd)]");
            }
        } while (!check);
        do {
            System.out.print("Enter the phone number of new student: ");
            phoneNumber = scanner.nextLine();
            check = true;
            if (!phoneNumber.matches("[0-9]{10,12}")) {
                check = false;
                System.out.println("Invalid phone number! Format [digit, 10 -> 12 number]");
            }
        } while (!check);
        do {
            System.out.print("Enter the gender of new student: ");
            gender = scanner.nextLine();
            check = true;
            if (!gender.equals("male") && !gender.equals("female") && !gender.equals("another")) {
                check = false;
                System.out.println("Gender must be: male,female or another!");
            }
        } while (!check);
        do {
            System.out.print("Enter date of birth of new student: ");
            dateOfBirth = scanner.nextLine();
            check = true;
            SimpleDateFormat sdfm = new SimpleDateFormat("dd/MM/yyyy");
            sdfm.setLenient(false);
            try {
                Date date = sdfm.parse(dateOfBirth);
            } catch (Exception e){
                check = false;
                System.out.println("Invalid date! Format [dd/mm/yyyy]");
            }
        } while (!check);
        Student student = new Student(studentID,firstName,lastName,gender,dateOfBirth,email,phoneNumber);
        list.add(student);
        System.out.println("Add successfully");
    }



    public boolean checkDuplicate(String studentID) {
        for (Student student : list) {
            if (student.getStudentID().equals(studentID)) {
                return true;
            }
        }
        return false;
    }

    public void updateStudent() {
        System.out.print("Enter the ID of student to update: ");
        String studentID = scanner.nextLine();
        int choice;
        if (!checkDuplicate(studentID)) {
            System.out.println("The student does not exist");
        } else {
            do {
                System.out.println("====UPDATE OR DELETE MENU====");
                System.out.println("1. Update");
                System.out.println("2. Delete");
                System.out.println("3. Back to menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: {
                        System.out.println("Just press ENTER, then system will not change old information!");
                        Student student = null;
                        for ( Student student1 : list ) {
                            if ( student1.getStudentID().equals(studentID) ) {
                                student = student1;
                                break;
                            }
                        }
                        String firstName;
                        String lastName;
                        String email;
                        String phoneNumber;
                        String gender;
                        String dateOfBirth;
                        boolean check = true;
                        System.out.print("Enter the first name of student: ");
                        firstName = scanner.nextLine();
                        if ( !firstName.equals("") ) {
                            student.setFirstName(firstName);
                        }
                        System.out.print("Enter the last name of student: ");
                        lastName = scanner.nextLine();
                        if ( !lastName.equals("") ) {
                            student.setLastName(lastName);
                        }
                        do {
                            System.out.print("Enter the email of student: ");
                            email = scanner.nextLine();
                            check = true;
                            if ( email.equals("") ) {
                                check = false;
                                break;
                            }
                            if ( !email.matches("[0-9a-zA-Z]{6,30}@[0-9a-z]{3,15}([.][a-z]{2,15}){1,2}") ) {
                                check = false;
                                System.out.println("Invalid email! Format [abcderf@abc.com(.asd)]");
                            }
                        } while (!check);
                        if ( check ) {
                            student.setEmail(email);
                        }
                        do {
                            System.out.print("Enter the phone number of new student: ");
                            phoneNumber = scanner.nextLine();
                            check = true;
                            if ( phoneNumber.equals("") ) {
                                check = false;
                                break;
                            }
                            if ( !phoneNumber.matches("[0-9]{10,12}") ) {
                                check = false;
                                System.out.println("Invalid phone number! Format [digit, 10 -> 12 number]");
                            }
                        } while (!check);
                        if ( check ) {
                            student.setPhoneNumber(phoneNumber);
                        }
                        do {
                            System.out.print("Enter the gender of new student: ");
                            gender = scanner.nextLine();
                            check = true;
                            if ( gender.equals("") ) {
                                check = false;
                                break;
                            }
                            if ( !gender.equals("male") || !gender.equals("female") || !gender.equals("another") ) {
                                check = false;
                                System.out.println("Gender must be: male,female or another!");
                            }
                        } while (!check);
                        if ( check ) {
                            student.setGender(gender);
                        }
                        do {
                            System.out.print("Enter date of birth of new student: ");
                            dateOfBirth = scanner.nextLine();
                            check = true;
                            SimpleDateFormat sdfm = new SimpleDateFormat("dd/MM/yyyy");
                            sdfm.setLenient(false);
                            if ( dateOfBirth.equals("") ) {
                                check = false;
                                break;
                            }
                            try {
                                Date date = sdfm.parse(dateOfBirth);
                            } catch (Exception e) {
                                check = false;
                                System.out.println("Invalid date! Format [dd/mm/yyyy]");
                            }
                        } while (!check);
                        if ( check ) {
                            student.setDateOfBirth(dateOfBirth);
                        }
                        System.out.println("===UPDATE SUCCESSFULLY===\n");
                        break;
                    }

                    case 2: {
                        System.out.println("Do you want to delete this student? (Yes/No)");
                        System.out.print("Answer: ");
                        String answer = scanner.nextLine();
                        if ( answer.equals("Yes") ) {
                            list.removeIf(student -> student.getStudentID().equals(studentID));
                            System.out.println("===DELETE SUCCESSFULLY===\n");
                        } else {
                            System.out.println("===DELETE FAIL===\n");
                        }
                        break;
                    }

                    case 3: {
                        break;
                    }

                    default: {
                        System.out.println("You make a wrong choice!");
                    }
                }
            } while (choice != 3);
        }
    }

    public Student get(String studentID) {
        for (Student student: list) {
            if (student.getStudentID().equals(studentID))
                return student;
        }
        return null;
    }
}
