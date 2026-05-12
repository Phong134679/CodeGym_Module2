package Model;

import Model.Entities.Student;
import Model.Entities.Subject;

public class ScoreBoard {
    public ScoreBoard(Student student, Subject subject) {
        this.student = student;
        this.subject = subject;
    }

    public void setMidTermScore(Double midTermScore) {
        this.midTermScore = midTermScore;
    }

    public void setFinalTermScore(Double finalTermScore) {
        this.finalTermScore = finalTermScore;
    }

    private Student student;
    private Subject subject;
    private Double midTermScore, finalTermScore, avgScore;
}
