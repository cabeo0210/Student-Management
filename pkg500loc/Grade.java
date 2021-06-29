package labjava.pkg500loc;
public class Grade {
    public String studentID;
    public String subjectID;
    public double labs=-1;
    public double progressTest=-1;
    public double finalExam=-1;

    public Grade( String studentID, String subjectID, double labs, double progressTest, double finalExam ) {
        this.studentID = studentID;
        this.subjectID = subjectID;
        this.labs = labs;
        this.progressTest = progressTest;
        this.finalExam = finalExam;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID( String studentID ) {
        this.studentID = studentID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID( String subjectID ) {
        this.subjectID = subjectID;
    }

    public double getLabs() {
        return labs;
    }

    public void setLabs( double labs ) {
        this.labs = labs;
    }

    public double getProgressTest() {
        return progressTest;
    }

    public void setProgressTest( double progressTest ) {
        this.progressTest = progressTest;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam( double finalExam ) {
        this.finalExam = finalExam;
    }
}
