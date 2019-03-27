package sample;

public class StudentRecord {

    public String sid;
    public Float assignments;
    public Float midterm;
    public Float finals;

    public StudentRecord(String sid, Float assignments, Float midterm, Float finals) {
        this.sid = sid;
        this.assignments = assignments;
        this.midterm = midterm;
        this.finals = finals;
    }

    public String getSid() {
        return this.sid;
    }

    public Float getAssignments() {
        return this.assignments;
    }

    public Float getMidterm() {
        return this.midterm;
    }

    public Float getFinals() {
        return this.finals;
    }


}
