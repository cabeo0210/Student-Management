package labjava.pkg500loc;
public class Student {
    public String studentID;
    public String firstName;
    public String lastName;
    public String gender;
    public String dateOfBirth;
    public String email;
    public String phoneNumber;

    public Student( String studentID, String firstName, String lastName, String gender, String dateOfBirth, String email, String phoneNumber ) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Student() {
        studentID = "";
        firstName ="";
        lastName = "";
        gender = "";
        dateOfBirth = "";
        email = "";
        phoneNumber = "";
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID( String studentID ) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender( String gender ) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth( String dateOfBirth ) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber( String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }
}
